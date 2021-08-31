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

class EksponatTest {

	Eksponat e;
	
	@BeforeEach
	void setUp() throws Exception {
		e = new Eksponat();
	}

	@AfterEach
	void tearDown() throws Exception {
		e = null;
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

	        
	        Mockito.when(resultSet.getLong("eksponatId")).thenReturn(22l);
	        Mockito.when(resultSet.getString("nazivEksponata")).thenReturn("eksponat1");
	        Mockito.when(resultSet.getDouble("visina")).thenReturn(55.0);
	        Mockito.when(resultSet.getDouble("tezina")).thenReturn(66.0);
	        Mockito.when(resultSet.getString("starost")).thenReturn("2 godine");
	       
	        Mockito.when(resultSet.getLong("tipId")).thenReturn(33l);
	        Mockito.when(resultSet.getString("nazivTipaEksponata")).thenReturn("nazivTipa");
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> eksponati= e.getList(resultSet);
	        Eksponat e= (Eksponat) eksponati.get(0);
	        
	        assertNotNull(eksponati);
	        assertNotNull(e);
	        assertEquals("m", e.getStalnaPostavka().getKustos().getIme());
	        assertEquals("a", e.getStalnaPostavka().getKustos().getAdresa());
	        assertEquals(28, e.getStalnaPostavka().getKustos().getGodine());
	        assertEquals("r", e.getStalnaPostavka().getKustos().getPrezime());
	        assertEquals(15l, e.getStalnaPostavka().getKustos().getSpecijalnost().getSpecijalnostId());
	        assertEquals("oblast", e.getStalnaPostavka().getKustos().getSpecijalnost().getOblast());
	        assertEquals(155l, e.getStalnaPostavka().getKustos().getKustosId());
	        assertEquals(10l, e.getStalnaPostavka().getPostavkaId());
	        assertEquals("n", e.getStalnaPostavka().getNazivPostavke());
	        assertEquals(date, e.getStalnaPostavka().getDatumFormiranja());
	        assertEquals(3, e.getStalnaPostavka().getBrojEksponata());
	        assertEquals(22l, e.getEksponatId());
	        assertEquals("eksponat1", e.getNazivEksponata());
	        assertEquals(55.0, e.getVisina());
	        assertEquals(66.0, e.getTezina());
	        assertEquals("2 godine", e.getStarost());
	        assertEquals(33l, e.getTipEksponata().getTipId());
	        assertEquals("nazivTipa", e.getTipEksponata().getNazivTipaEksponata());

        
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> e.getQueryForDelete());
	}

	@Test
	void testSetId() {
		e.setId(15l);
		assertEquals(15l, e.getEksponatId());
	}

	@Test
	void testEksponat() {
		e = new Eksponat();
		assertNotNull(e);
	}

	@Test
	void testEksponatLongStringDoubleDoubleStringTipEksponataStalnaPostavka() {
		TipEksponata t = new TipEksponata();
		StalnaPostavka sp = new StalnaPostavka();
		e = new Eksponat(15l, "n", 55.0, 66.0, "2 godine", t, sp);
		
		assertNotNull(e);
		assertEquals(15l, e.getEksponatId());
		assertEquals(55.0, e.getVisina());
		assertEquals(66.0, e.getTezina());
		assertEquals("n", e.getNazivEksponata());
		assertEquals("2 godine", e.getStarost());
		assertEquals(t, e.getTipEksponata());
		assertEquals(sp, e.getStalnaPostavka());
	}

	@Test
	void testSetEksponatId() {
		e.setEksponatId(15l);
		assertEquals(15l, e.getEksponatId());
	}

	@Test
	void testSetNazivEksponata() {
		e.setNazivEksponata("n");
		assertEquals("n", e.getNazivEksponata());
	}

	@Test
	void testSetVisina() {
		e.setVisina(55.0);
		assertEquals(55.0, e.getVisina());
	}

	@Test
	void testSetTezina() {
		e.setTezina(66.0);
		assertEquals(66.0, e.getTezina());
	}

	@Test
	void testSetStarost() {
		e.setStarost("starost1");
		assertEquals("starost1", e.getStarost());
	}

	@Test
	void testSetTipEksponata() {
		TipEksponata t = new TipEksponata();
		t.setTipId(15l);
		e.setTipEksponata(t);
		assertEquals(t, e.getTipEksponata());
	}

	@Test
	void testSetStalnaPostavka() {
		StalnaPostavka sp = new StalnaPostavka();
		e.setStalnaPostavka(sp);
		assertEquals(sp, e.getStalnaPostavka());
	}

	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1, String id2, boolean eq) {
		e.setEksponatId(Long.valueOf(id1));
		Eksponat e1 = new Eksponat();
		e1.setEksponatId(Long.valueOf(id2));
		
		assertEquals(eq, e.equals(e1));
	}

	@Test
	void testToString() {
		e.setNazivEksponata("n");
		assertEquals("n", e.toString());
	}

}
