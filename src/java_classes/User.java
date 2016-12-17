package java_classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="users_id")
	private int users_id;
	
	@Column(name="users_name")
	private String users_name;
	
	@Column(name="users_surname")
	private String users_surname;
	
	@Column(name="users_user_name")
	private String users_user_name;
	
	@Column(name="users_email")
	private String users_email;
	
	@Column(name="users_password")
	private String users_password;
	
	@Column(name="users_address")
	private String users_address;
	
	@Column(name="users_date_of_birth")
	private Date users_date_of_birth;
	
	public User() {
		
	}

	public User(int users_id, String users_name,String users_surname, String users_email, String users_password, String users_address,
			Date users_date_of_birth,String users_user_name) {
		super();
		this.users_id = users_id;
		this.users_name = users_name;
		this.users_surname = users_surname;
		this.users_email = users_email;
		this.users_password = users_password;
		this.users_address = users_address;
		this.users_date_of_birth = users_date_of_birth;
		this.users_user_name = users_user_name;
	}

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_surname() {
		return users_surname;
	}

	public void setUsers_surname(String users_surname) {
		this.users_surname = users_surname;
	}  
	
	public String getUsers_user_name() {
		return users_user_name;
	}

	public void setUsers_user_name(String users_user_name) {
		this.users_user_name = users_user_name;
	}
	
	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}

	public String getUsers_password() {
		return users_password;
	}

	public void setUsers_password(String users_password) {
		this.users_password = users_password;
	}

	public String getUsers_address() {
		return users_address;
	}

	public void setUsers_address(String users_address) {
		this.users_address = users_address;
	}

	public Date getUsers_date_of_birth() {
		return users_date_of_birth;
	}

	public void setUsers_date_of_birth(Date users_date_of_birth) {
		this.users_date_of_birth = users_date_of_birth;
	}

	public int getUsers_id() {
		return users_id;
	}
	
	
}
