package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

 
@Entity
public class Admin 
{
	@Id
    @GeneratedValue
    private int adminId;
	
	/*
	 * @NotEmpty(message="Name is Required")
	 * 
	 * @NotNull
	 * 
	 * @Size(min=3,max=6)
	 * 
	 * @Pattern(regexp="^[A-Z][a-z]",message="length must be 10")
	 */
	@NotNull
    @Size(min = 2, message = "first Name should have at least 2 char")
    private String adminUsername;
  
  
    @NotNull
    @Size(max=10)   
    private String password;
    
	
	@Email
    private String adminMail;
    
	

    public Admin() {
//    	Default Constructor
    }
	public Admin(int adminId, String adminUsername, String adminAdress, String adminMail) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminMail = adminMail;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getadminUsername() {
		return adminUsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setadminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminUsername=" + adminUsername + ", password=" + password
				+ ", adminMail=" + adminMail + "]";
	}
	
	
	

}
