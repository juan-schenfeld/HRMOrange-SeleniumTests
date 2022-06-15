package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

public class EventListener implements WebDriverListener {

    ExtentTest test;

    public EventListener(ExtentTest test) {
        this.test = test;
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
        test.info("going to " + url);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        test.info("searching element " + locator.toString());
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        test.info("searching elements " + locator.toString());
    }

    @Override
    public void beforeClose(WebDriver driver) {
        WebDriverListener.super.beforeClose(driver);
        test.info("closing current tab");
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        WebDriverListener.super.beforeQuit(driver);
        test.info("closing browser session");
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        test.info("clicking element" + element.getAccessibleName());
    }

    @Override
    public void beforeSubmit(WebElement element) {
        WebDriverListener.super.beforeSubmit(element);
        test.info("submitting " + element.getAccessibleName());
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        test.info("sending keys " + Arrays.toString(keysToSend));
    }

    @Override
    public void beforeClear(WebElement element) {
        WebDriverListener.super.beforeClear(element);
        test.info("clearing " + element.getAccessibleName());
    }
}
