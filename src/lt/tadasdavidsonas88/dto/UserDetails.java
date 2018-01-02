package lt.tadasdavidsonas88.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "USER_DETAILS")
@NamedQuery(name="UserDetails.byId", query="from USER_DETAILS where userId = ?")
@NamedNativeQuery(name="UserDetails.byName", query="select * from user_details where user_name = ?", 
						resultClass=UserDetails.class)
@Table
public class UserDetails {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
