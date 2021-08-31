package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja ocenu eksponata
 * @author Marko Radunovic
 * @version 0.1
 */
public class OcenaEksponata extends DomainObject{
   
	/**
	 * izloba na kojoj je ocena dobijena kao instanca klase Izlozba
	 */
    private Izlozba izlozba;
    
    /**
     * eksponat na koji se ocena odnosi kao instanca klase Eksponat
     */
    private Eksponat eksponat;
    
    /**
     * vrednost ocene kao int
     */
    private int ocena;

    /**
     * Konstruktor koji inicijalizuje objekat klase OcenaEksponata i nista vise.
     */
    public OcenaEksponata() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase OcenaEksponata i postavlja vrednosti za sve atrbute
     * @param izlozba izlozba na kojoj je ocena dobijena kao instanca klase Izlozba
     * @param eksponat eksponat na koji se ocena odnosi kao instanca klase Eksponat
     * @param ocena vrednost ocene kao int
     */
    public OcenaEksponata(Izlozba izlozba, Eksponat eksponat, int ocena) {
        this.izlozba = izlozba;
        this.eksponat = eksponat;
        this.ocena = ocena;
    }

    /**
     * Vrac izlozbu na kojoj je ocena dobijena
     * @return izlozba kao instanca klase Izlozba
     */
    public Izlozba getIzlozba() {
        return izlozba;
    }

    /**
     * Postavlja izlozbu na kojoj je ocena dobijena na novu vrednost
     * @param izlozba izlozba kao instanca klase Izlozba
     */
    public void setIzlozba(Izlozba izlozba) {
        this.izlozba = izlozba;
    }

    /**
     * Vraca eksponat na koji se ocena odnosi
     * @return eksponat kao instanca klase Eksponat
     */
    public Eksponat getEksponat() {
        return eksponat;
    }

    /**
     * Postavlja eksponat na koji se ocena odnosi na novu vrednost
     * @param eksponat eksponat kao instanca klase Eksponat
     */
    public void setEksponat(Eksponat eksponat) {
        this.eksponat = eksponat;
    }

    /**
     * Vraca vrednost ocene eksponata
     * @return vrednost ocene kao int
     */
    public int getOcena() {
        return ocena;
    }

    /**
     * Postavlja vrednost ocene eksponata na novu vrednost
     * @param ocena vrednost ocene eksponata kao int
     */
    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Poredi dve ocene eksponata prema izlozbi i eksponatu na koje se odnose, te proverava da li su isti. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase OcenaIzozbe i sadrze iste instance klase Eksponat i klase Izlozba </li>
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
        final OcenaEksponata other = (OcenaEksponata) obj;
        if (!Objects.equals(this.izlozba, other.izlozba)) {
            return false;
        }
        if (!Objects.equals(this.eksponat, other.eksponat)) {
            return false;
        }
        return true;
    }

    @Override
    public String getQueryForAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getQueryForSearch(String parametar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getQueryForInsert() {
        return "Insert into ocenaeksponata(izlozbaId,eksponatId,ocena) values ("+izlozba.getIzlozbaId()+","+eksponat.getEksponatId()+","+ocena+")";
    }

    @Override
    public String getQueryForUpdate() {
        return "Update ocenaeksponata set ocena="+ocena+" where izlozbaId="+izlozba.getIzlozbaId()+" and eksponatId="+eksponat.getEksponatId();
    }

    @Override
    public String getQueryForDelete() {
        return "Delete from ocenaeksponata where izlozbaId="+izlozba.getIzlozbaId()+" and eksponatId="+eksponat.getEksponatId();
    }

    @Override
    public boolean isAutoIncrement() {
        return false;
    }

    @Override
    public void setId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
