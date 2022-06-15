package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    @FindBy(id = "txtUsername")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    private WebElement submitButton;

    @FindBy(id = "spanMessage")
    private WebElement failedLoginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password){
        waitAndSendKeys(usernameField, 3, username);
        waitAndSendKeys(passwordField, 3, password);
        waitAndClick(submitButton, 3);
    }

    public void loginWithDefaultAdminCredentials(){
        login("Admin", "admin123");
    }

    public String getFailedLoginMessageText(){
        return waitAndGetText(failedLoginMessage, 3);
    }

    public String loginWithWrongCredentials(String username, String password){
        login(username, password);
        return getFailedLoginMessageText();
    }


}
