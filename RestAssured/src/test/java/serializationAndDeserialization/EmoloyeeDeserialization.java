package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoclassForSerializationAndDeserialization.PojoCalss;

public class EmoloyeeDeserialization {

	public static void main(String[] args) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		PojoCalss e1 = objectMapper.readValue(new File("./san.json"), PojoCalss.class);
		System.out.println(e1.getEname()+" "+e1.getPhno()+" "+e1.getEid()+" "+e1.getEmail());
		
	}

}
