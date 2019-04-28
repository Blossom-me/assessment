
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientTest {

	public static void main(String[] args) {
		
		ItemDAO itemDAO = new ItemDAOImpl();
		Item item =getItem();
		
		itemDAO.createItem(item);
		getItemById(itemDAO);
		itemDAO.updateItemEmailById("mac11@gmail.com", 3);
		itemDAO.deleteItemById(2);
		getAllItemInfo(itemDAO);
		orderByItemName(itemDAO);
		getOutofStockItemDAO(itemDAO);
		
			}

	private static void getOutofStockItemDAO(ItemDAO itemDAO) {
		List<Item> itemList = itemDAO.getOutOfStockItem();
		itemList.forEach(System.out::println);
		
	}

	private static void orderByItemName(ItemDAO itemDAO) {
		List<Item> itemList = itemDAO.orderByItemName();
		itemList.forEach(System.out::println);
		
	}

	private static void getAllItemInfo(ItemDAO itemDAO) {
		List<Item> itemList = itemDAO.getAllItemInfo();
		itemList.forEach(System.out::println);       //using java8 : internal iteration
	}

	private static void getItemById(ItemDAO itemDAO) {
		Item item2 = itemDAO.getItemById(2);
		if(item2 != null) {
			System.out.println(item2);
		}else {
			System.out.println("Item doesn't exist ..");
		}
	}
	
	private static Item getItem() {
		Item item = new Item();
		item.setItem_id(4);
		item.setItemName("HP");
		item.setItem_stock(5);
		item.setEmail("hp@gmail.com");
		return item;
	}
	
}
