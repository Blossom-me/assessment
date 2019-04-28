import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientTest {

	public static void main(String[] args) {
		
/*		Connection connection = DBUtil.getConnection();
		if(connection != null)
			System.out.println("jdbc:conection is taken");
*/	
		
		//getItemById();
		getAllItemInfo();
		
		
	}
 
	private static void getAllItemInfo() {
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQL = "SELECT * FROM Item_Table";
			ResultSet rs = st.executeQuery(SQL);
			
			while(rs.next()) {
				
				int ItemId = rs.getInt("Item_Id");
				String IName = rs.getString("Item_Name");
				int IStock = rs.getInt("Item_Stock");
				String IEmail = rs.getString("Email_Id");
				
				System.out.println(ItemId+"\t"+IName+"\t"+IStock+"\t"+IEmail);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getItemById() {
		try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();) {
			
			String SQL = "SELECT * FROM Item_Table WHERE Item_Id=2";
			ResultSet rs = st.executeQuery(SQL);
			if(rs.next()) {
				int ItemId = rs.getInt("Item_Id");
				String IName = rs.getString("Item_Name");
				int IStock = rs.getInt("Item_Stock");
				String IEmail = rs.getString("Email_Id");
				
				System.out.println(ItemId+"\t"+IName+"\t"+IStock+"\t"+IEmail);
			}else {
				System.out.println("Item doesn't exist with procided iD");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
