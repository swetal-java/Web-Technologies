package assign04_15;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;
	private String itemidString;
	private double itemtotal;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Cart cart;
	/**
	 * @return the itemid
	 */
	public int getItemid() {
		return itemid;
	}
	/**
	 * @param itemid the itemid to set
	 */
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	/**
	 * @return the itemidString
	 */
	public String getItemidString() {
		return itemidString;
	}
	/**
	 * @param itemidString the itemidString to set
	 */
	public void setItemidString(String itemidString) {
		this.itemidString = itemidString;
	}
	/**
	 * @return the itemtotal
	 */
	public double getItemtotal() {
		return itemtotal;
	}
	/**
	 * @param itemtotal the itemtotal to set
	 */
	public void setItemtotal(double itemtotal) {
		this.itemtotal = itemtotal;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemidString=" + itemidString + ", itemtotal=" + itemtotal + ", quantity="
				+ quantity + ", cart=" + cart + "]";
	}
	
	

}
