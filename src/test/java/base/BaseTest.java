package base;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;
import pages.LoginPage;
import utils.EventListener;
import utils.Reporter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.TimeZone;


public class BaseTest {

    protected LoginPage loginPage;

    private static String browser;
    private static String environment;
    private WebDriver driver;
    private WebDriver originalDriver;
    private Reporter reporter;
    private ExtentTest extentTest;

    @BeforeSuite
    @Parameters({"browser", "env"})
    public void getDriver(
            XmlTest xmlTest,
            @Optional(value = "chrome") String browser,
            @Optional(value = "local") String env
    ) {
        BaseTest.browser = browser;
        environment = env;
    }


    @BeforeClass
    public void getDriver(XmlTest xmlTest) {
        if (environment.equalsIgnoreCase("local")) {
            reporter = new Reporter(xmlTest.getSuite().getName() + " " + getCurrentDateUTC());
            getLocalDriver();
        }
    }


    @BeforeMethod
    public void setUp(Method method, ITestResult iTestResult) {
        extentTest = reporter.newTest(method.getName(), iTestResult.getTestClass().getName());
        driver = new EventFiringDecorator(new EventListener(extentTest)).decorate(originalDriver);

        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");


    }


    @AfterMethod
    public void recordFailure(Method method, ITestResult iTestResult) {
        if (iTestResult.isSuccess()) {
            extentTest.pass(method.getName() + " pass!!!");
        } else {
            var camera = (TakesScreenshot) driver;
            var screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("./screenshots/" + method.getName() + ".png"));
                System.out.println("/n/n/n/n/n/n/n/n/n/n/n/n/n/n/n/n" + screenshot.getPath());
            } catch (IOException e) {
                extentTest.fail(e.getMessage());
            }


            extentTest.fail(method.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @AfterSuite
    public void saveReport() {
        reporter.closeTest();
    }


    public void getLocalDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            originalDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            originalDriver = new FirefoxDriver();
        }
    }

    public String getCurrentDateUTC(){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        timeFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return timeFormatter.format(new Date());
    }


}
