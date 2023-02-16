package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        loginPage.setUsername(USER_NAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();

        projectPage.waitForCreateNewProjectsButtonIsDisplayed();
        Assert.assertTrue(projectPage.isCreateNewProjectButtonDisplayed());
    }
}