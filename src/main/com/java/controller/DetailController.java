package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Employee;
import pojo.EmployeeProjectMap;
import pojo.EmployeeSkillMap;
import pojo.Projects;
import service.IEmployeeProjectMapService;
import service.IEmployeeService;
import vo.EmployeeDetail;
import vo.EmployeeDetailVo;


@Controller
@RequestMapping("/detail/")
public class DetailController {



    @Autowired
    private IEmployeeProjectMapService iEmployeeProjectMapService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping("detail.do")
    public String detailPage(Model model,int id){
        Employee employee = iEmployeeService.selectById(id);
        EmployeeDetailVo employeeDetailVo = iEmployeeProjectMapService.getEmployeeDetailVo(String.valueOf(id));
        model.addAttribute("projectList",employeeDetailVo.getProjectList());
        model.addAttribute("skillList",employeeDetailVo.getSkillList());
        model.addAttribute("employee",employee);
        return "employeeDetails";
    }








}
