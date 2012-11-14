import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

import org.jdom2.Document;

public class ObjectCreator {

	static Document initializePrimitiveObject(Object obj) throws Exception {

		Class classObj = obj.getClass();
		Field [] fieldObj = classObj.getFields();
		System.out.println("Please set up the above fields");
		for(int i = 0 ; i < fieldObj.length; i++) {
			fieldObj[i].setAccessible(true);
			System.out.println("Name : " + fieldObj[i].getName());
			Field fieldCurrent = classObj.getDeclaredField(fieldObj[i].getName());
			System.out.println("Type : " + fieldCurrent	.getType().toString());
			System.out.println("Type in value: ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			if(fieldCurrent.getType().getName().equals("int")) {
				System.out.println(fieldCurrent.toString());
				fieldCurrent.set(obj, Integer.parseInt(input));
				System.out.println(fieldCurrent.toString());
			}
			if(fieldCurrent.getType().getName().equals("char")) {
				System.out.println(fieldCurrent.toString());
				fieldCurrent.set(obj, input.charAt(0));
				System.out.println(fieldCurrent.toString());
			}
		}

		return SerDeser.serializeObject(obj);

	}
	
}