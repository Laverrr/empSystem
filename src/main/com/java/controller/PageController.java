package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Employee;
import pojo.Projects;
import service.IEmployeeService;
import service.IProjectService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/page/")
public class PageController {

    @Autowired
    private IProjectService iProjectService;




    @RequestMapping("searchPage.do")
    public String searchPage(Model model, HttpSession session){
        List<Projects> projectsList = iProjectService.list();
        model.addAttribute("projectsList",projectsList);
        return "employeeSearchForm";
    }




}
