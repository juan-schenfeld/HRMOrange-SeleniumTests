package pages;

import dto.AddEmployeeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage extends PageBase{

    @FindBy(id = "firstName")
    private WebElement firstnameField;
    @FindBy(id = "middleName")
    private WebElement middlenameField;
    @FindBy(id = "lastName")
    private WebElement lastnameField;
    @FindBy(id = "employeeId")
    private WebElement idField;
    @FindBy(id = "photofile")
    private WebElement photographField;
    @FindBy(id = "chkLogin")
    private WebElement withLoginCredentialsCheckbox;
    @FindBy(id = "user_name")
    private WebElement usernameField;
    @FindBy(id = "user_password")
    private WebElement passwordField;
    @FindBy(id = "re_password")
    private WebElement confirmPasswordField;
    @FindBy(id = "status")
    private WebElement statusSelect;
    @FindBy(id = "btnSave")
    private WebElement saveButton;

    protected AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public AddEmployeePage fillDataFields(AddEmployeeData data){
        fillDataField(firstnameField, data.getFirstname());
        fillDataField(middlenameField, data.getMiddlename());
        fillDataField(lastnameField, data.getLastname());
        fillDataField(idField, data.getId());
        fillDataField(photographField, data.getPhotographPath());
        if (data.isWithCredentials()){
            fillCredentials(data);
        }
        return this;
    }

    private void fillCredentials(AddEmployeeData data){
        click(withLoginCredentialsCheckbox);
        fillDataField(usernameField, data.getUsername());
        fillDataField(passwordField, data.getPassword());
        fillDataField(confirmPasswordField, data.getConfirmPassword());
        if (data.isDisabled()){
            selectOptionByIndex(statusSelect, 2);
        }
    }

    private void fillDataField(WebElement field, String data){
        if (data != null){
            clear(field);
            sendKeys(field, data);
        }
    }

    public AddEmployeePage clickSave(){
        click(saveButton);
        return this;
    }

    public boolean verify(){
        return presenceOfElement(By.linkText("Personal Details"), 10) != null;
    }


}
