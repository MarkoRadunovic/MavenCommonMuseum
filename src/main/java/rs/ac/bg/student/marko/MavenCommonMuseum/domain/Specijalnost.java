package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja specijalnost.
 * @author Marko Radunovic
 * @version 0.1
 */
public class Specijalnost extends DomainObject{
    
	/**
	 * id specijalnosti kao long
	 */
	private long specijalnostId;
    
	/**
	 * oblast na koju se specijalnost odnosi kao String
	 */
	private String oblast;

    /**
     * Konstruktor koji inicijalizuje objekat klase Specijalnost i nista vise.
     */
	public Specijalnost() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Specijalnost i postavlja vrednosti za sve atribute.
     * @param specijalnostId id specijalnosti kao long
     * @param oblast oblast specijalnosti kao String
     */
	public Specijalnost(long specijalnostId, String oblast) {
        this.specijalnostId = specijalnostId;
        this.oblast = oblast;
    }

	/**
	 * Vraca oblast specijalnosti.
	 * @return oblast specijalnosti kao Stirng
	 */
    public String getOblast() {
        return oblast;
    }

    /**
     * Vraca id specijalnosti
     * @return id specijalnosti kao long
     */
    public long getSpecijalnostId() {
        return specijalnostId;
    }

    /**
     * Postavlja oblast specijalnosti na novu vrednost.
     * @param oblast oblast specijalnosti kao String
     */
    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    /**
     * Postavlja id specijalnosti na novu vrednost
     * @param specijalnostId id specijalnosti kao long
     */
    public void setSpecijalnostId(int specijalnostId) {
        this.specijalnostId = specijalnostId;
    }

    /**
     * Vraca oblast specijalnosti kao String.
     */
    @Override
    public String toString() {
        return oblast;
    }


    /**
     * Poredi dve specijalnosti prema identifikacionom broju i proverava da li su iste. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase Specijalnost i imaju isti specijalnostId </li>
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
        final Specijalnost other = (Specijalnost) obj;
        if (this.specijalnostId != other.specijalnostId) {
            return false;
        }
        return true;
    }

    @Override
    public String getQueryForAll() {
        return "select * from specijalnost";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long specijalnostId = rs.getLong("specijalnostId");
            String oblast = rs.getString("oblast");
            Specijalnost specijalnost = new Specijalnost(specijalnostId, oblast);
            
            list.add(specijalnost);
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
