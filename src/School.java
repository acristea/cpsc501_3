public class School {
	public Person [] arrayPerson;
	
	public School() {
		arrayPerson = new Person[5];
		
		for(int i = 0; i < arrayPerson.length; i++) {
			arrayPerson[i] = new Person();
		}
		
	}
}
