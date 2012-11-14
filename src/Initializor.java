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
		else {
			if(args[0].equals("sender")) {
				Object outputObj = null;
				System.out.println("========Sender Interface=========");
				System.out.println("Please chose object to serialize : ");
				printMenuObjects();
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String message = in.readLine();
				switch(Integer.parseInt(message)) {

				case 1 :  
					Person objPerson = new Person();
					ObjectCreator.initializePrimitiveObject(objPerson);
					outputObj = objPerson;
					break;

				case 2 :
					Kid objKid = new Kid();
					objKid.aKid = new Person();
					ObjectCreator.initializePrimitiveObject(objKid.aKid);
					outputObj = objKid;
					break;

				case 3 :
					Years objYears = new Years();
					outputObj = objYears;
					break;
				case 4 :
					School objSchool = new School();
					outputObj = objSchool;
					break;

				case 5 : 
					City cityObject = new City();
					outputObj = cityObject;
					break;
				}
				Document doc = SerDeser.serializeObject(outputObj);
				MyXMLHandler.writeXML(doc, new FileOutputStream("output.xml"));
				int port = Integer.parseInt(args[1]);
				Sender objSender = new Sender(port);
				objSender.sendFile("output.xml");
			}

			else if (args[0].equals("receiver")) {

				String hostname = args[1];
				int port = Integer.parseInt(args[2]);
				Receiver objSender = new Receiver(port, hostname);
				objSender.receiveFile("./input.xml");

				SAXBuilder builder = new SAXBuilder(false);
				Document doc = builder.build("input.xml");

				Object objDeserialized = SerDeser.deserializeObject(doc);
				Inspector objInspector = new Inspector();
				objInspector.inspect(objDeserialized, true);
				//XMLReader.XMLprint();
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
