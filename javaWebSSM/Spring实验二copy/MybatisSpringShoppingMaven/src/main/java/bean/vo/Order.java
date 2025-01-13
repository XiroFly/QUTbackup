package bean.vo;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Order {
    private Integer id;
    private Date createdTime;
    private List<Item> items;

    public Order() {
    }

    public Order(Integer id, Date createdTime, List<Item> items) {
        this.id = id;
        this.createdTime = createdTime;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                ", items=" + items +
                '}';
    }
}
