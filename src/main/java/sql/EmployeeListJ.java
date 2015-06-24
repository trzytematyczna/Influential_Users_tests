package sql;

public class EmployeeListJ {
	
	private int eidJ;
	private String firstNameJ;
	private String lastNameJ;
	private String Email_idJ;
	private String role;
	
	public EmployeeListJ() {
	}
	
	public EmployeeListJ(int eid, String first, String last, String email) {
		this.eidJ = eid;
		this.firstNameJ = first;
		this.lastNameJ = last;
		this.Email_idJ = email;
	}
	/**
	 * @return the eidJ
	 */
	public int getEidJ() {
		return eidJ;
	}

	/**
	 * @param eidJ the eidJ to set
	 */
	public void setEidJ(int eidJ) {
		this.eidJ = eidJ;
	}

	/**
	 * @return the firstNameJ
	 */
	public String getFirstNameJ() {
		return firstNameJ;
	}

	/**
	 * @param firstNameJ the firstNameJ to set
	 */
	public void setFirstNameJ(String firstNameJ) {
		this.firstNameJ = firstNameJ;
	}

	/**
	 * @return the lastNameJ
	 */
	public String getLastNameJ() {
		return lastNameJ;
	}

	/**
	 * @param lastNameJ the lastNameJ to set
	 */
	public void setLastNameJ(String lastNameJ) {
		this.lastNameJ = lastNameJ;
	}

	/**
	 * @return the email_id
	 */
	public String getEmail_idJ() {
		return Email_idJ;
	}

	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_idJ(String email_id) {
		Email_idJ = email_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



}
