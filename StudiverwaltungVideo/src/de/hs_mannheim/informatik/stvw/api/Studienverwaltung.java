package de.hs_mannheim.informatik.stvw.api;

import java.util.ArrayList;
import java.util.List;

import de.hs_mannheim.informatik.stvw.domain.Prüfung;
import de.hs_mannheim.informatik.stvw.domain.Prüfungsanmeldung;
import de.hs_mannheim.informatik.stvw.domain.Student;

public class Studienverwaltung {
	private List<Student> studierende = new ArrayList<>();
	private List<Prüfung> prüfungen = new ArrayList<>();
	
	public void studentAnlegen(String vorname, String name, int matrikelnummer) {
		studierende.add(new Student(vorname, name, matrikelnummer));
	}
	
	public String studentenDatenAbfragen(int matrikelnummer) {
		Student s = findeStudent(matrikelnummer);
		
		if (s == null)
			return null;
		
		return s.toString();
	}
	
	public void prüfungAnlegen(String name, int semester, int ects) {
		prüfungen.add(new Prüfung(name, semester, ects));
	}
	
	public String prüfungsDatenAbfragen(String name) {
		Prüfung p = findePrüfung(name);
		
		if (p == null)
			return null;
		
		return p.toString();
	}
	
	public void prüfungAnmelden(int matrikelnummer, String prüfungsname) {
		Student s = findeStudent(matrikelnummer);
		Prüfung p = findePrüfung(prüfungsname);
		
		if (s == null || p == null)
			return; 	// hier sollte man in der Praxis eine Exception werfen
		
		Prüfungsanmeldung pam = new Prüfungsanmeldung(s, p);
	}
	
	// Hilfsmethode, aktuell nur für das Testen genutzt
	public int getAnzahlAnmeldungen(String prüfungsname) {
		Prüfung p = findePrüfung(prüfungsname);
		
		if (p == null)
			return 0;
		
		return p.getAnzahlAnmeldungen();
	}
	
	private Student findeStudent(int matrikelnummer) {
		for (Student s : studierende)
			if (s.getMatrikelnummer() == matrikelnummer)
				return s;
		
		return null;
	}
	
	private Prüfung findePrüfung(String name) {
		for (Prüfung p : prüfungen)
			if (p.getName() == name)
				return p;
		
		return null;
	}
	
}
