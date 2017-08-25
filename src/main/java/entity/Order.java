package entity;
import javax.persistence.*;
/**
 *
 * @author Andrian Vangelov
 */
@Entity
@Table(name="\"ORDER\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Customer cust;
    
    public Order() {
    }

    public Order(Customer cust) {
        this.cust = cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public long getId() {
        return id;
    }
    
}
