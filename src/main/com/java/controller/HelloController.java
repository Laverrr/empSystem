package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/system/")
public class HelloController {


    @RequestMapping("hello.do")
    public String sayHello( HttpSession session){
//        if (iHelloService.sayHello(person)){
//                session.setAttribute("message","Hello "+person.getUsername());
//            }else {
//                session.setAttribute("message","login filed");
//        }
        return "employeeSearchForm";
//        iHelloService.sayHello("L");
    }


}
