package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected Actions actions;


    protected PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void waitAndClick(WebElement element, int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String waitAndGetText(WebElement element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void sendKeys(WebElement element, CharSequence... keys) {
        element.sendKeys(keys);
    }

    protected void waitAndSendKeys(WebElement element, int time, CharSequence... keys) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    }

    protected void clear(WebElement element) {
        element.clear();
    }

    protected void waitAndClear(WebElement element, int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void selectOptionByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    protected boolean invisibilityOf(WebElement element, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitAndHoverOver(WebElement element, int time) {
        actions.moveToElement(
                new WebDriverWait(driver, Duration.ofSeconds(time))
                        .until(ExpectedConditions.visibilityOf(element))
        ).perform();
    }

    protected WebElement presenceOfElement(By locator, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        click(findElement(locator));
    }

    protected void waitAndClick(By locator, int time) {
        waitAndClick(findElement(locator), time);
    }

}





