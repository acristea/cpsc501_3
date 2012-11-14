/*********************************
/ Author: Abbas Sarraf Shirazi
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ Class: Receiver
/ Class to be used to start up the Receiver to receive a file.
 **********************************/ 

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Receiver {

	int portToConnect = 12324;
	String serverAddress = "127.0.0.1";

	public Receiver(int port, String serverAddr)
	{
		this.portToConnect = port;
		this.serverAddress = serverAddr;
	}

	public void receiveFile(String pathToStore) throws Exception {

		Socket sock = new Socket(this.serverAddress, this.portToConnect);

		byte[] buffer = new byte[102000004];

		System.out.println("Starting to read from server");
		InputStream is = sock.getInputStream();
		int bytesRead = is.read(buffer, 0, buffer.length);

		// dealing with creation of a file on the client side
		FileOutputStream fos = new FileOutputStream(pathToStore);
		BufferedOutputStream bos = new BufferedOutputStream(fos);


		bos.write(buffer, 0, bytesRead);
		bos.close();
		sock.close();
		System.out.println("File received, connection closed");
	}
}