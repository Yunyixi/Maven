package demo.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/6/20 9:48
 * @注释
 */
@RestController //告诉Spring Boot 这是一个接口类，返回json数据
public class MovieController {

    @GetMapping("hello") //接口访问的url地址
    public String testApi() {
        System.out.println("成功调用我的测试接口");
        return "测试成功";
    }

}
