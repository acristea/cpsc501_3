/*********************************
/ Author: Adrian Cristea
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ Class: School
/ Creates an object that contains an array of object references.
 **********************************/ 

public class School {
	public Person [] arrayPerson;

	public School() {
		arrayPerson = new Person[5];

		for(int i = 0; i < arrayPerson.length; i++) {
			arrayPerson[i] = new Person();
		}

	}
}
