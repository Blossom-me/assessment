
public class Item implements Comparable<Item> {
	
	private int item_id;
	private String itemName;
	private int itemStock;
	private String email;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItem_stock() {
		return itemStock;
	}
	public void setItem_stock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", itemName=" + itemName + ", itemStock=" + itemStock + ", email=" + email
				+ "]";
	}
	@Override
	public int compareTo(Item o) {
		
		int compare = itemName.compareTo(o.itemName);
		if(compare == 0) {
			//continue to compare  in case they have same name
			compare = Integer.compare(itemStock, o.itemStock);
		}
		
		return compare;
	}

}
