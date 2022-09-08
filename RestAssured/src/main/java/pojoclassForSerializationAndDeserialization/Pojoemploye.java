package pojoclassForSerializationAndDeserialization;

public class Pojoemploye {

	String ename;
	String eid;
	Object spouse;
	public Pojoemploye(String ename, String eid, Object spouse) {
		super();
		this.ename = ename;
		this.eid = eid;
		this.spouse = spouse;
	}
	Pojoemploye()
	{}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Object getSpouse() {
		return spouse;
	}
	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
}
