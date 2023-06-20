package demo.movie.entity;

/**
 * 一张表对应一个数据
 */
public class Movie {
    private int id;
    private String movieName;//电影名
    private String director;//导演
    private String actor;//演员
    private String movieType;//电影类型
    private int price;//价格
    private String showTime;//时间
    private String room;//位置 放映厅
    private String roomType;//放映类型
    private String showType;//2D 3D

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", movieType='" + movieType + '\'' +
                ", price=" + price +
                ", showTime='" + showTime + '\'' +
                ", room='" + room + '\'' +
                ", roomType='" + roomType + '\'' +
                ", showType='" + showType + '\'' +
                '}';
    }
}
