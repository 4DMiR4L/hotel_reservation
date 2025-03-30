package entity;

import java.util.Date;

public class Hotel {
    private Integer id;
    private String name;
    private String location;
    private Date data;

    public Hotel(Integer id, String name, String location, Date data) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.data = data;
    }

    public Hotel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Hotel hotel)) return false;

        return id.equals(hotel.id) && name.equals(hotel.name) && location.equals(hotel.location) && data.equals(hotel.data);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", data=" + data +
                '}';
    }
}
