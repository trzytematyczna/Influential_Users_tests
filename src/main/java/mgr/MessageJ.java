package mgr;

public class MessageJ {
	/**
	 * @return the midJ
	 */
	public int getMidJ() {
		return midJ;
	}

	/**
	 * @param midJ the midJ to set
	 */
	public void setMidJ(int midJ) {
		this.midJ = midJ;
	}

	/**
	 * @return the senderJ
	 */
	public String getSenderJ() {
		return senderJ;
	}

	/**
	 * @param senderJ the senderJ to set
	 */
	public void setSenderJ(String senderJ) {
		this.senderJ = senderJ;
	}

	/**
	 * @return the dateJ
	 */
	public String getDateJ() {
		return dateJ;
	}

	/**
	 * @param dateJ the dateJ to set
	 */
	public void setDateJ(String dateJ) {
		this.dateJ = dateJ;
	}

	/**
	 * @return the message_idJ
	 */
	public String getMessage_idJ() {
		return message_idJ;
	}

	/**
	 * @param message_idJ the message_idJ to set
	 */
	public void setMessage_idJ(String message_idJ) {
		this.message_idJ = message_idJ;
	}

	/**
	 * @return the subjectJ
	 */
	public String getSubjectJ() {
		return subjectJ;
	}

	/**
	 * @param subjectJ the subjectJ to set
	 */
	public void setSubjectJ(String subjectJ) {
		this.subjectJ = subjectJ;
	}

	/**
	 * @return the bodyJ
	 */
	public String getBodyJ() {
		return bodyJ;
	}

	/**
	 * @param bodyJ the bodyJ to set
	 */
	public void setBodyJ(String bodyJ) {
		this.bodyJ = bodyJ;
	}

	/**
	 * @return the folderJ
	 */
	public String getFolderJ() {
		return folderJ;
	}

	/**
	 * @param folderJ the folderJ to set
	 */
	public void setFolderJ(String folderJ) {
		this.folderJ = folderJ;
	}

	private int midJ;
	private String senderJ;
	private String dateJ;
	private String message_idJ;
	private String subjectJ;
	private String bodyJ;
	private String folderJ;
	
	public MessageJ() {
	}
	
	public MessageJ(int mid, String sender, String date, String  msgid, String subject, String body, String folder){
		this.midJ = mid;
		this.senderJ = sender;
		this.dateJ = date;
		this.message_idJ = msgid;
		this.subjectJ = subject;
		this.bodyJ = body;
		this.folderJ = folder;
	}



}
