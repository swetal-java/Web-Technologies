package assign04_16;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subscribe {
	@Id
	private int subscriptionId;
	private String name;
	@ManyToMany
	private Set<Reader> renders;
	/**
	 * @return the subscriptionId
	 */
	public int getSubscriptionId() {
		return subscriptionId;
	}
	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
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
	 * @return the renders
	 */
	public Set<Reader> getRenders() {
		return renders;
	}
	/**
	 * @param renders the renders to set
	 */
	public void setRenders(Set<Reader> renders) {
		this.renders = renders;
	}
	@Override
	public String toString() {
		return "Subscribe [subscriptionId=" + subscriptionId + ", name=" + name + ", renders=" + renders + "]";
	}
	
}
