package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/page/")
public class PageController {


    @RequestMapping("searchPage.do")
    public String searchPage( HttpSession session){

        return "employeeSearchForm";
    }
    @RequestMapping("detail.do")
    public String detailPage( HttpSession session){

        return "employeeDetails";
    }



}
