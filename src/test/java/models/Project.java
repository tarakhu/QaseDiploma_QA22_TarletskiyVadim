package models;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Project {

    private final String projectName;
    private final String projectCode;
//    private final String projectDescription;
//    private final String projectAccessType;
//    private final String projectMemberAccess;

    private Project(ProjectBuilder projectBuilder) {
        this.projectName = projectBuilder.projectName;
        this.projectCode = projectBuilder.projectCode;
//        this.projectDescription = projectBuilder.projectDescription;
//        this.projectAccessType = projectBuilder.projectAccessType;
//        this.projectMemberAccess = projectBuilder.projectMemberAccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName) && Objects.equals(projectCode, project.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, projectCode);
    }

    public static class ProjectBuilder {
        private String projectName;
        private String projectCode;
//        private String projectDescription;
//        private String projectAccessType;
//        private String projectMemberAccess;

        public ProjectBuilder(String projectName, String projectCode) {
            this.projectName = projectName;
            this.projectCode = projectCode;
        }

//        public ProjectBuilder setProjectDescription(String projectDescription) {
//            this.projectDescription = projectDescription;
//            return this;
//        }
//
//        public ProjectBuilder setProjectAccessType(String projectAccessType) {
//            if (this.projectAccessType == "private") {
//                this.projectAccessType = projectAccessType;
//            }
//            return this;
//        }
//
//        public ProjectBuilder setProjectMemberAccess(String projectMemberAccess) {
//            this.projectMemberAccess = projectMemberAccess;
//            return this;
//        }

        public Project build() {
            return new Project(this);
        }
    }
}

