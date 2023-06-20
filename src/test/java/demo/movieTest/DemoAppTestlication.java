package demo.movieTest;

import demo.movie.controller.MovieController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Date 2023/6/20 11:23
 * @注释
 */
@SpringBootTest(classes = DemoAppTestlication.class)
public class DemoAppTestlication {

    @Autowired
    MovieController movieController;

    @Test
    public void testDemo() {
        System.out.println("测试返回的数据：");
    }
}
