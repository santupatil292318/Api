package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoclassForSerializationAndDeserialization.Pojoemploye;
import pojoclassForSerializationAndDeserialization.Pojoson;
import pojoclassForSerializationAndDeserialization.Pojospouce;

public class SerializationwithObjectsspouse {

	public static void main(String[] args) throws Throwable {
		//to create object for son
		Pojoson son = new Pojoson("son", "son123");
		//To create object for spouse
		Pojospouce spouse = new Pojospouce("abc", "s123",son);
		//storing spouse object inside employee object
		Pojoemploye emp = new Pojoemploye("san", "b123", spouse);
		//to create object mapper
		ObjectMapper obj = new ObjectMapper();
		//To writevale
		obj.writeValue(new File("./empspouse.json"), emp);
	}
}
