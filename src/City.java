/*********************************
/ Author: Adrian Cristea
/ Serializes, Deserializes a specific object through a network between a server and a client.
/ CPSC 501 - Assignment 3
/ --------------------------------
/ class: City
/ creates an object that uses an instance of one of Java's collection classes to refer to server other objects.
 **********************************/

import java.util.Collection;
import java.util.HashSet;

public class City {
	public Collection<Person> persons;

	public City(){
		persons = new HashSet<Person>();

		for (int i=0; i < 5; i++){
			persons.add(new Person()); 
		}
	}
}