/**
 * @author Alejandro Vargas Alvarez
 */
public class SalesOrderItem implements IOrderItem {
    
    private double quantity;
    private double price;

    public SalesOrderItem(double quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
    
    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}