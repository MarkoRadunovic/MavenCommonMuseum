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

class TipEksponataTest {

	TipEksponata tip;
	
	@BeforeEach
	void setUp() throws Exception {
		tip = new TipEksponata();
	}

	@AfterEach
	void tearDown() throws Exception {
		tip = null;
	}

	@Test
	void testGetQueryForAll() {
		
		assertEquals("Select * from tipeksponata", tip.getQueryForAll());
	}

	@Mock
	ResultSet resultSet;
	@Test
	void testGetList() {
		try {
			resultSet = Mockito.mock(ResultSet.class);
	        Mockito.when(resultSet.getLong("tipId")).thenReturn(15l);
	        Mockito.when(resultSet.getString("nazivTipaEksponata")).thenReturn("nazivTipa");
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> tipovi= tip.getList(resultSet);
            TipEksponata tip= (TipEksponata)tipovi.get(0);
            
            assertNotNull(tipovi);
            assertNotNull(tip);
            assertEquals("nazivTipa", tip.getNazivTipaEksponata());
            assertEquals(15l, tip.getTipId());
	        
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@Test
	void testGetQueryForSearch() {
		assertThrows(UnsupportedOperationException.class, () -> tip.getQueryForSearch(null));
		assertThrows(UnsupportedOperationException.class, () -> tip.getQueryForSearch(""));
		assertThrows(UnsupportedOperationException.class, () -> tip.getQueryForSearch("Neki string"));
	}

	@Test
	void testGetQueryForInsert() {
		assertThrows(UnsupportedOperationException.class, () -> tip.getQueryForDelete());
	}

	@Test
	void testGetQueryForUpdate() {
		assertThrows(UnsupportedOperationException.class, () -> tip.getQueryForUpdate());
	}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> tip.getQueryForDelete());
	}

	@Test
	void testIsAutoIncrement() {
		assertThrows(UnsupportedOperationException.class, () -> tip.isAutoIncrement());
	}

	@Test
	void testSetId() {
		assertThrows(UnsupportedOperationException.class, () -> tip.setId(1));
		assertThrows(UnsupportedOperationException.class, () -> tip.setId(50));
		assertThrows(UnsupportedOperationException.class, () -> tip.setId(111));
	}

	@Test
	void testTipEksponata() {
		tip = new TipEksponata();
		assertNotNull(tip);
	}

	@Test
	void testTipEksponataLongString() {
		tip = new TipEksponata(11, "tip1");
		assertNotNull(tip);
		assertEquals(11,tip.getTipId());
		assertEquals("tip1", tip.getNazivTipaEksponata());
	}

	@Test
	void testSetNazivTipaEksponata() {
		tip.setNazivTipaEksponata("novi tip");
		assertEquals("novi tip", tip.getNazivTipaEksponata());
	}

	@Test
	void testSetTipId() {
		tip.setTipId(12);
		assertEquals(12, tip.getTipId());
	}

	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1, String id2, boolean eq) {
		tip.setTipId(Long.parseLong(id1));
		TipEksponata tip1 = new TipEksponata();
		
		tip1.setTipId(Long.parseLong(id2));
		
		assertEquals(eq, tip.equals(tip1));
	}

	@Test
	void testToString() {
		tip.setNazivTipaEksponata("novi tip");
		assertEquals("novi tip", tip.toString());
	}

}
