package demo01.jdbc.example;

import java.util.List;

/**
 * 使用BaseDao类
 */
public class BaseDaoService {
    BaseDao baseDao = new BaseDao();
    Student student = null;

    //按id查询数据库的数据
    public Student getStudentId01(int id) {
        String sql = "select * from student where id=?";
        Object[] objects = {id};
        List<Student> studentList = baseDao.executeQuery(sql, objects, Student.class);
        if (studentList.size() > 0) {
            student = studentList.get(0);
        }
        return student;
    }

    //查询所有的数据
    public List<Student> getStudentId02() {
        String sql = "select * from student";
        Object[] objects = {};
        List<Student> studentList = baseDao.executeQuery(sql, objects, Student.class);
        return studentList;
    }

}
