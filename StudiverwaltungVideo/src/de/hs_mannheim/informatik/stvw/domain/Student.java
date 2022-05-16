package de.hs_mannheim.informatik.stvw.domain;

import java.util.ArrayList;

public class Student {
	private String vorname, name;
	private int matrikelnummer;
	private ArrayList<Prüfungsanmeldung> anmeldungen = new ArrayList<>();
	
	public Student(String vorname, String name, int matrikelnummer) {
		this.vorname = vorname;
		this.name = name;
		this.matrikelnummer = matrikelnummer;
	}
	
	public void prüfungAnmelden(Prüfungsanmeldung prüfungsanmeldung) {
		anmeldungen.add(prüfungsanmeldung);
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

	public void noteEintragen(Prüfung p, int note) {
		for (Prüfungsanmeldung pam : anmeldungen) {
			if (pam.getPrüfung().equals(p)) {
				pam.setNote(note);
				break;
			}
		}
		
	}

	public int notenschnittBerechnen() {
		int notenSumme = 0;
		int ectsSumme = 0;
		
		for (Prüfungsanmeldung pam : anmeldungen) {
			int ects = pam.getPrüfung().getEcts();
			notenSumme += pam.getNote() * ects;
			ectsSumme += ects;
		}
		
		return notenSumme / ectsSumme;
	}
	
}

