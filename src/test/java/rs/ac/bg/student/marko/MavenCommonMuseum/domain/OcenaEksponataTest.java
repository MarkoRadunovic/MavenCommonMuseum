package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.objenesis.instantiator.basic.NewInstanceInstantiator;

class OcenaEksponataTest {

	OcenaEksponata oe;
	
	@BeforeEach
	void setUp() throws Exception {
		oe = new OcenaEksponata();
	}

	@AfterEach
	void tearDown() throws Exception {
		oe = null;
	}

	@Test
	void testGetQueryForAll() {
		assertThrows(UnsupportedOperationException.class, () -> oe.getQueryForAll());
	}

	@Test
	void testGetList() {
		assertThrows(UnsupportedOperationException.class, () -> oe.getList(null));
	}

	@Test
	void testGetQueryForSearch() {
		assertThrows(UnsupportedOperationException.class, () -> oe.getQueryForSearch("neki string"));
		assertThrows(UnsupportedOperationException.class, () -> oe.getQueryForSearch(""));
		assertThrows(UnsupportedOperationException.class, () -> oe.getQueryForSearch(null));
		
	}

	@Test
	void testSetId() {
		assertThrows(UnsupportedOperationException.class, () -> oe.setId(15l));
	}

	@Test
	void testOcenaEksponata() {
		oe = new OcenaEksponata();
		assertNotNull(oe);
	}

	@Test
	void testOcenaEksponataIzlozbaEksponatInt() {
		Izlozba i = new Izlozba(15l, null, null, null, 0, 0, null, null);
		Eksponat e = new Eksponat(14l, null, 0, 0, null, null, null);
		oe = new OcenaEksponata(i, e, 6);
		
		assertNotNull(oe);
		assertEquals(i, oe.getIzlozba());
		assertEquals(e, oe.getEksponat());
		assertEquals(6, oe.getOcena());
	}

	@Test
	void testSetIzlozba() {
		Izlozba i = new Izlozba(15l, null, null, null, 0, 0, null, null);
		oe.setIzlozba(i);
		
		assertEquals(i, oe.getIzlozba());
	}

	@Test
	void testSetEksponat() {
		Eksponat e = new Eksponat(14l, null, 0, 0, null, null, null);
		oe.setEksponat(e);
		
		assertEquals(e, oe.getEksponat());
	}

	@Test
	void testSetOcena() {
		oe.setOcena(6);
		assertEquals(6, oe.getOcena());
	}

	@ParameterizedTest 
	@CsvSource({
		"3, 4, 4, 3, false",
		"3, 4, 3, 4, true",
		"8, 6, 1, 2, false",
		"3, 6, 3, 9, false",
		"3, 6, 9, 6, false",
		"3, 3, 3, 3, true"
	})
	void testEqualsObject(String idE1, String idI1, String idE2, String idI2, boolean eq) {
		Eksponat e1 = new Eksponat();
		e1.setEksponatId(Long.valueOf(idE1));
		
		Izlozba i1 = new Izlozba();
		i1.setIzlozbaId(Long.valueOf(idI1));
		
		oe.setEksponat(e1);
		oe.setIzlozba(i1);
		
		OcenaEksponata oe2 = new OcenaEksponata();
		
		Eksponat e2 = new Eksponat();
		e2.setEksponatId(Long.valueOf(idE2));
		
		Izlozba i2 = new Izlozba();
		i2.setIzlozbaId(Long.valueOf(idI2));
		
		oe2.setEksponat(e2);
		oe2.setIzlozba(i2);
		
		assertEquals(eq, oe.equals(oe2));
	}

	
}
