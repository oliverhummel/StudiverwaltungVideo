package de.hs_mannheim.informatik.stvw.domain;

import java.util.Objects;

public class Student {
	private String vorname, name;
	private int matrikelnummer;
	
	public Student(String vorname, String name, int matrikelnummer) {
		this.vorname = vorname;
		this.name = name;
		this.matrikelnummer = matrikelnummer;
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

