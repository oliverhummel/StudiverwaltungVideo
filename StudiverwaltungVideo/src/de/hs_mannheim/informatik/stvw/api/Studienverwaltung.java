package de.hs_mannheim.informatik.stvw.api;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.informatik.stvw.domain.Student;

public class Studienverwaltung {
	private List<Student> studierende = new ArrayList<>();
	
	public void studentAnlegen(String vorname, 
					String name, int matrikelnummer) {
		studierende.add(new Student(vorname, name, matrikelnummer));
	}
	
	public String studentenDatenAbfragen(int matrikelnummer) {
		for (Student s : studierende)
			if (s.getMatrikelnummer() == matrikelnummer)
				return s.toString();
		
		return null;
	}
	
}
