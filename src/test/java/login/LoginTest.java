package login;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithAdminCredentials(){
        loginPage.loginWithDefaultAdminCredentials();
    }

    @Test(dataProvider = "invalid-login-credentials")
    public void loginWithInvalidCredentials(String username, String password, String expectedErrorMessage){
        String errorMessage = loginPage.loginWithWrongCredentials(username, password);
        assertEquals(errorMessage, expectedErrorMessage, "incorrect error message");
    }




    @DataProvider(name = "invalid-login-credentials")
    public Object[][] invalidLoginCredentials(){
        Object[][] data = new Object[3][3];
        data[0][0] = "asdf";  data[0][1] = "jkl"; data[0][2] = "Invalid credentials";
        data[1][0] = ""; data[1][1] = "admin123"; data[1][2] = "Username cannot be epty";
        data[2][0] = "Admin"; data[2][1] = ""; data[2][2] = "Password cannot be empty";

        return data;
    }
}
