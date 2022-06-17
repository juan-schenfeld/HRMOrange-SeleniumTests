package removeemployee;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RemoveEmployeeTest extends BaseTest {

    @Test(dependsOnGroups = {"AddEmployeeTest.login-prerequisites"})
    public void removeEmployee(){
        boolean result = loginPage.loginWithDefaultAdminCredentials()
                .goToEmployeeListPage()
                .fillId("999")
                .clickSearch()
                .selectEmployee(1)
                .clickDelete()
                .confirmDelete()
                .verifyCorrectDelete();

        assertTrue(result, "the delete has failed");
    }


}
