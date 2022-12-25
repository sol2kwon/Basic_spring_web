package mini_project.mini_project_solyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
//MVC
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
//API
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("name",name);
        return "hello" + name;
    }

    //API json 객체 넘기기
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //프로퍼티 접근 방식, java bin
    static class Hello {
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

}
