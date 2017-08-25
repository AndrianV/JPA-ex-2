package businesslayer;

import entity.Customer;
import entity.ItemType;
import entity.Order;
import entity.OrderLine;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Andrian Vangelov
 */
public class Facade {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public Facade() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_JPA-ex-2_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

    public void createCustomer(String name, String email) {
        Customer cust = new Customer(name, email);
        em.getTransaction().begin();
        em.persist(cust);
        em.getTransaction().commit();
    }

    public void createOrder(Customer cust) {
        Order o = new Order(cust);
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public void createItemType(String name, String description, double price) {
        ItemType itemType = new ItemType(name, description, price);
        em.getTransaction().begin();
        em.persist(itemType);
        em.getTransaction().commit();
    }

    public void createOrderLine(int quantity, Order order, ItemType it) {
        OrderLine ol = new OrderLine(quantity, order, it);
        em.getTransaction().begin();
        em.persist(ol);
        em.getTransaction().commit();
    }

    public void addOrderToCustomer(Customer c, Order o) {
        o.setCust(c);
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT c FROM Customer c");
        return (List<Customer>) query.getResultList();
    }

    public Customer findCustomer(long id) {
        return em.find(Customer.class, id);
    }

    public Order findOrder(long id) {
        return em.find(Order.class, id);
    }

    public double findTotalPriceForOrder(Order order) {
        Query query = em.createQuery("SELECT line FROM OrderLine line WHERE line.order.id = " + order.getId());
        List<OrderLine> list = query.getResultList();
        double sum = 0.00;
        for (OrderLine line : list) {
            sum = line.getQuantity() * line.getItemType().getPrice();

        }
        return sum;
    }

    public void closeConnection() {
        em.close();
    }

    public void exitFactory() {
        emf.close();
    }

    //Additional "Helper" methods
    public OrderLine getOrderLine(Order or) {
        return em.find(OrderLine.class, or);
    }

    public ItemType getItemType(long id) {
        return em.find(ItemType.class, id);
    }

}
