package de.hs_mannheim.informatik.stvw.domain;

import java.util.ArrayList;

public class Prüfung {
	private String name;
	private int semester;
	private int ects;
	private ArrayList<Student> studierende = new ArrayList<Student>();
	
	public Prüfung(String name, int semester, int ects) {
		this.name = name;
		this.semester = semester;
		this.ects = ects;
	}
	
	public void studentAnmelden(Student student) {
		studierende.add(student);
	}
	
	// Hilfsmethode um etwas testen zu können
	public int getAnzahlAnmeldungen() {
		return studierende.size();
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
