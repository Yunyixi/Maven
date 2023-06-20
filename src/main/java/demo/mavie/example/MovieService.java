package demo.movie.example;

import demo.movie.entity.Movie;
import demo01.jdbc.example.BaseDao;

import java.util.List;

/**
 * 使用BaseDao类
 * 查询数据库的电影数据，数据库的所有操作
 * 电影的数据库服务类，关于增删查改
 */
public class MovieService {
    BaseDao baseDao = new BaseDao();

    /*//按id查询数据库的数据
    public Student getStudentId01(int id) {
        String sql = "select * from student where id=?";
        Object[] objects = {id};
        List<Movie> movieList = baseDao.executeQuery(sql, objects, Student.class);
        if (movieList.size() > 0) {
            movie = movieList.get(0);
        }
        return movie;
    }*/

    //查询所有的数据
    public List<Movie> queryAllmovie() {
        String sql = "select * from movie";
        Object[] objects = {}; //这里的参数去替换问号，没有问号就空着
        List<Movie> movieList = baseDao.executeQuery(sql, objects, Movie.class);
        return movieList;
    }

    //座位表查询与打印
    public Seat querySeat(String roomType) {
        String sql = "select * from seat where room_type=?";
        Object[] objects = {roomType}; //这里的参数去替换问号，没有问号就空着
        List<Seat> seatList = baseDao.executeQuery(sql, objects, Seat.class);
        if (seatList.size() > 0) {
            return seatList.get(0);
        }
        return null;
    }

    public void addTicket(Ticket ticket) {
        String sql = "insert into ticket value(?,?,?,?)";
        Object[] objects = {ticket.getMovieName(), ticket.getShowTime(), ticket.getSeat(), ticket.getRoom()}; //这里的参数去替换问号，没有问号就空着
        baseDao.executeUpdate(sql, objects);

    }
    /*public boolean queryTicket(Ticket ticket){
        String sql = "select * from tickert where show_type=? and room=?";
        Object[] objects = {ticket}; //这里的参数去替换问号，没有问号就空着
        List<Seat> seatList = baseDao.executeQuery(sql, objects, Movie.class);
        if (seatList.size() > 0) {
            return false;
        }
        return true;
    }*/


}
