package pojoclassForSerializationAndDeserialization;

public class PojoCalss {

	String ename;
	int eid;
	String email;
	int phonenumber;
	public PojoCalss(String ename, int eid, String email, int phonenumber) {
		super();
		this.ename = ename;
		this.eid = eid;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	PojoCalss()
	{
		
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhno() {
		return phonenumber;
	}
	public void setPhno(int phno) {
		this.phonenumber = phno;
	}
	
}
