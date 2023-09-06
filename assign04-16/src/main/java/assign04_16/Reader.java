package assign04_16;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Reader {
	@Id
	private int  readerId;
	private String fname,lname,email;
	@ManyToMany
	private Set<Subscribe> subscriptionSet;
	/**
	 * @return the readerId
	 */
	public int getReaderId() {
		return readerId;
	}
	/**
	 * @param readerId the readerId to set
	 */
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the subscriptionSet
	 */
	public Set<Subscribe> getSubscriptionSet() {
		return subscriptionSet;
	}
	/**
	 * @param subscriptionSet the subscriptionSet to set
	 */
	public void setSubscriptionSet(Set<Subscribe> subscriptionSet) {
		this.subscriptionSet = subscriptionSet;
	}
	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", subscriptionSet=" + subscriptionSet + "]";
	}
	
	
}
