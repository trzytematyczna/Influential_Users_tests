package mgr;

public class ProfileRankJ {
	private int id;
	private int eid;
	private double profilerank;
	private int generation;
	private double wp;
	private double wa;
	private double ap;
	private double pc;
	private double pf;
	private double paf;
	private double pmpf;
	private double at;
	
	public ProfileRankJ(int eid, double profilerank, int generation, double wp, double wa, double ap, double pc,
			double pf, double paf, double pmpf,double at) {
		this.eid=eid;
		this.profilerank=profilerank;
		this.generation=generation;
		this.wp=wp;
		this.wa=wa;
		this.ap=ap;
		this.pc=pc;
		this.pf=pf;
		this.paf=paf;
		this.pmpf=pmpf;
		this.at=at;
	}
	
	public ProfileRankJ(int eid, double rank, int generation, double wp, double wa, double ap, double pc,
			double pf, double paf, double pmpf) {
		this.eid=eid;
		this.profilerank=rank;
		this.generation=generation;
		this.wp=wp;
		this.wa=wa;
		this.ap=ap;
		this.pc=pc;
		this.pf=pf;
		this.paf=paf;
		this.pmpf=pmpf;
		this.at=0;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAt() {
		return at;
	}
	public void setAt(double at) {
		this.at = at;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public double getProfilerank() {
		return profilerank;
	}
	public void setProfilerank(double profilerank) {
		this.profilerank = profilerank;
	}
	public double getWp() {
		return wp;
	}
	public void setWp(double wp) {
		this.wp = wp;
	}
	public double getWa() {
		return wa;
	}
	public void setWa(double wa) {
		this.wa = wa;
	}
	public double getAp() {
		return ap;
	}
	public void setAp(double ap) {
		this.ap = ap;
	}
	public double getPc() {
		return pc;
	}
	public void setPc(double pc) {
		this.pc = pc;
	}
	public double getPf() {
		return pf;
	}
	public void setPf(double pf) {
		this.pf = pf;
	}
	public double getPaf() {
		return paf;
	}
	public void setPaf(double paf) {
		this.paf = paf;
	}
	public double getPmpf() {
		return pmpf;
	}
	public void setPmpf(double pmpf) {
		this.pmpf = pmpf;
	}
	
	
	
}
