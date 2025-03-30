package entity;

import java.util.Date;

public class Room {
    private Integer id;
    private Integer room_number;
    private Double price;
    private String status;
    private Date date;

    public Room(Integer id, Integer room_number, Double price, String status, Date date) {
        this.id = id;
        this.room_number = room_number;
        this.price = price;
        this.status = status;
        this.date = date;
    }

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Room room)) return false;

        return id.equals(room.id) && room_number.equals(room.room_number) && price.equals(room.price) && status.equals(room.status) && date.equals(room.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + room_number.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room_number=" + room_number +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
