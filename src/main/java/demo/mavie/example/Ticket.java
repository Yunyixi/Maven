package demo.movie.example;

public class Ticket {
    private String movieName;
    private String showTime;
    private String room;
    private String seat;

    public Ticket() {
    }

    public Ticket(String movieName, String showTime, String room, String seat) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.room = room;
        this.seat = seat;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return " 电影名字：" + movieName + '\n' +
                " 放映时间：" + showTime + '\n' +
                " 放映厅：" + room + '\n' +
                " 座位：" + seat + '\n'
                ;
    }
}
