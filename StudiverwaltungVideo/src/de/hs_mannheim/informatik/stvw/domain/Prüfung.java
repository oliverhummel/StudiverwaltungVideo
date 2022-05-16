package de.hs_mannheim.informatik.stvw.domain;

import java.util.ArrayList;

public class Prüfung {
	private String name;
	private int semester;
	private int ects;
	private ArrayList<Prüfungsanmeldung> anmeldungen = new ArrayList<>();
	
	public Prüfung(String name, int semester, int ects) {
		this.name = name;
		this.semester = semester;
		this.ects = ects;
	}
	
	public void studentAnmelden(Prüfungsanmeldung anmeldung) {
		anmeldungen.add(anmeldung);
	}
	
	// Hilfsmethode um etwas testen zu können
	public int getAnzahlAnmeldungen() {
		return anmeldungen.size();
	}
	
	public String getName() {
		return name;
	}
	public int getSemester() {
		return semester;
	}
	public int getEcts() {
		return ects;
	}
	
	@Override
	public String toString() {
		return "Prüfung " + name + ", " + semester + ". Semester (" + ects + " ECTS)";
	}
	
}
