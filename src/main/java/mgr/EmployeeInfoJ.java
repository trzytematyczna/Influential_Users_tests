package mgr;

public class EmployeeInfoJ {
	private long eid;
	private String email;
	private long sent_email;
	private long received_email;
	private String latest_email;
	private double profilerank;

	public EmployeeInfoJ(long e, String mail, long sent, long recived, String latest, double profile) {
		this.eid=e;
		this.email=mail;
		this.sent_email=sent;
		this.received_email=recived;
		this.latest_email=latest;
		this.profilerank=profile;
	}
	
	public long getEid() {
		return eid;
	}
	public void setEid(long eid) {
		this.eid = eid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getSent_email() {
		return sent_email;
	}
	public void setSent_email(long sent_email) {
		this.sent_email = sent_email;
	}
	public long getReceived_email() {
		return received_email;
	}
	public void setReceived_email(long received_email) {
		this.received_email = received_email;
	}
	public String getLatest_email() {
		return latest_email;
	}
	public void setLatest_email(String latest_email) {
		this.latest_email = latest_email;
	}
	public double getProfilerank() {
		return profilerank;
	}
	public void setProfilerank(double profilerank) {
		this.profilerank = profilerank;
	}
	
	
}
