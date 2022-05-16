package de.hs_mannheim.informatik.stvw.domain;

import java.util.ArrayList;

public class Student {
	private String vorname, name;
	private int matrikelnummer;
	private ArrayList<Prüfung> prüfungen = new ArrayList<>();
	
	public Student(String vorname, String name, int matrikelnummer) {
		this.vorname = vorname;
		this.name = name;
		this.matrikelnummer = matrikelnummer;
	}
	
	public void prüfungAnmelden(Prüfung prüfung) {
		prüfungen.add(prüfung);
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	@Override
	public String toString() {
		return "Student [vorname=" + vorname + ", name=" + name + ", matrikelnummer=" + matrikelnummer + "]";
	}
	
}

