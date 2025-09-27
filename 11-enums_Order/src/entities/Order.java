package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {

    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Order() {
    }

    public Order(Integer id, Date moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id = ").append(getId());
        sb.append(", moment = ").append(getMoment());
        sb.append(", status = ").append(getStatus());
        return sb.append("}").toString();
    }

}
