package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

class IzlozbaTest {

	Izlozba izlozba;
	@BeforeEach
	void setUp() throws Exception {
		izlozba = new Izlozba();
	}

	@AfterEach
	void tearDown() throws Exception {
		izlozba = null;
	}

	@Mock
	ResultSet resultSet;
	@Test
	void testGetListResultSet() {
		try {
			resultSet = Mockito.mock(ResultSet.class);
			Date date = new Date();
				       
	        Mockito.when(resultSet.getLong("kustosId")).thenReturn(155l);
	        Mockito.when(resultSet.getString("adresa")).thenReturn("a");
	        Mockito.when(resultSet.getInt("godine")).thenReturn(28);
	        Mockito.when(resultSet.getString("ime")).thenReturn("m");
	        Mockito.when(resultSet.getString("prezime")).thenReturn("r");
	        
	        Mockito.when(resultSet.getLong("postavkaId")).thenReturn(10l);
	        Mockito.when(resultSet.getString("nazivPostavke")).thenReturn("n");
	        Mockito.when(resultSet.getDate("datumFormiranja")).thenReturn(new java.sql.Date(date.getTime()));

	        
	        Mockito.when(resultSet.getLong("eksponatId")).thenReturn(22l);
	        Mockito.when(resultSet.getString("nazivEksponata")).thenReturn("eksponat1");
	        Mockito.when(resultSet.getDouble("visina")).thenReturn(55.0);
	        Mockito.when(resultSet.getDouble("tezina")).thenReturn(66.0);
	        Mockito.when(resultSet.getString("starost")).thenReturn("2 godine");
	       
	        Mockito.when(resultSet.getLong("tipId")).thenReturn(33l);
	        Mockito.when(resultSet.getString("nazivTipaEksponata")).thenReturn("nazivTipa");
	        
	        Mockito.when(resultSet.getLong("izlozbaId")).thenReturn(99l);
	        Mockito.when(resultSet.getString("nazivIzlozbe")).thenReturn("nazivIzlozbe");
	        Mockito.when(resultSet.getDate("datumPocetka")).thenReturn(new java.sql.Date(date.getTime()));
	        Mockito.when(resultSet.getDate("datumZavrsetka")).thenReturn(new java.sql.Date(date.getTime()));
	        Mockito.when(resultSet.getInt("brojEksponataIzlozbe")).thenReturn(3);
	        Mockito.when(resultSet.getDouble("ocenaIzlozbe")).thenReturn(8.0);
	        
	        Mockito.when(resultSet.getInt("ocena")).thenReturn(6);
	        
	        
	        
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> izlozbe= izlozba.getList(resultSet);
	        Izlozba i= (Izlozba) izlozbe.get(0);
	        
	        assertNotNull(izlozbe);
	        assertNotNull(i);
	        assertEquals("m", i.getKustos().getIme());
	        assertEquals("a", i.getKustos().getAdresa());
	        assertEquals(28, i.getKustos().getGodine());
	        assertEquals("r", i.getKustos().getPrezime());
	        assertEquals(155l, i.getKustos().getKustosId());
	        
	        assertEquals(10l, i.getList().get(0).getEksponat().getStalnaPostavka().getPostavkaId());
	        assertEquals("n", i.getList().get(0).getEksponat().getStalnaPostavka().getNazivPostavke());
	        assertEquals(date, i.getList().get(0).getEksponat().getStalnaPostavka().getDatumFormiranja());
	        
	        assertEquals(22l, i.getList().get(0).getEksponat().getEksponatId());
	        assertEquals("eksponat1", i.getList().get(0).getEksponat().getNazivEksponata());
	        assertEquals(55.0, i.getList().get(0).getEksponat().getVisina());
	        assertEquals(66.0, i.getList().get(0).getEksponat().getTezina());
	        assertEquals("2 godine", i.getList().get(0).getEksponat().getStarost());
	        assertEquals(33l, i.getList().get(0).getEksponat().getTipEksponata().getTipId());
	        assertEquals("nazivTipa", i.getList().get(0).getEksponat().getTipEksponata().getNazivTipaEksponata());

	        assertEquals(99l, i.getIzlozbaId());
	        assertEquals("nazivIzlozbe", i.getNazivIzlozbe());
	        assertEquals(date, i.getDatumPocetka());
	        assertEquals(date, i.getDatumZavrsetka());
	        assertEquals(3, i.getBrojEksponata());
	        assertEquals(8.0, i.getOcenaIzlozbe());
	        
	        assertEquals(6,i.getList().get(0).getOcena());
        
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> izlozba.getQueryForDelete());
	}

	@Test
	void testSetId() {
		izlozba.setId(15l);
		assertEquals(15l, izlozba.getIzlozbaId());
	}

	@Test
	void testIzlozba() {
		izlozba = new Izlozba();
		assertNotNull(izlozba);
	}

	@Test
	void testIzlozbaLongStringDateDateIntDoubleKustosListOfOcenaEksponata() {
		Date date = new Date();
		Kustos k = new Kustos();
		List<OcenaEksponata> lista = new ArrayList<OcenaEksponata>();
		izlozba = new Izlozba(15l, "n", date, date, 3, 8.0, k, lista);
		
		assertEquals(15l, izlozba.getIzlozbaId());
		assertEquals("n", izlozba.getNazivIzlozbe());
		assertEquals(date, izlozba.getDatumPocetka());
		assertEquals(date, izlozba.getDatumZavrsetka());
		assertEquals(3, izlozba.getBrojEksponata());
		assertEquals(8.0, izlozba.getOcenaIzlozbe());
		assertEquals(k, izlozba.getKustos());
		assertEquals(lista, izlozba.getList());
	}

	@Test
	void testSetIzlozbaId() {
		izlozba.setIzlozbaId(15l);
		assertEquals(15l, izlozba.getIzlozbaId());
	}

	@Test
	void testSetNazivIzlozbe() {
		izlozba.setNazivIzlozbe("n");
		assertEquals("n", izlozba.getNazivIzlozbe());
	}

	@Test
	void testSetDatumPocetka() {
		Date date = new Date();
		izlozba.setDatumPocetka(date);
		assertEquals(date, izlozba.getDatumPocetka());
	}

	@Test
	void testSetDatumZavrsetka() {
		Date date = new Date();
		izlozba.setDatumZavrsetka(date);
		assertEquals(date, izlozba.getDatumZavrsetka());
	}

	@Test
	void testSetBrojEksponata() {
		izlozba.setBrojEksponata(3);
		assertEquals(3, izlozba.getBrojEksponata());
	}

	@Test
	void testSetOcenaIzlozbe() {
		izlozba.setOcenaIzlozbe(8.0);
		assertEquals(8.0, izlozba.getOcenaIzlozbe());
	}

	@Test
	void testSetKustos() {
		Kustos k = new Kustos();
		izlozba.setKustos(k);
		assertEquals(k, izlozba.getKustos());
	}

	@Test
	void testSetList() {
		List<OcenaEksponata> lista = new ArrayList<OcenaEksponata>();
		izlozba.setList(lista);
		assertEquals(lista, izlozba.getList());
	}

	
	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1, String id2, boolean eq) {
		izlozba.setIzlozbaId(Long.valueOf(id1));
		Izlozba i1 = new Izlozba();
		i1.setIzlozbaId(Long.valueOf(id2));
		
		assertEquals(eq, izlozba.equals(i1));
	}

	
	@Test
	void testToString() {
		izlozba.setNazivIzlozbe("n");
		assertEquals("n", izlozba.toString());
	}

}
