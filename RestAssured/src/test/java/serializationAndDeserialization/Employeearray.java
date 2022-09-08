package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoclassForSerializationAndDeserialization.PojoClassArray;

public class Employeearray {

	public static void main(String[] args) throws Throwable {
		int[] arr= {123,456};
		String[] email= {"san123@gmail","san1345@gmail.com"};
		PojoClassArray pojo = new PojoClassArray("santu", arr, "san123",email);
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("./santu.json"), pojo);
	}

}
