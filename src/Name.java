import java.util.ArrayList;
import java.util.Collections;

public class Name implements Comparable<Name> {
	public String lastName, firstName;
	public Name(String last, String first) {
		lastName = last; firstName = first;
	}
	public int compareTo(Name other) {
		int lastCheck = this.lastName.compareTo(other.lastName);
		if (lastCheck == 0)
			return this.firstName.compareTo(other.firstName);
		else
			return lastCheck;
	}
	public boolean equals(Name other) {
		return this.lastName.equals(other.lastName);
	}
	public static void main(String[] args){
		Name s = new Name("John", "Jack");
		Name b = new Name("John", "Jcck");
		Name c = new Name("Jo", "Ja");
		Name d = new Name("Johnny", "Jackson");
		int f = s.compareTo(b);
		
		
		
		System.out.println(f);
		ArrayList<Name> a = new ArrayList<Name>();
		a.add(s);
		a.add(b);
		a.add(c);
		a.add(d);
		Collections.sort(a);
		
	}
}
