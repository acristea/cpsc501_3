/*********************************
/ Author: Abbas Sarraf Shirazi
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ Class: MYXMLHandler
/ Class to be used to create XML extra required functions such as write to file.
 **********************************/ 

import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;

public class MyXMLHandler {

	public static void writeXML(Document doc, FileOutputStream fileOuput) throws Exception
	{
		XMLOutputter fmt = new XMLOutputter();
		fmt.output(doc, fileOuput);
	}
}