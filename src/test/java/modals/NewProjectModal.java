package modals;

import elements.Input;
import elements.Textarea;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectModal extends BaseModal {

    private final static By CANCEL_BUTTON_FOR_NEW_PROJECT = By.xpath("//span[text()='Cancel']/ancestor::button");
    private final static By CREATE_BUTTON_FOR_NEW_PROJECT = By.xpath("//button[@type='submit']");

    public NewProjectModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Project project) {

        new Input(driver, "project-name").setValueForInput(project.getProjectName());
        new Input(driver, "project-code").setValueForCodeInput(project.getProjectCode());
//        new Textarea(driver, "description-area").setValue(project.getProjectDescription());
//        new Input(driver, "private").setValueForInput(project.getProjectAccessType());
//        new Input(driver, "project-name").setValueForInput(project.getProjectMemberAccess());

    }
}
