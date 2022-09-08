package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoclassForSerializationAndDeserialization.PojoClassArray;

public class Employeearraydeserialization {

	public static void main(String[] args) throws Throwable{
		//To create object mapper
		ObjectMapper obj = new ObjectMapper();
		//to read value
		PojoClassArray pojoarray = obj.readValue(new File("./santu.json"), PojoClassArray.class);
		System.out.println(pojoarray.getEid()+" "+pojoarray.getEmail()[0]+" "+pojoarray.getEname()+" "+pojoarray.getPhonenu()[0]);
	}

}
