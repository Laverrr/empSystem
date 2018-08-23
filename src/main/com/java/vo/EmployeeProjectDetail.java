package vo;

import pojo.Projects;

import java.util.List;

public class EmployeeProjectDetail {

	private Projects project;
	private List<ProjectRole> projectRoles;

	public List<ProjectRole> getProjectRoles() {
		return projectRoles;
	}

	public void setProjectRoles(List<ProjectRole> projectRoles) {
		this.projectRoles = projectRoles;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

}
