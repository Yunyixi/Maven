package demo.movie.service;

import demo.movie.entity.Movie;
import demo.movie.util.BaseDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2023/6/20 10:26
 * @注释 movie的服务类
 */
@Service //表示这是一个服务类，并交由Spring Boot管理
public class MovieService {
    BaseDao baseDao = new BaseDao();

    //查询数据库的电影数据
    public List<Movie> queryAllmovie() {
        String sql = "select * from movie";
        Object[] objects = {}; //这里的参数去替换问号，没有问号就空着
        List<Movie> movieList = baseDao.executeQuery(sql, objects, Movie.class);
        return movieList;
    }

}
