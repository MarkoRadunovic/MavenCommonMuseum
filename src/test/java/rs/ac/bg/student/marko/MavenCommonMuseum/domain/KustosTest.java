package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

class KustosTest {

	Kustos k;
	@BeforeEach
	void setUp() throws Exception {
		k = new Kustos();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
	}

	@Mock
	ResultSet resultSet;
	@Test
	void testGetList() {
		try {
			resultSet = Mockito.mock(ResultSet.class);
	        Mockito.when(resultSet.getLong("specijalnostId")).thenReturn(15l);
	        Mockito.when(resultSet.getString("oblast")).thenReturn("oblast");
	        Mockito.when(resultSet.getLong("kustosId")).thenReturn(155l);
	        Mockito.when(resultSet.getString("adresa")).thenReturn("a");
	        Mockito.when(resultSet.getInt("godine")).thenReturn(28);
	        Mockito.when(resultSet.getString("ime")).thenReturn("m");
	        Mockito.when(resultSet.getString("prezime")).thenReturn("r");
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> kustosi= k.getList(resultSet);
	        Kustos k= (Kustos) kustosi.get(0);
	        
	        assertNotNull(kustosi);
	        assertNotNull(k);
	        assertEquals("m", k.getIme());
	        assertEquals("a", k.getAdresa());
	        assertEquals(28, k.getGodine());
	        assertEquals("r", k.getPrezime());
	        assertEquals(15l, k.getSpecijalnost().getSpecijalnostId());
	        assertEquals("oblast", k.getSpecijalnost().getOblast());
	        assertEquals(155l, k.getKustosId());
        
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> k.getQueryForDelete());
	}

	@Test
	void testSetId() {
		k.setId(15l);
		assertEquals(15l, k.getKustosId());
	}

	@Test
	void testKustos() {
		k = new Kustos();
		assertNotNull(k);
	}

	@Test
	void testKustosLongStringStringIntStringSpecijalnost() {
		Specijalnost s = new Specijalnost(15,"spec1");
		k = new Kustos(15l, "m", "r", 28, "a", s);
		
		assertNotNull(k);
		assertEquals(15l, k.getKustosId());
		assertEquals("m", k.getIme());
		assertEquals("r", k.getPrezime());
		assertEquals(28, k.getGodine());
		assertEquals("a", k.getAdresa());
		assertEquals(s, k.getSpecijalnost());
	}

	@Test
	void testSetKustosId() {
		k.setKustosId(15l);
		assertEquals(15l, k.getKustosId());
	}

	@Test
	void testSetIme() {
		k.setIme("m");
		assertEquals("m", k.getIme());
	}

	@Test
	void testSetPrezime() {
		k.setPrezime("m");
		assertEquals("m", k.getPrezime());
	}

	@Test
	void testSetGodine() {
		k.setGodine(28);
		assertEquals(28, k.getGodine());
	}

	@Test
	void testSetAdresa() {
		k.setAdresa("m");
		assertEquals("m", k.getAdresa());
	}

	@Test
	void testSetSpecijalnost() {
		Specijalnost s = new Specijalnost(15, "s");
		k.setSpecijalnost(s);
		assertEquals(s, k.getSpecijalnost());
	}

	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1, String id2, boolean eq) {
		k.setKustosId(Long.valueOf(id1));
		Kustos k1 = new Kustos();
		k1.setKustosId(Long.valueOf(id2));
		
		assertEquals(eq, k.equals(k1));	
	}

	@Test
	void testToString() {
		k.setIme("m");
		k.setPrezime("r");
		assertEquals("m r", k.toString());
	}

}
