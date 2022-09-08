package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoclassForSerializationAndDeserialization.PojoCalss;

public class EmployeSerialization {

	public static void main(String[] args) throws Throwable {
		//create oject for pojoclass
		PojoCalss pojo = new PojoCalss("santosh", 123, "santu123@gmail.com", 991);
		//create object for objectmapper
		ObjectMapper objmap = new ObjectMapper();
		//use write value
		objmap.writeValue(new File("./san.json"), pojo);
		
	}
}
