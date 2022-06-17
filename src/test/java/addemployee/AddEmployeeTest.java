package addemployee;

import base.BaseTest;
import dto.AddEmployeeData;
import dto.AddEmployeeDataBuilder;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddEmployeeTest extends BaseTest {

    @Test(groups = {"AddEmployeeTest.login-prerequisites"})
    public void addEmployeeWithLoginCredentials() {
        AddEmployeeData employeeData = new AddEmployeeDataBuilder()
                .firstname("fede")
                .lastname("lopez")
                .id("999")
                .photoPath(System.getProperty("user.dir") + "/testfiles/employeeimage1.jpg")
                .addCredentials()
                .username("fedelop20")
                .password("felopez1234")
                .confirmPassword("felopez1234")
                .build();

        boolean correctAddition = loginPage.loginWithDefaultAdminCredentials()
                .goToAddEmployeePage()
                .fillDataFields(employeeData)
                .clickSave().verify();

        assertTrue(correctAddition, "error in the save process");
    }

}
