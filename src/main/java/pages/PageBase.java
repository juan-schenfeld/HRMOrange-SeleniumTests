package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;

    protected PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element){
        element.click();
    }

    public void waitAndClick(WebElement element, int time){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String waitAndGetText(WebElement element, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void sendKeys(WebElement element, CharSequence... keys){
        element.sendKeys(keys);
    }

    public void waitAndSendKeys(WebElement element, int time, CharSequence... keys){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    }

    public void clear(WebElement element){
        element.clear();
    }

    public void waitAndClear(WebElement element, int time){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOf(element));
    }


}





