import java.io.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;

public class MyXMLHandler {
	
	public static void writeXML(Document doc, FileOutputStream fileOuput) throws Exception
	{
		XMLOutputter fmt = new XMLOutputter();
		fmt.output(doc, fileOuput);
	}
	
	public static Document readFromFile(String fileName) throws Exception
	{
		SAXBuilder builder = new SAXBuilder();
		return builder.build(new File(fileName));
	}
}