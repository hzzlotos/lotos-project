package cn.newtouch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController
{
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model)
    {
        String word0 = "Hello";
        String word1 = "World!";
        // 將數據添加到視圖數據容器中
        model.addAttribute("word0", word0);
        model.addAttribute("word1", word1);
        return "helloWorld.ftl";
    }
}