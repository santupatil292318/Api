package pojoclassForSerializationAndDeserialization;

public class PojoClassArray {
	String ename;
	int[] phonenu;
	String eid;
	String[] email;
	public PojoClassArray(String ename, int[] phonenu, String eid,String[] email) {
		super();
		this.ename = ename;
		this.phonenu = phonenu;
		this.eid = eid;
		this.email=email;
	}
	PojoClassArray()
	{}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int[] getPhonenu() {
		return phonenu;
	}
	public void setPhonenu(int[] phonenu) {
		this.phonenu = phonenu;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	
 
 
 
}
