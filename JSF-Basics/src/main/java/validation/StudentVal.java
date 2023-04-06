package validation;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentVal {
	private String firstName;
	private String lastName;
	private String email;
	private int feePasses;
	private String postalCode;
	private String phoneNumber;

	public StudentVal() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFeePasses() {
		return feePasses;
	}

	public void setFeePasses(int feePasses) {
		this.feePasses = feePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
