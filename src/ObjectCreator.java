/*********************************
/ Author: Adrian Cristea
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ Class: ObjectCreator
/ Class to be used to create pre-required functions before the serialization process of the final object
 **********************************/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;


public class ObjectCreator {

	public static void initializePrimitiveObject(Object obj) throws Exception {

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
				fieldCurrent.set(obj, Integer.parseInt(input));
			}
			if(fieldCurrent.getType().getName().equals("char")) {
				fieldCurrent.set(obj, input.charAt(0));
			}
		}
	}
}
