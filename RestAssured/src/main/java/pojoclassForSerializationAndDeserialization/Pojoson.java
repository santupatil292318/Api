package pojoclassForSerializationAndDeserialization;

public class Pojoson {

	String sname;
	String sid;
	public Pojoson(String sname, String sid) {
		super();
		this.sname = sname;
		this.sid = sid;
	}
	Pojoson()
	{
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
}
