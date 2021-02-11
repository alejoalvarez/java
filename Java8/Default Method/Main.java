/**
 * @author Alejandro Vagras Alvarez
 */
public class Main {
    public static void main(String[] args) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.addOrderItem(new SalesOrderItem(10, 100));
        salesOrder.addOrderItem(new SalesOrderItem(1, 20));
        System.out.println("total ==> " +salesOrder.getTotal() );
    }
}