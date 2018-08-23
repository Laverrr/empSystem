package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Employee;
import pojo.Projects;
import service.IEmployeeService;
import service.IProjectService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/result/")
public class ResultController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IProjectService iProjectService;



    @RequestMapping("searchByName.do")
    public String searchByName(Model model, Employee employee){
        List<Employee> employees = iEmployeeService.searchByName(employee);
        List<Projects> projectsList = iProjectService.list();
        model.addAttribute("projectsList",projectsList);
        model.addAttribute("employees",employees);
        return "employeeSearchForm";
    }
    @RequestMapping("searchByProjectName.do")
    public String searchByProjectName(Model model,String ProjectId){
        Set<Employee> employees = iEmployeeService.searchByProjectId(ProjectId);
        List<Projects> projectsList = iProjectService.list();
        model.addAttribute("projectsList",projectsList);
        model.addAttribute("employees",employees);
        return "employeeSearchForm";
    }

}
