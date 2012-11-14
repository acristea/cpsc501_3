/*********************************
/ Author: Adrian Cristea
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ Class: Initializor
/ Contains the main functionality of the program, initializing the command line menu and necessary objects. Controls the whole system.
 **********************************/ 

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class Initializor {

	public static void main(String args[]) throws Exception {
		if((args.length != 2)  &&  (args.length != 3)) {
			System.out.println("Usage: java Initializor sender hostname port#");
			System.out.println("Usage: java Initializor receiver port#");
		}
		else
		{

			if(args[0].equals("sender")) {
				Object outputObj = null;
				System.out.println("========Sender Interface=========");
				System.out.println("Please chose object to serialize : ");
				printMenuObjects();
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String message = in.readLine();
				switch(Integer.parseInt(message)) {
				//A simple object with only primitives for instance variables.
				case 1:  
					Person objPerson = new Person();
					ObjectCreator.initializePrimitiveObject(objPerson);
					outputObj = objPerson;
					break;
				//An object that contains references to other objects.
				case 2:
					Kid objKid = new Kid();
					ObjectCreator.initializePrimitiveObject(objKid.aKid);
					outputObj = objKid;
					break;
				//An object that contains an array of primitives.
				case 3:
					Years objYears = new Years();
					objYears.arrayYears = new int[5];
					for(int i = 0; i < 5; i++) {
						objYears.arrayYears[i] = i;	
						System.out.println("Index of " + i + " current value " + objYears.arrayYears[i]); 
						System.out.println("Change value to: ");
						String input = in.readLine();
						objYears.arrayYears[i] = Integer.parseInt(input); 
					}

					outputObj = objYears;
					break;
				//An object that contains an array of object references.
				case 4:
					School objSchool = new School();
					outputObj = objSchool;
					break;
				//An object that uses an instance of one of Java's collection classes to refer to server other objects.
				case 5: 
					City cityObject = new City();
					outputObj = cityObject;
					break;
				}
				String FILETOSEND = "send.xml";

				Document doc = SerDeser.serializeObject(outputObj);
				MyXMLHandler.writeXML(doc, new FileOutputStream(FILETOSEND));
				int port = Integer.parseInt(args[1]);
				Sender objSender = new Sender(port);
				objSender.sendFile(FILETOSEND);
			}

			else if (args[0].equals("receiver")) {
				String FILETORECIEVE = "receive.xml";

				String hostname = args[1];
				int port = Integer.parseInt(args[2]);
				Receiver objSender = new Receiver(port, hostname);
				//receive File "recieve.xml"
				objSender.receiveFile("./" + FILETORECIEVE);
				//construct document from it
				SAXBuilder builder = new SAXBuilder(false);
				Document doc = builder.build(FILETORECIEVE);
				//initialize objDeserialized from XML file
				Object objDeserialized = SerDeser.deserializeObject(doc);

				Inspector objInspector = new Inspector();
				System.out.println("******* Inspecting received object *******");
				//inspect object received through network
				objInspector.inspect(objDeserialized, true);
				System.out.println("******* Read the received file *******");
				//Read file from xml, visualizing its appropriate contents
				XMLReaderRecursive.XMLprint(FILETORECIEVE);
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
		listMenuObject += "3. An object that contains an array of primitives.\n";
		listMenuObject += "4. An object that contains an array of object references.\n";
		listMenuObject += "5. An object that uses an instance of one of Java's collection classes to refer to server other objects.\n";
		System.out.println(listMenuObject);
	}
}
