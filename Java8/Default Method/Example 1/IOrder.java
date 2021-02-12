import java.util.List;

/**
 * @author Alejandro Vargas Alvarez
 */
public interface IOrder {
    
    public List<IOrderItem> getOrderItem();
    
    public default double getTotal(){
        double total = 0;
        for (IOrderItem item : getOrderItem()) {
            total += item.getTotal();
        }
        return total;
    }
    
    public default void addOrderItem(IOrderItem orderItem){
        getOrderItem().add(orderItem);
    }
}