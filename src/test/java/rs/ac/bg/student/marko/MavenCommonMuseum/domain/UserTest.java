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

class UserTest {

	User user;
	@BeforeEach
	void setUp() throws Exception {
		user = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
	}

	@Mock
	ResultSet resultSet;
	@Test
	void testGetList() {
		try {
			resultSet = Mockito.mock(ResultSet.class);
	        Mockito.when(resultSet.getLong("userId")).thenReturn(15l);
	        Mockito.when(resultSet.getString("username")).thenReturn("u");
	        Mockito.when(resultSet.getString("password")).thenReturn("p");
	        Mockito.when(resultSet.getString("ime")).thenReturn("m");
	        Mockito.when(resultSet.getString("prezime")).thenReturn("r");
	        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
	        
	        List<DomainObject> users= user.getList(resultSet);
	        User u = (User) users.get(0);
	        
	        assertNotNull(users);
	        assertNotNull(u);
	        assertEquals("m", u.getIme());
	        assertEquals("p", u.getPassword());
	        assertEquals("r", u.getPrezime());
	        assertEquals("u", u.getUsername());
	        assertEquals(15l, u.getUserId());
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetQueryForSearch() {
		assertThrows(UnsupportedOperationException.class, () -> user.getQueryForSearch(null));
		assertThrows(UnsupportedOperationException.class, () -> user.getQueryForSearch(""));
		assertThrows(UnsupportedOperationException.class, () -> user.getQueryForSearch("Neki string"));
	}

	@Test
	void testGetQueryForInsert() {
		assertThrows(UnsupportedOperationException.class, () -> user.getQueryForInsert());
	}

	@Test
	void testGetQueryForUpdate() {
		assertThrows(UnsupportedOperationException.class, () -> user.getQueryForUpdate());
	}

	@Test
	void testGetQueryForDelete() {
		assertThrows(UnsupportedOperationException.class, () -> user.getQueryForDelete());
	}

	@Test
	void testIsAutoIncrement() {
		assertThrows(UnsupportedOperationException.class, () -> user.isAutoIncrement());
	}

	@Test
	void testSetId() {
		assertThrows(UnsupportedOperationException.class, () -> user.setId(15));
	}

	@Test
	void testUser() {
		user = new User();
		assertNotNull(user);
	}

	@Test
	void testUserLongStringStringStringString() {
		user = new User(15, "u", "p", "m", "r");
		
		assertNotNull(user);
		assertEquals(15, user.getUserId());
		assertEquals("u", user.getUsername());
		assertEquals("p", user.getPassword());
		assertEquals("m", user.getIme());
		assertEquals("r", user.getPrezime());
	}

	@Test
	void testSetUserId() {
		user.setUserId(15l);
		assertEquals(15l, user.getUserId());
	}

	@Test
	void testSetUsername() {
		user.setUsername("m");
		assertEquals("m", user.getUsername());
	}

	@Test
	void testSetPassword() {
		user.setPassword("m");
		assertEquals("m", user.getPassword());
	}

	@Test
	void testSetIme() {
		user.setIme("m");
		assertEquals("m", user.getIme());
	}

	@Test
	void testSetPrezime() {
		user.setPrezime("m");
		assertEquals("m", user.getPrezime());
	}

	@ParameterizedTest 
	@CsvSource({
		"1, 2, false",
		"1, 1, true",
		"12, 12, true",
		"6, 4, false"
	})
	void testEqualsObject(String id1, String id2, boolean eq) {
		user.setUserId(Long.valueOf(id1));
		User user1 = new User();
		user1.setUserId(Long.valueOf(id2));
		
		assertEquals(eq, user.equals(user1));
	}

	@Test
	void testToString() {
		user.setIme("m");
		user.setPrezime("r");
		assertEquals("m r", user.toString());
	}

}
