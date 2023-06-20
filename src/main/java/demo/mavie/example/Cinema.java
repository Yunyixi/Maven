package demo.movie.example;

import demo.movie.entity.Movie;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//售票流程
public class Cinema {
    private List<Movie> movieList = new ArrayList();
    private List<Ticket> ticketList = new ArrayList();
    private MovieService movieService = new MovieService();
    private Scanner scanner = new Scanner(System.in);
    private Movie movie; //选择的电影变量
    private String seatNO; //座位的变量

    public void start() {
        init();//初始化数据
        //while (true) {
        showMoive(); //展示电影
        //}
        choiseSeat(); //选择座位和选择电影
        //buyTickets();//购票*/
    }


    private void init() {
        /*
        movieList.add(new Movie("功 夫      ", "周星驰", "周星驰", "剧情 / 搞笑", 30, "12:11", "大厅12-1", " IMAX", " 2D"));
        movieList.add(new Movie("流浪地球   ", "吴 京", "吴 京", "剧情 / 科幻", 35, "14:11", "大厅12-1", " IMAX", " 2D"));
        movieList.add(new Movie("肖申克的救赎", "弗兰克", "蒂 姆", "剧情 / 犯罪", 35, "16:11", "大厅12-1", " IMAX", " 2D"));
        movieList.add(new Movie("泰坦尼克号   ", "詹姆斯", "莱昂纳多", "剧情 / 爱情", 45, "18:11", "大厅12-1", " IMAX", " 2D"));
        movieList.add(new Movie("杀手不太冷   ", " 吕克 ", "让·雷诺", "剧情 / 动作", 35, "20:11", "大厅12-1", " IMAX", " 2D"));
        movieList.add(new Movie("千与千寻  ", "宫崎骏", "柊瑠美", "剧情 / 动画", 45, "22:11", "大厅12-1", " vip厅", " 3D"));
        */

        MovieService movieService = new MovieService();
        movieList = movieService.queryAllmovie();
        System.out.println("**------------------------------ 柳职院电影 --------------------------------**");
    }

    //展示电影
    private void showMoive() {
        System.out.println("序号\t电影名字\t导演\t 主演\t 电影类型\t票价\t 时间\t 放映厅\t放映类型\t3D|2D\t");
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            System.out.println((i + 1) + "\t" + movie.getMovieName() + "\t" + movie.getDirector() + "\t" + movie.getActor() + "\t" + movie.getMovieType() + "\t"
                    + movie.getPrice() + "\t" + movie.getShowTime() + "\t" + movie.getRoom() + "\t" + movie.getRoomType() + "\t" + movie.getShowType());
        }
    }

    //选择电影，选择座位
    public void choiseSeat() {
        System.out.print("请选择电影：");
        int n = scanner.nextInt(); //从键盘获取键盘输入的数据
        movie = movieList.get(n - 1); //取到电影对象

        //去除电影名字之间的空格字符
        String a = movie.getMovieName();
        StringBuilder stringBuilder = new StringBuilder(a); //建立StringBuilder实例
        for (int i = 0; i < stringBuilder.length(); i++) { //for循环语句，每次对比输入的字符串的每一个字符
            if (stringBuilder.charAt(i) == ' ') { //如果字符等于空格
                stringBuilder.deleteCharAt(i);//删掉空格部分
                i--;//i自减1
            } else {
                stringBuilder.charAt(i);//输出有字符的部分
            }
        }
        //打印输出 客户选择
        System.out.println("你选择的电影：" + "《 " + stringBuilder.toString() + " 》" + "票价：" + movie.getPrice() + " 放映时间：" + movie.getShowTime() + " 在" + movie.getRoom() + "放映");
        Seat seat = movieService.querySeat(movie.getRoomType());
        printSeat(seat.getRowNum(), seat.getColNum());
        System.out.print("请选择你的座位：");
        seatNO = scanner.next(); //保存到seatNo变量
    }

    //选择座位，打印座位数据
    private void printSeat(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (checkTickets(i + "-" + j, movie.getRoom(), movie.getShowTime())) {
                    System.out.print(i + "-" + j + "   ");
                } else {
                    System.out.println("已购" + "   ");
                }
            }
            System.out.println();
        }
    }

    //不能一个座位卖两次，唯一位置
    //1.把卖出的票都保存到集合中，2.客户选择座位之后 判断有没有被卖出
    private void buyTickets() {
        if (checkTickets(seatNO, movie.getRoom(), movie.getShowTime())) { //判断票能不能卖出去
            System.out.println("会员加速购票中..."); //打印票据
            System.out.println("购票成功，正在出票:...");
            System.out.println("***********************");
            System.out.println("*-*-*-*-柳职影院-*-*-*-*");
            System.out.println("-----------------------");
            //打印票据
            try {
                Thread.sleep(4000); //延迟单位：毫秒
            } catch (Exception e) {

            }
            System.out.println("-*  电影：" + movie.getMovieName() + "\n" + "-*  时间：" + movie.getShowTime() + "\n" + "-*  放映厅：" + movie.getRoom() + "\n" + "-*  座位号：" + seatNO);
            System.out.println("**-*-*-*-*-*-*-*-*-*-**");
            System.out.println("***********************");
            buy(); //调用方法 把购票信息写入数据文件
            ticketList.add(new Ticket(movie.getMovieName(), movie.getShowTime(), movie.getRoom(), seatNO));
        } else {
            System.out.println("此票已经售完，请重新选择");
        }
    }

    public void buy() { //判断票能不能卖出,把购票信息录入数据
        if (checkTickets(seatNO, movie.getRoom(), movie.getShowTime())) {
            System.out.println("购票成功");
            String Name = "电影名称：" + movie.getMovieName();
            String Room = "放映厅：" + movie.getRoom();
            String Time = "放映时间" + movie.getShowTime();
            String Seat = "座位号" + seatNO;
            FileWriter writer = null;
            try { //把购票信息录入数据，并输出
                writer = new FileWriter("D:\\Documents\\Java\\temp\\movie.txt");
                writer.write(Name);
                writer.write(Room + " ");
                writer.write(Time + " ");
                writer.write(Seat + "");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //判断票和座位
    public boolean checkTickets(String seatNo, String room, String showTime) {
        for (Ticket t : ticketList) {
            if (t.getSeat().equals(seatNo) && t.getRoom().equals(room) && t.getShowTime().equals(showTime)) {//如果票存在，返回false
                return false;
            }
        }
        return true;//票可以卖出
    }

}
