import java.sql.Connection;
import java.sql.Statement;

public class ClientTest {

	public static void main(String[] args) {
		
/*		Connection connection = DBUtil.getConnection();
		if(connection != null)
			System.out.println("jdbc:conection is taken");
*/	
		createItem();
		//updateItemEmailById();
		//deleteItemById();
		
		
	}
/* 
	private static void deleteItemById() {
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQLINSERT = "DELETE FROM Item_Table WHERE Item_id=2";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate==1) {
				System.out.println("Item is deleted");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void updateItemEmailById() {
		
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQLINSERT = "Update Item_Table set Item_Name='Lenovo' WHERE Item_id=1";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate==1) {
				System.out.println("NAME is updated");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
*/		
	private static void createItem() {
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQLINSERT = "INSERT INTO Item_Table(Item_Id,Item_Name,Item_Stock,Email_Id) " 
					+ "VALUES(3,'MAC',30,'MAC@gmail.com')";
			int executeUpdate = st.executeUpdate(SQLINSERT);
			if(executeUpdate==1) {
				System.out.println("Item is created");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
