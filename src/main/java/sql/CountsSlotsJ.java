package sql;


public class CountsSlotsJ {
	private int id;
	private long eid;
	private String email;
	private long sent_email;
	private long received_email;
	private long recipient_count;
	private long friends_count;
	private long mailFromFriends;
	private long mailToFriends;
	private String date;
//	private String latest_email;
	
	public CountsSlotsJ(long e, String mail, long sent, long recived, long recipients,
			long friends, long from, long to, String dat) {
		this.eid=e;
		this.email=mail;
		this.sent_email=sent;
		this.received_email=recived;
		this.recipient_count=recipients;
		this.friends_count=friends;
		this.mailFromFriends=from;
		this.mailToFriends=to;
		this.date = dat;
//		this.latest_email=latest;
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
	public long getRecipient_count() {
		return recipient_count;
	}
	public void setRecipient_count(long recipient_count) {
		this.recipient_count = recipient_count;
	}
	public long getFriends_count() {
		return friends_count;
	}
	public void setFriends_count(long friends_count) {
		this.friends_count = friends_count;
	}
	public long getMailFromFriends() {
		return mailFromFriends;
	}
	public void setMailFromFriends(long mailFromFriends) {
		this.mailFromFriends = mailFromFriends;
	}
	public long getMailToFriends() {
		return mailToFriends;
	}
	public void setMailToFriends(long mailToFriends) {
		this.mailToFriends = mailToFriends;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
