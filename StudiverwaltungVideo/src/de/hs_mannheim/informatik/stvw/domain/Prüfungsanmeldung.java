package de.hs_mannheim.informatik.stvw.domain;

public class Prüfungsanmeldung {
	private final Student student;
	private final Prüfung prüfung;
	private int note;
	
	public Prüfungsanmeldung(Student student, Prüfung prüfung) {
		super();
		this.student = student;
		this.prüfung = prüfung;
		
		student.prüfungAnmelden(this);
		prüfung.studentAnmelden(this);
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Student getStudent() {
		return student;
	}

	public Prüfung getPrüfung() {
		return prüfung;
	}
	
}
