package sql;


public class RecipientInfoJ {
	private int ridJ;
//	private int midJ;
	private String rtypeJ;
	private String rvalueJ;
	private String daterJ;
	private MessageJ message;
	
	public RecipientInfoJ() {
	}
	
	public RecipientInfoJ(int rid, String rtype, String rvalue, String dater, MessageJ mess){
		this.ridJ=rid;
		this.rtypeJ=rtype;
		this.rvalueJ=rvalue;
		this.daterJ=dater;
		this.message=mess;
	}

	public int getRidJ() {
		return ridJ;
	}

	public void setRidJ(int ridJ) {
		this.ridJ = ridJ;
	}

	public String getRtypeJ() {
		return rtypeJ;
	}

	public void setRtypeJ(String rtypeJ) {
		this.rtypeJ = rtypeJ;
	}

	public String getRvalueJ() {
		return rvalueJ;
	}

	public void setRvalueJ(String rvalueJ) {
		this.rvalueJ = rvalueJ;
	}

	public String getDaterJ() {
		return daterJ;
	}

	public void setDaterJ(String daterJ) {
		this.daterJ = daterJ;
	}

	public MessageJ getMessage() {
		return message;
	}

	public void setMessage(MessageJ message) {
		this.message = message;
	}

	
//	public RecipientInfoJ(int rid, int mid, String rtype, String rvalue, String dater) {
//		this.ridJ = rid;
//		this.midJ = mid;
//		this.rtypeJ = rtype;
//		this.rvalueJ = rvalue;
//		this.daterJ = dater;
//	}
//	
//	/**
//	 * @return the ridJ
//	 */
//	public int getRidJ() {
//		return ridJ;
//	}
//	/**
//	 * @param ridJ the ridJ to set
//	 */
//	public void setRidJ(int ridJ) {
//		this.ridJ = ridJ;
//	}
//	/**
//	 * @return the midJ
//	 */
//	public int getMidJ() {
//		return midJ;
//	}
//	/**
//	 * @param midJ the midJ to set
//	 */
//	public void setMidJ(int midJ) {
//		this.midJ = midJ;
//	}
//	/**
//	 * @return the rtypeJ
//	 */
//	public String getRtypeJ() {
//		return rtypeJ;
//	}
//	/**
//	 * @param rtypeJ the rtypeJ to set
//	 */
//	public void setRtypeJ(String rtypeJ) {
//		this.rtypeJ = rtypeJ;
//	}
//	/**
//	 * @return the rvalueJ
//	 */
//	public String getRvalueJ() {
//		return rvalueJ;
//	}
//	/**
//	 * @param rvalueJ the rvalueJ to set
//	 */
//	public void setRvalueJ(String rvalueJ) {
//		this.rvalueJ = rvalueJ;
//	}
//	/**
//	 * @return the daterJ
//	 */
//	public String getDaterJ() {
//		return daterJ;
//	}
//	/**
//	 * @param daterJ the daterJ to set
//	 */
//	public void setDaterJ(String daterJ) {
//		this.daterJ = daterJ;
//	}
//

}
