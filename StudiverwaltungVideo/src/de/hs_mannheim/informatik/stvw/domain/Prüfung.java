package de.hs_mannheim.informatik.stvw.domain;

public class Prüfung {
	private String name;
	private int semester;
	private int ects;
	
	public Prüfung(String name, int semester, int ects) {
		this.name = name;
		this.semester = semester;
		this.ects = ects;
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
