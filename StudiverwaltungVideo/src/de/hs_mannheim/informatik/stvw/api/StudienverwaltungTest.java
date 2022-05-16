package de.hs_mannheim.informatik.stvw.api;

import static org.junit.Assert.assertNull;
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

}
