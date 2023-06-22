package demo01.jdbc.example;

import java.util.List;

public class demo01 {
    public static void main(String[] args) {
        //BaseDao使用
        BaseDaoService baseDaoService = new BaseDaoService();
        List<Student> studentList = baseDaoService.getStudentId02();
        System.out.println("*-MySql查询表所有数据：");
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
}
