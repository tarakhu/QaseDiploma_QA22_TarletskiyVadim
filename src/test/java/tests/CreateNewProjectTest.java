package tests;

import com.github.javafaker.Faker;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewProjectTest extends BaseTest {

    @DataProvider(name = "new Project")
    public Object[][] newTestProjectsData() {
        Faker faker = new Faker();
        return new Object[][] {
                {new Project.ProjectBuilder("ghghgh", "yujffuj")
//                        .setProjectDescription("this is description")
//                        .setProjectAccessType("private")
//                        .setProjectMemberAccess("none")
                        .build()},
                {new Project.ProjectBuilder("ddd", "code")
//                        .setProjectDescription("sdsdsssssssssss")
//                        .setProjectAccessType("public")
//                        .setProjectMemberAccess("none")
                        .build()},
                };
        }


    @Test(dataProvider = "new Project")
    public void createNewProjectTest(Project project) throws InterruptedException {



        loginPage.setUsername(USER_NAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectPage.waitForCreateNewProjectsButtonIsDisplayed();

        projectPage.clickCreateNewProjectButton();
        newProjectModal.fillForm(project);
        Thread.sleep(5000);
        newProjectModal.clickCreateButton();
        Thread.sleep(5000);

        Assert.assertEquals(projectDetailsPage.getProjectDetails(), project);

    }
}
