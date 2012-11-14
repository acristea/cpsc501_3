import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;

public class Initializor {

	public static void main(String args[]) throws Exception {
		if((args.length != 2)  &&  (args.length != 3)) {
			System.out.println("Usage: java Initializor sender hostname port#");
			System.out.println("Usage: java Initializor receiver port#");
		}
		else {
			if(args[0].equals("sender")) {
				
				System.out.println("========Sender Interface=========");
				System.out.println("Please chose object to serialize : ");
				printMenuObjects();
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String message = in.readLine();
				switch(Integer.parseInt(message)) {
					case 1 :  
						Person objPerson = new Person();
					/*	Class newClass = Class.forName("Person");
						Constructor c = newClass.getDeclaredConstructor(null);
						Object obj = c.newInstance(null);
						 SerDeser.serializeObject(obj);
					*/ 
						 Document doc =  ObjectCreator.initializePrimitiveObject(objPerson);
						 MyXMLHandler.writeXML(doc, new FileOutputStream("output.xml"));
						 break;
					case 2 :
						Kid objKid = new Kid();
						Document doc1 = ObjectCreator.initializePrimitiveObject(objKid);
						MyXMLHandler.writeXML(doc1, new FileOutputStream("output.xml"));
						break;
					case 3 :
					case 4 :
					case 5 : 	
				}
				
				int port = Integer.parseInt(args[1]);
				Sender objSender = new Sender(port);
				objSender.sendFile("output.xml");
			}
			
			else if (args[0].equals("receiver")) {
				
				String hostname = args[1];
				int port = Integer.parseInt(args[2]);
				Receiver objSender = new Receiver(port, hostname);
				objSender.receiveFile("./input.xml");
			}
			else {
				System.out.println("Please review your typed argumens");
			}
		}
	}
	private static void printMenuObjects() {
		String listMenuObject = "";
		listMenuObject += "1. A simple object with only primitives for instance variables.\n";
		listMenuObject += "2. An object that contains references to other objects.\n";
		listMenuObject += "3. An object that cointains an array of primitives.\n";
		listMenuObject += "4. An object that cointains an array of object references.\n";
		listMenuObject += "5. An object that uses an instance of one of Java's collection classes to refer to server other objects.\n";
		System.out.println(listMenuObject);
	}
}
