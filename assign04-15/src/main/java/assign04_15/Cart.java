package assign04_15;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartid;
	private double total;
	private String name;
	@OneToMany
	private Set<Item> items;
	/**
	 * @return the cartid
	 */
	public int getCartid() {
		return cartid;
	}
	/**
	 * @param cartid the cartid to set
	 */
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the items
	 */
	public Set<Item> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", total=" + total + ", name=" + name + ", items=" + items + "]";
	}
	
	
}
