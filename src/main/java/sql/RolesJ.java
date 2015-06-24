package sql;

public class RolesJ {
	private int id;
	private long eid;
	private String email;
	private int CEO;
	private int President;
	private int VicePresident;
	private int Director;
	private int Manager;
	private int Lawyer;
	private int Employee;
	private int Trader;
	private int NA;
	private String what;
	
	
	public RolesJ(long eid, String email, int CEO, int President, int VP, int Director, 
			int Mng, int Law, int Empl, int Trad, int NA, String what){
		this.eid=eid;
		this.email=email;
		this.CEO=CEO;
		this.President=President;
		this.VicePresident=VP;
		this.Director=Director;
		this.Manager=Mng;
		this.Lawyer=Law;
		this.Employee=Empl;
		this.Trader=Trad;
		this.NA=NA;
		this.what=what;
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
	public int getCEO() {
		return CEO;
	}
	public void setCEO(int cEO) {
		CEO = cEO;
	}
	public int getPresident() {
		return President;
	}
	public void setPresident(int president) {
		President = president;
	}
	public int getVicePresident() {
		return VicePresident;
	}
	public void setVicePresident(int vicePresident) {
		VicePresident = vicePresident;
	}
	public int getDirector() {
		return Director;
	}
	public void setDirector(int director) {
		Director = director;
	}
	public int getManager() {
		return Manager;
	}
	public void setManager(int manager) {
		Manager = manager;
	}
	public int getLawyer() {
		return Lawyer;
	}
	public void setLawyer(int lawyer) {
		Lawyer = lawyer;
	}
	public int getEmployee() {
		return Employee;
	}
	public void setEmployee(int employee) {
		Employee = employee;
	}
	public int getTrader() {
		return Trader;
	}
	public void setTrader(int trader) {
		Trader = trader;
	}
	public int getNA() {
		return NA;
	}
	public void setNA(int nA) {
		NA = nA;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
