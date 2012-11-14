/*********************************
/ Author: Adrian Cristea
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ Class: Kid
/ Creates an object that contains references to other objects.
**********************************/ 

public class Kid {
	public Person aKid;
	
	public Kid() {
		aKid = new Person();
	}
}
