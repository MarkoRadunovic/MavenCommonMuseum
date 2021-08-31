package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

class SpecijalnostTest {

	Specijalnost spec;
	@BeforeEach
	void setUp() throws Exception {
		spec = new Specijalnost();
	}

	@AfterEach
	void tearDown() throws Exception {
		spec = null;
	}

	@Test
	void testGetQueryForAll() {
		assertEquals("select * from specijalnost", spec.getQueryForAll());
	}


	@Mock
	ResultSet resultSet;
	@Test
	void testGetList() {
		try {
			resultSet = Mockito.mock(ResultSet.class);
	        Mockito.when(resultSet.getLong("specijalnostId")).thenReturn(15l);
	        Mockito.when(resultSet.getString("oblast")).thenReturn("oblast");
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> specijalnosti= spec.getList(resultSet);
	        Specijalnost spec= (Specijalnost) specijalnosti.get(0);
	        
	        assertNotNull(specijalnosti);
	        assertNotNull(spec);
	        assertEquals("oblast", spec.getOblast());
	        assertEquals(15l, spec.getSpecijalnostId());
        
		}catch(Exception e){
		e.printStackTrace();
		}
	}

	@Test
	void testGetQueryForSearch() {
		assertThrows(UnsupportedOperationException.class, () -> spec.getQueryForSearch(null));
		assertThrows(UnsupportedOperationException.class, () -> spec.getQueryForSearch(""));
		assertThrows(UnsupportedOperationException.class, () -> spec.getQueryForSearch("Neki string"));
	}

	@Test
	void testGetQueryForInsert() {
		assertThrows(UnsupportedOperationException.class, () -> spec.getQueryForInsert());
	}

	@Test
	void testGetQueryForUpdate() {
		assertThrows(UnsupportedOperationException.class, () -> spec.getQueryForUpdate());
		}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> spec.getQueryForDelete());
	}

	@Test
	void testIsAutoIncrement() {
		assertThrows(UnsupportedOperationException.class, () -> spec.isAutoIncrement());
	}

	@Test
	void testSetId() {
		assertThrows(UnsupportedOperationException.class, () -> spec.setId(15l));
	}

	@Test
	void testSpecijalnost() {
		spec = new Specijalnost();
		assertNotNull(spec);
	}

	@Test
	void testSpecijalnostLongString() {
		spec = new Specijalnost(15l, "s1");
		
		assertNotNull(spec);
		assertEquals(15l, spec.getSpecijalnostId());
		assertEquals("s1", spec.getOblast());
	}

	@Test
	void testSetOblast() {
		spec.setOblast("s1");
		assertEquals("s1", spec.getOblast());
	}

	@Test
	void testSetSpecijalnostId() {
		spec.setSpecijalnostId(15);
		assertEquals(15, spec.getSpecijalnostId());
	}

	@Test
	void testToString() {
		spec.setOblast("o");
		assertEquals("o", spec.toString());
	}

	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1 , String id2 , boolean eq) {
		spec.setSpecijalnostId(Integer.valueOf(id1));
		Specijalnost s1 = new Specijalnost();
		s1.setSpecijalnostId(Integer.valueOf(id2));
		
		assertEquals(eq, spec.equals(s1));
	}

}
