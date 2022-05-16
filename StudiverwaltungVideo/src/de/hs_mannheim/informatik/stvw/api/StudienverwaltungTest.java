package de.hs_mannheim.informatik.stvw.api;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StudienverwaltungTest {

	@Test
	void testStudentAnlegen() {
		Studienverwaltung stvw = new Studienverwaltung();
		stvw.studentAnlegen("Klaus", "Mayer", 123456);
		
		String daten = stvw.studentenDatenAbfragen(123456);
		assertTrue(daten.contains("Klaus"));
		assertTrue(daten.contains("Mayer"));
		assertTrue(daten.contains("123456"));
		
		daten = stvw.studentenDatenAbfragen(111111);
		assertNull(daten);
	}
	
	@Test
	void testPrüfungAnlegen() {
		Studienverwaltung stvw = new Studienverwaltung();
		stvw.prüfungAnlegen("Programmierung 2", 2, 10);
		
		String daten = stvw.prüfungsDatenAbfragen("Programmierung 2");
		assertTrue(daten.contains("Programmierung 2"));
		assertTrue(daten.contains("2. Semester"));
		assertTrue(daten.contains("10 ECTS"));
		
		daten = stvw.prüfungsDatenAbfragen("gibtEsNicht");
		assertNull(daten);
	}
	
	@Test
	void testPrüfungsAnmeldung() {
		Studienverwaltung stvw = new Studienverwaltung();
		
		stvw.studentAnlegen("Klaus", "Mayer", 123456);
		stvw.studentAnlegen("Katja", "Fischer", 224561);
		
		stvw.prüfungAnlegen("Programmierung 1", 1, 10);
		stvw.prüfungAnlegen("Programmierung 2", 2, 10);
		
		stvw.prüfungAnmelden(123456, "Programmierung 1");
		stvw.prüfungAnmelden(224561, "Programmierung 1");
		
		assertEquals(2, stvw.getAnzahlAnmeldungen("Programmierung 1"));
		assertEquals(0, stvw.getAnzahlAnmeldungen("Programmierung 2"));
	}
	
	@Test
	void testNotenschnittBerechnung() {
		Studienverwaltung stvw = new Studienverwaltung();
		
		stvw.studentAnlegen("Katja", "Fischer", 224561);
		
		stvw.prüfungAnlegen("Programmierung 1", 1, 10);
		stvw.prüfungAnlegen("Datenmanagement", 3, 5);
		
		stvw.prüfungAnmelden(224561, "Programmierung 1");
		stvw.prüfungAnmelden(224561, "Datenmanagement");
		
		assertEquals(1, stvw.getAnzahlAnmeldungen("Programmierung 1"));
		assertEquals(1, stvw.getAnzahlAnmeldungen("Datenmanagement"));
		
		// Your mission, should you chose to accept it...
		stvw.noteEintragen(224561, "Programmierung 1", 170);
		stvw.noteEintragen(224561, "Datenmanagement", 130);
		
		assertEquals(156, stvw.notenschnittAbfragen(224561));
	}

}
