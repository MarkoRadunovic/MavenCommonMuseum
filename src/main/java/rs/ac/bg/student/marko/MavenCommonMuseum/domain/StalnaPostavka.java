package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja stalnu postavku muzeja
 * @author Marko Radunovic
 * @version 0.1
 */
public class StalnaPostavka extends DomainObject {

	/**
	 * id postavke kao long
	 */
    private long postavkaId;
    
    /**
     * naziv postavke kao String
     */
    private String nazivPostavke;
    
    /**
     * datum postavke kao Date
     */
    private Date datumFormiranja;
    
    /**
     * broj eksponata unutar postavke kao int
     */
    private int brojEksponata;
    
    /**
     * kustos stalne postavke kao instanca klase Kustos
     */
    private Kustos kustos;

    /**
     * Konstruktor koji inicijalizuje objekat klase StalnaPostavka i nista vise.a
     */
    public StalnaPostavka() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase StalnaPostavka i postavlja vrednosti za sve atribute
     * @param postavkaId id postavke kao long
     * @param nazivPostavke naziv postavke kao String
     * @param datumFormiranja datum formiranja postavke kao Date
     * @param brojEksponata broj eksponata u postavci kao int
     * @param kustos kustos postavke kao instanca klase Kustos
     */
    public StalnaPostavka(long postavkaId, String nazivPostavke, Date datumFormiranja, int brojEksponata, Kustos kustos) {
        this.postavkaId = postavkaId;
        this.nazivPostavke = nazivPostavke;
        this.datumFormiranja = datumFormiranja;
        this.brojEksponata = brojEksponata;
        this.kustos = kustos;
    }

    /**
     * Vraca id postavke
     * @return id postavke kao long
     */
    public long getPostavkaId() {
        return postavkaId;
    }

    /**
     * Postavlja id postavke na novu vrednost
     * @param postavkaId
     */
    public void setPostavkaId(long postavkaId) {
        this.postavkaId = postavkaId;
    }
    
    /**
     * Vraca naziv postavke
     * @return naziv postavke kao String
     */
    public String getNazivPostavke() {
        return nazivPostavke;
    }

    /**
     * Postavlja naziv postavke na novu vrednost
     * @param nazivPostavke naziv postavke kao String
     */
    public void setNazivPostavke(String nazivPostavke) {
        this.nazivPostavke = nazivPostavke;
    }

    /**
     * Vraca datum formiranja postavke
     * @return datum formiranja postavke kao Date
     */
    public Date getDatumFormiranja() {
        return datumFormiranja;
    }

    /**
     * Postavlja datum formiranja postavke na novu vrednost
     * @param datumFormiranja datum formiranja postavke kao Date
     */
    public void setDatumFormiranja(Date datumFormiranja) {
        this.datumFormiranja = datumFormiranja;
    }

    /**
     * Vraca broj eksponata koji se nalaze u postavci
     * @return broj eksponata koji se nalaze u postavci kao int
     */
    public int getBrojEksponata() {
        return brojEksponata;
    }

    /**
     * Postavlja broj eksponata na novu vrednost
     * @param brojEksponata broj eksponata koji se nalaze u postavci kao int
     */
    public void setBrojEksponata(int brojEksponata) {
        this.brojEksponata = brojEksponata;
    }

    /**
     * Vraca kustosa postavke
     * @return kustos postavke kao instanca klase Kustos
     */
    public Kustos getKustos() {
        return kustos;
    }

    /**
     * Postavlja kustosa postavke na novu vrednost
     * @param kustos kustos postavke kao instanca klase Kustos
     */
    public void setKustos(Kustos kustos) {
        this.kustos = kustos;
    }

    /**
     * Poredi dve stalne postavke prema identifikacionom broju i proverava da li su iste. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase StalnaPostavka i imaju isti postavkaId </li>
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
        final StalnaPostavka other = (StalnaPostavka) obj;
        if (this.postavkaId != other.postavkaId) {
            return false;
        }
        return true;
    }

    /**
     * Vraca naziv postavke kao String
     */
    @Override
    public String toString() {
        return nazivPostavke;
    }

    @Override
    public String getQueryForAll() {
        return "Select * from stalnapostavka inner join kustos on stalnapostavka.kustosId=kustos.kustosId inner join specijalnost on kustos.specijalnostId = specijalnost.specijalnostId";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while (rs.next()) {
            long specijalnostId = rs.getLong("specijalnostId");
            String oblast = rs.getString("oblast");
            Specijalnost specijalnost = new Specijalnost(specijalnostId, oblast);

            long kustosId = rs.getLong("kustosId");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            int godine = rs.getInt("godine");
            String adresa = rs.getString("adresa");

            Kustos kustos = new Kustos(kustosId, ime, prezime, godine, adresa, specijalnost);

            long postavkaId = rs.getLong("postavkaId");
            String nazivPostavke = rs.getString("nazivPostavke");
            Date datumFormiranja = new Date(rs.getDate("datumFormiranja").getTime());
            int brojEksponata = rs.getInt("brojEksponata");

            StalnaPostavka stalnaPostavka = new StalnaPostavka(postavkaId, nazivPostavke, datumFormiranja, brojEksponata, kustos);
            list.add(stalnaPostavka);
        }
        rs.close();
        return list;
    }

    @Override
    public String getQueryForSearch(String parametar) {
        return "Select * from stalnapostavka inner join kustos on stalnapostavka.kustosId=kustos.kustosId inner join specijalnost on kustos.specijalnostId = specijalnost.specijalnostId where nazivPostavke like '%" + parametar + "%' or brojEksponata like '%" + parametar + "%' or CONCAT(kustos.ime, ' ', kustos.prezime) like '%" + parametar + "%' or DATE_FORMAT(stalnapostavka.datumFormiranja,'%d.%m.%Y') like '%" + parametar + "%'";
    }

    @Override
    public String getQueryForInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Insert into stalnapostavka(nazivPostavke,datumFormiranja,brojEksponata,kustosId) values('" + nazivPostavke + "','" + sdf.format(datumFormiranja) + "'," + brojEksponata + "," + kustos.getKustosId() + ")";
    }

    @Override
    public String getQueryForUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Update stalnapostavka set nazivPostavke='" + nazivPostavke + "', datumFormiranja='" + sdf.format(datumFormiranja) + "', brojEksponata=" + brojEksponata + ",kustosId=" + kustos.getKustosId() + " where postavkaId=" + postavkaId;

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
        this.postavkaId = id;
    }

}
