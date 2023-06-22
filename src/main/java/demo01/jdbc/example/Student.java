package demo01.jdbc.example;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String classroom;
    private int age;

    public Student() {
    }

    public Student(int id, String name, String gender, String classroom, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classroom = classroom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "学生：" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classroom='" + classroom + '\'' +
                ", age=" + age;
    }
}
