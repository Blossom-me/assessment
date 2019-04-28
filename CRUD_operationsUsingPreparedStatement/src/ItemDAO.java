
import java.util.List;

public interface ItemDAO {
	
	public abstract void createItem(Item item);               //Create an Item
	public abstract Item getItemById(Integer itemId);              //Fetch Item from database by id
	public abstract void updateItemEmailById(String newEmail, Integer itemId);       //Update item by id
	public abstract void deleteItemById(Integer itemId);           // Delete item by id
	public abstract List<Item> getAllItemInfo();                //List all the items
	public abstract List<Item> orderByItemName();                //Order items by name
	public abstract List<Item> getOutOfStockItem();                 // list items which are out of stock

}
