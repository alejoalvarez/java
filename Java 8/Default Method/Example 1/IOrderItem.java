/**
 * @author Alejandro Vargas Alvarez
 */
public interface IOrderItem {
    
    public double getQuantity();
    public double getPrice();
    
    public default double getTotal(){
        return getQuantity() * getPrice();
    }
}