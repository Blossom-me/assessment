
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ItemDAOImpl implements ItemDAO {
	//Create an Item
	@Override
	public void createItem(Item item) {
		
		String SQL = "INSERT INTO Item_Table(Item_Id,Item_Name,Item_Stock,Email_Id) VALUES(?,?,?,?)";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ps.setInt(1, item.getItem_id());
			ps.setString(2, item.getItemName());
			ps.setInt(3, item.getItem_stock());
			ps.setString(4, item.getEmail());
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate == 1) {
				System.out.println("Item is created ..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Fetch Item from DB by item_id
	@Override
	public Item getItemById(Integer itemId) {
		
		Item item = null;
		String SQL = "SELECT * FROM Item_Table WHERE Item_Id = ?";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ps.setInt(1, itemId);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				
				int ItemId = rs.getInt("Item_Id");
				String IName = rs.getString("Item_Name");
				int IStock = rs.getInt("Item_Stock");
				String IEmail = rs.getString("Email_Id");
				
				item = new Item();
				item.setItem_id(ItemId);
				item.setItemName(IName);
				item.setItem_stock(IStock);
				item.setEmail(IEmail);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	//Update item By Item_id
	@Override
	public void updateItemEmailById(String newEmail, Integer itemId) {
		
		String SQL = "UPDATE Item_Table set Email_Id = ? WHERE Item_Id = ?";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ps.setString(1, newEmail);
			ps.setInt(2, itemId);
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate == 1) {
				System.out.println("Item email is updated ..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Delete item by item_id
	@Override
	public void deleteItemById(Integer itemId) {
		
		String SQL = "DELETE FROM Item_Table WHERE Item_Id = ?";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
						
			ps.setInt(1, itemId);
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate == 1) {
				System.out.println("Item is deleted with Id : "+itemId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Fetch all the items from db
	@Override
	public List<Item> getAllItemInfo() {
		
		List<Item> itemList = new ArrayList<>();
		String SQL = "SELECT * FROM Item_Table ";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				int ItemId = rs.getInt("Item_Id");
				String IName = rs.getString("Item_Name");
				int IStock = rs.getInt("Item_Stock");
				String IEmail = rs.getString("Email_Id");
				
				Item item = new Item();
				item.setItem_id(ItemId);
				item.setItemName(IName);
				item.setItem_stock(IStock);
				item.setEmail(IEmail);
				
				itemList.add(item);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return itemList;
	}
	
	//Create an ordered list of item by itemName
	@Override
	public List<Item> orderByItemName() {
		List<Item> itemList = new ArrayList<>();
		String SQL = "SELECT * FROM Item_Table ";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				int ItemId = rs.getInt("Item_Id");
				String IName = rs.getString("Item_Name");
				int IStock = rs.getInt("Item_Stock");
				String IEmail = rs.getString("Email_Id");
				
				Item item = new Item();
				item.setItem_id(ItemId);
				item.setItemName(IName);
				item.setItem_stock(IStock);
				item.setEmail(IEmail);
				
				itemList.add(item);
				Collections.sort(itemList);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return itemList;
	}
	
	//Create a list of items which are out of stock
	@Override
	public List<Item> getOutOfStockItem() {
		
		List<Item> itemList = new ArrayList<>();
		String SQL = "SELECT * FROM Item_Table WHERE Item_Stock = 0 ";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				int ItemId = rs.getInt("Item_Id");
				String IName = rs.getString("Item_Name");
				int IStock = rs.getInt("Item_Stock");
				String IEmail = rs.getString("Email_Id");
				
				Item item = new Item();
				item.setItem_id(ItemId);
				item.setItemName(IName);
				item.setItem_stock(IStock);
				item.setEmail(IEmail);
				
				itemList.add(item);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

}
