package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja tip eksponata.
 * 
 * @author Marko Radunovic
 * @version 0.1
 *
 */
public class TipEksponata extends DomainObject{

	/**
	 * id tipa eksponata kao long
	 */
    private long tipId;
    
    /**
     * naziv tipa eksponata kao String
     */
    private String nazivTipaEksponata;

    /**
     * Konstruktor koji inicijalizuje objekat klase TipEksponata i nista vise.
     */
    public TipEksponata() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase TipEksponata i postavlja vrednosti za sve atribute.
     * @param tipId id tipa eksponata kao long
     * @param nazivTipaEksponata naziv tipa kao String
     */
    public TipEksponata(long tipId, String nazivTipaEksponata) {
        this.tipId = tipId;
        this.nazivTipaEksponata = nazivTipaEksponata;
    }

    /**
     * Vraca naziv tipa eksponata.
     * @return naziv tipa eksponata kao String
     */
    public String getNazivTipaEksponata() {
        return nazivTipaEksponata;
    }

    /**
     * Vraca id eksponata.
     * @return id eksponata kao long
     */
    public long getTipId() {
        return tipId;
    }

    /**
     * Postavlja naziv tipa eksponata na novu vrednost.
     * @param nazivTipaEksponata naziv eksponata kao String
     */
    public void setNazivTipaEksponata(String nazivTipaEksponata) {
        this.nazivTipaEksponata = nazivTipaEksponata;
    }

    /**
     * Postavlja id tipa eksponata na novu vrednost.
     * @param tipId id tipa kao long
     */
    public void setTipId(long tipId) {
        this.tipId = tipId;
    }


    /**
     * 
     * Poredi dva tipa eksponata prema identifikacionom broju i proverava da li su isti. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase TipEksponata i imaju isti tipId </li>
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
        final TipEksponata other = (TipEksponata) obj;
        if (this.tipId != other.tipId) {
            return false;
        }
        return true;
    }

    /**
     * Vraca naziv tipa eksponata kao String
     */
    @Override
    public String toString() {
        return nazivTipaEksponata;
    }
    
    
    @Override
    public String getQueryForAll() {
        return "Select * from tipeksponata";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long tipId = rs.getLong("tipId");
            String nazivTipaEksponata = rs.getString("nazivTipaEksponata");
            TipEksponata tipEksponata = new TipEksponata(tipId, nazivTipaEksponata);
            list.add(tipEksponata);
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