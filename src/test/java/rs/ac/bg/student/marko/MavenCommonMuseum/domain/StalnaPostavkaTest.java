package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

class StalnaPostavkaTest {

	StalnaPostavka sp;
	
	@BeforeEach
	void setUp() throws Exception {
		sp = new StalnaPostavka();
	}

	@AfterEach
	void tearDown() throws Exception {
		sp = null;
	}

	@Mock
	ResultSet resultSet;
	@Test
	void testGetList() {
		try {
			resultSet = Mockito.mock(ResultSet.class);
			Date date = new Date();
			
	        Mockito.when(resultSet.getLong("specijalnostId")).thenReturn(15l);
	        Mockito.when(resultSet.getString("oblast")).thenReturn("oblast");
	       
	        Mockito.when(resultSet.getLong("kustosId")).thenReturn(155l);
	        Mockito.when(resultSet.getString("adresa")).thenReturn("a");
	        Mockito.when(resultSet.getInt("godine")).thenReturn(28);
	        Mockito.when(resultSet.getString("ime")).thenReturn("m");
	        Mockito.when(resultSet.getString("prezime")).thenReturn("r");
	        
	        Mockito.when(resultSet.getLong("postavkaId")).thenReturn(10l);
	        Mockito.when(resultSet.getString("nazivPostavke")).thenReturn("n");
	        Mockito.when(resultSet.getDate("datumFormiranja")).thenReturn(new java.sql.Date(date.getTime()));
	        Mockito.when(resultSet.getInt("brojEksponata")).thenReturn(3);
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> postavke= sp.getList(resultSet);
	        StalnaPostavka sp= (StalnaPostavka) postavke.get(0);
	        
	        assertNotNull(postavke);
	        assertNotNull(sp);
	        assertEquals("m", sp.getKustos().getIme());
	        assertEquals("a", sp.getKustos().getAdresa());
	        assertEquals(28, sp.getKustos().getGodine());
	        assertEquals("r", sp.getKustos().getPrezime());
	        assertEquals(15l, sp.getKustos().getSpecijalnost().getSpecijalnostId());
	        assertEquals("oblast", sp.getKustos().getSpecijalnost().getOblast());
	        assertEquals(155l, sp.getKustos().getKustosId());
	        assertEquals(10l, sp.getPostavkaId());
	        assertEquals("n", sp.getNazivPostavke());
	        assertEquals(date, sp.getDatumFormiranja());
	        assertEquals(3, sp.getBrojEksponata());
        
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> sp.getQueryForDelete());
	}

	@Test
	void testSetId() {
		sp.setId(15l);
		assertEquals(15l, sp.getPostavkaId());
	}

	@Test
	void testStalnaPostavka() {
		sp = new StalnaPostavka();
		assertNotNull(sp);
	}

	@Test
	void testStalnaPostavkaLongStringDateIntKustos() {
		Date datum = new Date();
		Kustos k = new Kustos();
		sp = new StalnaPostavka(15l, "sp1", datum, 3, k);
		
		assertNotNull(sp);
		assertEquals(15l, sp.getPostavkaId());
		assertEquals("sp1", sp.getNazivPostavke());
		assertEquals(datum, sp.getDatumFormiranja());
		assertEquals(3, sp.getBrojEksponata());
		assertEquals(k, sp.getKustos());
		
	}

	@Test
	void testSetPostavkaId() {
		sp.setPostavkaId(15l);
		assertEquals(15l, sp.getPostavkaId());
	}

	@Test
	void testSetNazivPostavke() {
		sp.setNazivPostavke("n");
		assertEquals("n", sp.getNazivPostavke());
	}

	@Test
	void testSetDatumFormiranja() {
		Date d = new Date();
		sp.setDatumFormiranja(d);
		assertEquals(d, sp.getDatumFormiranja());
	}

	@Test
	void testSetBrojEksponata() {
		sp.setBrojEksponata(3);
		assertEquals(3, sp.getBrojEksponata());
	}

	@Test
	void testSetKustos() {
		Specijalnost s = new Specijalnost();
		Kustos k = new Kustos(15l, "m", "r", 28, "a", s);
		
		sp.setKustos(k);
		assertEquals(k, sp.getKustos());
	}

	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1, String id2, boolean eq) {
		sp.setPostavkaId(Long.valueOf(id1));
		StalnaPostavka sp1 = new StalnaPostavka();
		sp1.setPostavkaId(Long.valueOf(id2));
		
		assertEquals(eq, sp.equals(sp1));
	}

	@Test
	void testToString() {
		sp.setNazivPostavke("n");
		assertEquals("n", sp.toString());
	}

}
