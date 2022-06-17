package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticatedPage extends PageBase {

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimPageLink;
    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployeePageLink;
    @FindBy(id = "menu_pim_viewEmployeeList")
    private WebElement employeeListPageLink;

    protected AuthenticatedPage(WebDriver driver) {
        super(driver);
    }

    private void selectPimMenu() {
        waitAndHoverOver(pimPageLink, 3);
    }

    public AddEmployeePage goToAddEmployeePage() {
        selectPimMenu();
        waitAndClick(addEmployeePageLink, 5);
        return new AddEmployeePage(driver);
    }

    public EmployeeListPage goToEmployeeListPage() {
        selectPimMenu();
        waitAndClick(employeeListPageLink, 5);
        return new EmployeeListPage(driver);
    }
}
