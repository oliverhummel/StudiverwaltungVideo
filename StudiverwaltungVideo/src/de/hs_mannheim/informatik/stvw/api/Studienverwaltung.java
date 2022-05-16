package de.hs_mannheim.informatik.stvw.api;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.informatik.stvw.domain.Prüfung;
import de.hs_mannheim.informatik.stvw.domain.Student;

public class Studienverwaltung {
	private List<Student> studierende = new ArrayList<>();
	private List<Prüfung> prüfungen = new ArrayList<>();
	
	public void studentAnlegen(String vorname, String name, int matrikelnummer) {
		studierende.add(new Student(vorname, name, matrikelnummer));
	}
	
	public String studentenDatenAbfragen(int matrikelnummer) {
		for (Student s : studierende)
			if (s.getMatrikelnummer() == matrikelnummer)
				return s.toString();
		
		return null;
	}
	
	public void prüfungAnlegen(String name, int semester, int ects) {
		prüfungen.add(new Prüfung(name, semester, ects));
	}
	
	public String prüfungsDatenAbfragen(String name) {
		for (Prüfung p : prüfungen)
			if (p.getName() == name)
				return p.toString();
		
		return null;
	}
}