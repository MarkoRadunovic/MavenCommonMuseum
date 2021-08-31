package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja korisnika sistema.
 * @author Marko Radunovic
 * @version 0.1
 */
public class User extends DomainObject{
    
	/**
	 * id korisnika kao long 
	 */
    private long userId;
    
    /**
     * username korisnika kao String
     */
    private String username;
    
    /**
     * password korisnika kao String
     */
    private String password;
    
    /**
     * ime korisnika kao String
     */
    private String ime;
    
    /**
     * prezime korisnika kao String
     */
    private String prezime;

    /**
     * Konstruktor koji inicijalizuje objekat klase User i nista vise.
     */
    public User() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase User i postavlja vrednosti za sve atribute.
     * @param userId id korisnika kao long
     * @param username username korisnika kao String
     * @param password password korisnika kao String
     * @param ime ime korsinika kao String
     * @param prezime prezime korisnika kao String
     */
    public User(long userId, String username, String password, String ime, String prezime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    /**
     * Vraca id korisnika
     * @return id korisnika kao long
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Postavlja id korisnika na novu vrednost
     * @param userId id korisnika kao long
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Vraca korisnicko ime korisnika
     * @return korisnicko ime korisnika kao String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja korisnicko ime korisnika na novu vrednost
     * @param username korisnicko ime korsinika kao String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Vraca sifru korisnika
     * @return sifra korisnika kao string
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja sifru korisnika na novu vrednost
     * @param password sifra korisnika kao String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Vraca ime korisnika
     * @return ime korisnika kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime korsinika na novu vrednost
     * @param ime ime korisnika kao String
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca prezime korisnika
     * @return prezime korisnika kao string
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime korisnika na novu vrednost
     * @param prezime prezime korisnika kao String
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Poredi dva korisnika prema identifikacionom broju i proverava da li su isti. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase Eksponat i imaju isti userId </li>
     * 			<li>false - U svim ostalim slucajevima</li>
     * 		  </ul>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    /**
     * Vraca ime i prezime korisnika kao String
     */
    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String getQueryForAll() {
        return "Select * from user";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long userId = rs.getLong("userId");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            User user = new User(userId, username, password, ime, prezime);
            list.add(user);
        }
        rs.close();
        return list;
    }

    @Override
    public String getQueryForSearch(String parametar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getQueryForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getQueryForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}