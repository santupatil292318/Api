package pojoclassForSerializationAndDeserialization;

public class Pojospouce {

	String sname;
	String sid;
	Object son;
	public Pojospouce(String sname, String sid,Object son) {
		super();
		this.sname = sname;
		this.sid = sid;
		this.son=son;
	}
	Pojospouce()
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
	public Object getSon() {
		return son;
	}
	public void setSon(Object son) {
		this.son = son;
	}
	
}
