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