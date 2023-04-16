package hello.hellospring.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello";
    }
    // View 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    // API 방식은 View 필요없음
    @GetMapping("hello-string")
//    http = head + body; http body에 return 정보를 직접 넣어주기위해 필요.
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // API 방식 예시
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체(hello)를 return할때 @ResponseBody를 사용하면 JSON 리턴이 기본.
        // shows {"name" : "hiii"} on the page. JSON TYPE
    }

    //can be used as HelloController.Hello
    static class Hello {
        private String name; // name => Key.
        // Getter + Setter는 JavaBeans Specification
        // Property 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }




}
