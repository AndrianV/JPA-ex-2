package test;
import businesslayer.Facade;
import entity.Customer;
import entity.Order;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author dido8
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade fc = new Facade();
        
        //Create two Customers
        fc.createCustomer("Andrian", "andrian@gmail.com");
        fc.createCustomer("Peter", "saintP@gmail.com");
        
        //Find a Customer
        System.out.println("Here will show the first customer in the DB:");
        Customer c1 = fc.findCustomer(1);
        System.out.println("Found a customer with name: " + c1.getName());
        System.out.println("Founded customer have an email: " + c1.getEmail());
        System.out.println("================");
        
        //Get all Customers
        System.out.println("Here will show all customers in the DB:");
        List<Customer> allCustomers = fc.getAllCustomers();
        for (Customer cust : allCustomers) {
            System.out.println("First name: "+cust.getName());
            System.out.println("Email: "+cust.getEmail());
            System.out.println("====== next ======");
        }
        
        //Create an Order for a customer
        fc.createOrder(c1);
        
        //Find an Order
        Order order1 = fc.findOrder(1);
        
        //Add an Order to a Customer
        fc.addOrderToCustomer(c1, order1);
        
        //Create an Item Type
        fc.createItemType("Book", "Dante's Inferno", 29.99);
        
        //Create an Order Line
        fc.createOrderLine(5, order1, fc.getItemType(1));
        
        //Find the total price of an Order
        System.out.println("Total SUM for Order with id:1 is = " + fc.findTotalPriceForOrder(order1));
        
        //Close connections to DB from the EntityManager and unload Factory
        fc.closeConnection();
        fc.exitFactory();
    }
    
}
