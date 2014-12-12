package mgr;

public class ReferenceInfoJ {
	
	private int rfidJ;
	private int midJ;
	private String referenceJ;
	
	public ReferenceInfoJ() {
	}
	
	public ReferenceInfoJ(int rfid, int mid, String reference) {
		this.rfidJ = rfid;
		this.midJ = mid;
		this.referenceJ = reference;
	}
		
	/**
	 * @return the rfidJ
	 */
	public int getRfidJ() {
		return rfidJ;
	}

	/**
	 * @param rfidJ the rfidJ to set
	 */
	public void setRfidJ(int rfidJ) {
		this.rfidJ = rfidJ;
	}

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
	 * @return the referenceJ
	 */
	public String getReferenceJ() {
		return referenceJ;
	}

	/**
	 * @param referenceJ the referenceJ to set
	 */
	public void setReferenceJ(String referenceJ) {
		this.referenceJ = referenceJ;
	}

}
