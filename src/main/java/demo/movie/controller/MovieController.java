package demo.movie.controller;

import demo.movie.entity.Movie;
import demo.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date 2023/6/20 9:48
 * @注释 movie项目的控制接口类
 */
@RestController //告诉Spring Boot 这是一个接口类，返回json数据
public class MovieController {

    @Autowired
    private MovieService movieService;

    //简单的查询电影接口---返回数据库电影数据
    @GetMapping("list")
    public List<Movie> list() {
        List<Movie> movieList = movieService.queryAllmovie();
        return movieList;
    }

    @GetMapping("hello") //接口访问的url地址
    public String testApi() {
        System.out.println("成功调用我的测试接口");
        return "测试成功";
    }

}
