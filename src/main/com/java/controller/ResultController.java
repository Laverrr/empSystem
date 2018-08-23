package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Employee;
import service.IEmployeeService;

import java.util.List;

@Controller
@RequestMapping("/result/")
public class ResultController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping("search.do")
    public String searchByName(Model model, Employee employee){
//        System.out.println(employee.toString());
        List<Employee> employees = iEmployeeService.searchByName(employee);
        model.addAttribute("employees",employees);
        return "employeeSearchResults";
    }

}
