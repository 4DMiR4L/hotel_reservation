package entity;

import java.util.Date;

public class Booking {
    private Integer id;
    private String customer_name;
    private String customer_email;
    private Date start_date;
    private Date end_date;
    private String status;

    public Booking(Integer id, String customer_name, String customer_email, Date start_date, Date end_date, String status) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
    }

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Booking booking)) return false;

        return id.equals(booking.id) && customer_name.equals(booking.customer_name) && customer_email.equals(booking.customer_email) && start_date.equals(booking.start_date) && end_date.equals(booking.end_date) && status.equals(booking.status);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + customer_name.hashCode();
        result = 31 * result + customer_email.hashCode();
        result = 31 * result + start_date.hashCode();
        result = 31 * result + end_date.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
               "id=" + id +
               ", customer_name='" + customer_name + '\'' +
               ", customer_email='" + customer_email + '\'' +
               ", start_date=" + start_date +
               ", end_date=" + end_date +
               ", status='" + status + '\'' +
               '}';
    }
}
