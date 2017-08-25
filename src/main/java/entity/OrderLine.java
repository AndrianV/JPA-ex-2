package entity;
import javax.persistence.*;
/**
 *
 * @author Andrian Vangelov
 */
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private ItemType itemType;

    public OrderLine(int quantity, Order order, ItemType it) {
        this.quantity = quantity;
        this.order = order;
        this.itemType = it;
    }

    public ItemType getItemType() {
        return itemType;
    }
    private int quantity;
    
    public OrderLine() {
    }
    
    public OrderLine(int quantity) {
        this.quantity = quantity;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getId() {
        return id;
    }
    
}
