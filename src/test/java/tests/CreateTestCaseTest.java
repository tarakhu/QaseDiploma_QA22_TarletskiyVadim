package tests;

import com.github.javafaker.Faker;
import enums.*;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateTestCaseTest extends BaseTest {

    @DataProvider(name = "New test case")
    public Object[][] newTestCasesData() {
        Faker faker = new Faker();
        return new Object[][] {
                {new TestCase.TestCaseBuilder("This is title", Status.ACTUAL, Severity.CRITICAL, Priority.HIGH,
                        Type.FUNCTIONAL, Layer.NOT_SET, IsFlaky.NO, Behavior.NOT_SET, AutomationStatus.AUTOMATED)
                        .setDescription("Some description")
//                        .setPreConditions("hi")
//                        .setPostConditions("by")
                        .build()},
                {new TestCase.TestCaseBuilder("NEXT", Status.DEPRECATED, Severity.MAJOR, Priority.HIGH,
                        Type.FUNCTIONAL, Layer.NOT_SET, IsFlaky.NO, Behavior.NOT_SET, AutomationStatus.AUTOMATED)
                        .setDescription("LALALA")
                        .setPreConditions("hi")
                        .setPostConditions("by")
                        .build()}
                };
        }


    @Test(dataProvider = "New test case")
    public void createTestCaseTest(TestCase testCase) throws InterruptedException {

        loginPage.setUsername(USER_NAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectPage.waitForCreateNewProjectsButtonIsDisplayed();

        projectPage.clickToProject("Project For Tests");
        projectDetailsPage.waitForCreateCaseButtonIsDisplayed();

        projectDetailsPage.clickToCreateCase();
        createNewTestCasePage.waitForSaveButtonIsDisplayed();

        createNewTestCasePage.fillForm(testCase);
        createNewTestCasePage.clickToSaveCaseButton();
        projectDetailsPage.waitForCreateCaseButtonIsDisplayed();

        projectDetailsPage.clickToCreatedCase(testCase);

        Assert.assertEquals(createdCaseModal.getTestCaseDetails(), testCase);



        }
    }

