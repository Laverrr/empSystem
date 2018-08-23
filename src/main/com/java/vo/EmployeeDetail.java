package vo;

import pojo.Employee;
import pojo.EmployeeSkillMap;

import java.util.List;

public class EmployeeDetail {

	private Employee employee;
	private List<EmployeeProjectDetail> projectList;
	private List<EmployeeSkillMap> skillList;
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<EmployeeProjectDetail> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<EmployeeProjectDetail> projectList) {
		this.projectList = projectList;
	}

	public List<EmployeeSkillMap> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<EmployeeSkillMap> skillList) {
		this.skillList = skillList;
	}

	
	
	
	
	

}
