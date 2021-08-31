package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja kustosa.
 * @author Marko Radunovic
 * @version 0.1
 *
 */
public class Kustos extends DomainObject{
    
	/**
	 * id kustosa kao long
	 */
    private long kustosId;
    
    /**
     * ime kustosa kao String
     */
    private String ime;
    
    /**
     * prezime kustosa kao String
     */
    private String prezime;
    
    /**
     * godine kustosa kao int
     */
    private int godine;
    
    /**
     * adresa kustosa kao String
     */
    private String adresa;
    
    /**
     * Instanca klase Specijalnost koja predstavlja oblast koju je kustos specijalizirao 
     */
    private Specijalnost specijalnost;

    /**
     * Konstruktor koji inicijalizuje objekat klase Kustos i nista vise
     */
    public Kustos() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Kustos i postavlja vrednosti za sve atribute
     * @param kustosId id kustosa kao long
     * @param ime ime kustosa kao String
     * @param prezime prezime kustosa kao String
     * @param godine godine kustosa kao int
     * @param adresa adresa kustosa kao String
     * @param specijalnost instanca klase Specijalnost koja predstavlja specijalnost kustosa
     */
    public Kustos(long kustosId, String ime, String prezime, int godine, String adresa, Specijalnost specijalnost) {
        this.kustosId = kustosId;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.adresa = adresa;
        this.specijalnost = specijalnost;
    }

    /**
     * Vraca id kustosa
     * @return id kustosa kao long
     */
    public long getKustosId() {
        return kustosId;
    }

    /**
     * Postavlja id kustosa na novu vrednost
     * @param kustosId id kustosa kao long
     */
    public void setKustosId(long kustosId) {
        this.kustosId = kustosId;
    }

    /**
     * Vraca ime kustosa
     * @return ime kustosa kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime kustosa na novu vrednost
     * @param ime ime kustosa kao String
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca prezime kustosa
     * @return prezime kustosa kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime kustosa na novu vrednost
     * @param prezime prezime kustosa kao String
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Vraca godine kustosa
     * @return godine kustosa kao int
     */
    public int getGodine() {
        return godine;
    }

    /**
     * Postavlja godine kustosa na novu vrednost
     * @param godine godine kustosa kao int
     */
    public void setGodine(int godine) {
        this.godine = godine;
    }

    /**
     * Vraca adresu kustosa
     * @return adresa kustosa kao String
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Postavlja adresu kustosa na novu vrednost
     * @param adresa adresa kustosa kao String
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Vraca specijalnost kustosa
     * @return instaca klase Specijalnost koja predstavlja specijalnost kustosa u odredjenoj oblasti
     */
    public Specijalnost getSpecijalnost() {
        return specijalnost;
    }

    /**
     * Postavlja specijalnost kustosa na novu vrednost
     * @param specijalnost specijalnost kustosa kao instanca klase Specijalnost
     */
    public void setSpecijalnost(Specijalnost specijalnost) {
        this.specijalnost = specijalnost;
    }

    /**
     * Poredi dva kustosa prema identifikacionom broju i proverava da li su isti. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase Kustos i imaju isti kustosId </li>
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
        final Kustos other = (Kustos) obj;
        if (this.kustosId != other.kustosId) {
            return false;
        }
        return true;
    }

    /**
     * Vraca ime i prezime kustosa kao String
     */
    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String getQueryForAll() {
        return "Select * from kustos inner join specijalnost on kustos.specijalnostId = specijalnost.specijalnostId";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long specijalnostId = rs.getLong("specijalnostId");
            String oblast = rs.getString("oblast");
            Specijalnost specijalnost = new Specijalnost(specijalnostId, oblast);
            
            long kustosId = rs.getLong("kustosId");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            int godine = rs.getInt("godine");
            String adresa = rs.getString("adresa");
            
            Kustos kustos = new Kustos(kustosId, ime, prezime, godine, adresa, specijalnost);
            list.add(kustos);
        }
        rs.close();
        return list;
    }

    @Override
    public String getQueryForSearch(String parametar) {
        return "Select * from kustos inner join specijalnost on kustos.specijalnostId = specijalnost.specijalnostId where CONCAT(ime, ' ', prezime)  like '%"+parametar+"%' or godine like '%"+parametar+"%' or adresa like '%"+parametar+"%' or specijalnost.oblast like '%"+parametar+"%'";
    }

    @Override
    public String getQueryForInsert() {
        return "Insert into kustos(ime,prezime,godine,adresa,specijalnostId) values ('"+ime+"','"+prezime+"',"+godine+",'"+adresa+"',"+specijalnost.getSpecijalnostId()+")";
    }

    @Override
    public String getQueryForUpdate() {
        return "Update kustos set ime='"+ime+"', prezime ='"+prezime+"', godine="+godine+", adresa ='"+adresa+"',  specijalnostId="+specijalnost.getSpecijalnostId()+" where kustosId="+kustosId;
    }

    @Override
    public String getQueryForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public void setId(long id) {
        this.kustosId = id;
    }
    
    
}
