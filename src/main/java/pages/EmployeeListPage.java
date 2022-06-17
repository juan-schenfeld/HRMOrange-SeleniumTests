package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage extends AuthenticatedPage {

    @FindBy(id = "empsearch_employee_name_empName")
    private WebElement employeeNameField;
    @FindBy(id = "empsearch_id")
    private WebElement idField;
    @FindBy(id = "searchBtn")
    private WebElement searchButton;
    @FindBy(id = "btnDelete")
    private WebElement deleteButton;
    @FindBy(id = "dialogDeleteBtn")
    private WebElement confirmDeleteButton;
    @FindBy(xpath = "//*[@id=\"frmList_ohrmListComponent\"]/div[2]")
    private WebElement correctDeleteMessage;

    protected EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    public EmployeeListPage fillEmployeeName(String name) {
        waitAndSendKeys(employeeNameField, 4, name);
        return this;
    }

    public EmployeeListPage fillId(String id) {
        waitAndSendKeys(idField, 4, id);
        return this;
    }

    public EmployeeListPage clickSearch() {
        click(searchButton);
        return this;
    }

    public EmployeeListPage selectEmployee(int index) {
        waitAndClick(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + index + "]/td/input"), 3);
        return this;
    }

    public EmployeeListPage clickDelete() {
        waitAndClick(deleteButton, 5);
        return this;
    }

    public EmployeeListPage confirmDelete() {
        waitAndClick(confirmDeleteButton, 5);
        return this;
    }

    public boolean verifyCorrectDelete() {
        return waitAndGetText(correctDeleteMessage, 2).equals("Successfully Deleted");
    }


}
