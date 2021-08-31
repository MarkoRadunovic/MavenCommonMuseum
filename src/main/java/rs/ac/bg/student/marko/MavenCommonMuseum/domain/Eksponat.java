package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja eksponat.
 * 
 * @author Marko Radunovic
 * @version 0.1
 */
public class Eksponat extends DomainObject{

	/**
	 * id eksponata kao long
	 */
	private long eksponatId;
    
	/**
	 * naziv eksponata kao String
	 */
	private String nazivEksponata;
    
	/**
	 * visina eksponata u cm kao double
	 */
	private double visina;
    
	/**
	 * tezina eksponata u kg kao double
	 */
	private double tezina;
    
	/**
	 * starost eksponata kao String
	 */
	private String starost;
    
	/**
	 * Instanca klase TipEksponata koja predstavlja kojeg je tipa eksponat
	 */
	private TipEksponata tipEksponata;
    
	/**
	 * Instanca klase StalnaPostavka koja predstavlja stalnu postavku u okviru koje se eksponat nalazi
	 */
	private StalnaPostavka stalnaPostavka;

	/**
	 * Konstruktor koji inicijalizuje objekat klase Eksponat i nista vise
	 */
	public Eksponat() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Eksponat i postavlja vrednosti za sve atribute
     * 
     * @param eksponatId long kao id eksponata
     * @param nazivEksponata String kao naziv eksponata
     * @param visina double kao visina eksponata u cm
     * @param tezina double kao tezina eksponata u kg
     * @param starost String kao starost eksponata
     * @param tipEksponata TipEksponata kao instanca klase TipEksponata koja predstavlja kojeg je tipa eksponat
     * @param stalnaPostavka StalnaPostavka kao instanca klase StalnaPostavka koja predstavlja postavku u kojoj je eksponat
     */
	public Eksponat(long eksponatId, String nazivEksponata, double visina, double tezina, String starost, TipEksponata tipEksponata, StalnaPostavka stalnaPostavka) {
        this.eksponatId = eksponatId;
        this.nazivEksponata = nazivEksponata;
        this.visina = visina;
        this.tezina = tezina;
        this.starost = starost;
        this.tipEksponata = tipEksponata;
        this.stalnaPostavka = stalnaPostavka;
    }

    /**
     * Vraca identifikacioni broj eksponata
     * @return id eksponata kao long 
     */
	public long getEksponatId() {
        return eksponatId;
    }
	
	/**
	 * Postavlja id eksponata na novu vrednost
	 * @param eksponatId id eksponata kao long
	 */
    public void setEksponatId(long eksponatId) {
        this.eksponatId = eksponatId;
    }

    /**
     * Vraca naziv eksponata
     * @return naziv eksponata kao String
     */
    public String getNazivEksponata() {
        return nazivEksponata;
    }

    /**
     * Postavlja naziv eksponata na novu vrednost
     * @param nazivEksponata naziv eksponata kao String
     */
    public void setNazivEksponata(String nazivEksponata) {
        this.nazivEksponata = nazivEksponata;
    }

    /**
     * Vraca visinu eksponata u cm
     * @return visina eksponata kao double
     */
    public double getVisina() {
        return visina;
    }

    /**
     * Postavlja visinu eksponata na novu vrednost
     * @param visina visina eksponata kao double
     */
    public void setVisina(double visina) {
        this.visina = visina;
    }

    /**
     * Vraca tezinu eksponata u kg
     * @return tezina eksponata kao double
     */
    public double getTezina() {
        return tezina;
    }

    /**
     * Postavlja tezinu eksponata na novu vrednost
     * @param tezina tezina eksponata kao double
     */
    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    /**
     * Vraca starost eksponata
     * @return starost eksponata kao String
     */
    public String getStarost() {
        return starost;
    }

    /**
     * Postavlja starost eksponata na novu vrednost
     * @param starost starost eksponata kao String
     */
    public void setStarost(String starost) {
        this.starost = starost;
    }

    /**
     * Vraca instancu klase TipEksponata koja predstavlja kog je tipa eksponat
     * @return tip eksponata kao TipEksponata
     */
    public TipEksponata getTipEksponata() {
        return tipEksponata;
    }

    /**
     * Postavlja tip eksponata na novu vrednost
     * @param tipEksponata tip eksponata kao TipEksponata
     */
    public void setTipEksponata(TipEksponata tipEksponata) {
        this.tipEksponata = tipEksponata;
    }

    /**
     * Vraca instancu klase StalnaPostavka koja predstavlja u okviru koje stalne postavke se nalazi eksponat
     * @return stalna postavka kao StalnaPostavka
     */
    public StalnaPostavka getStalnaPostavka() {
        return stalnaPostavka;
    }

    /**
     * Postavlja stalnu postavku eksponata na novu vrednost
     * @param stalnaPostavka stalna postavka eksponata kao StalnaPostavka
     */
    public void setStalnaPostavka(StalnaPostavka stalnaPostavka) {
        this.stalnaPostavka = stalnaPostavka;
    }


    /**
     * Poredi dva eksponata prema identifikacionom broju i proverava da li su isti. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase Eksponat i imaju isti eksponatId </li>
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
        final Eksponat other = (Eksponat) obj;
        if (this.eksponatId != other.eksponatId) {
            return false;
        }
        return true;
    }

    /**
     * @return  naziv eksponata kao String
     */
    @Override
    public String toString() {
        return nazivEksponata;
    }

    @Override
    public String getQueryForAll() {
        return "Select * from eksponat inner join stalnapostavka on eksponat.stalnaPostavkaId = stalnapostavka.postavkaId inner join kustos on stalnapostavka.kustosId = kustos.kustosId inner join specijalnost on specijalnost.specijalnostId=kustos.specijalnostId inner join tipeksponata on tipeksponata.tipId = eksponat.tipEksponataId";
    }


    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long specijalnostId = rs.getLong("specijalnostId");
            String oblast = rs.getString("oblast");
            Specijalnost specijalnost = new Specijalnost(specijalnostId, oblast);
            
            long kustosId =rs.getLong("kustosId");
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
            
            long eksponatId = rs.getLong("eksponatId");
            String nazivEksponata = rs.getString("nazivEksponata");
            double visina = rs.getDouble("visina");
            double tezina = rs.getDouble("tezina");
            String starost = rs.getString("starost");
            
            long tipId = rs.getLong("tipId");
            String nazivTipaEksponata = rs.getString("nazivTipaEksponata");
            TipEksponata tipEksponata = new TipEksponata(tipId, nazivTipaEksponata);
            
            Eksponat eksponat = new Eksponat(eksponatId, nazivEksponata, visina, tezina, starost, tipEksponata, stalnaPostavka);
            list.add(eksponat);
        }
        rs.close();
        return list;
    }

    @Override
    public String getQueryForSearch(String parametar) {
        return "Select * from eksponat inner join stalnapostavka on eksponat.stalnaPostavkaId = stalnapostavka.postavkaId inner join kustos on stalnapostavka.kustosId = kustos.kustosId inner join specijalnost on specijalnost.specijalnostId=kustos.specijalnostId inner join tipeksponata on eksponat.tipEksponataId=tipeksponata.tipId where nazivEksponata like '%"+parametar+"%' or visina like '%"+parametar+"%' or tezina like '%"+parametar+"%' or starost like '%"+parametar+"%' or tipeksponata.nazivTipaEksponata like '%"+parametar+"%' or stalnapostavka.nazivPostavke like '%"+parametar+"%'";
    }

    @Override
    public String getQueryForInsert() {
        return "Insert into eksponat(nazivEksponata,visina,tezina,starost,tipEksponataId,stalnaPostavkaId) values('"+nazivEksponata+"',"+visina+","+tezina+",'"+starost+"',"+tipEksponata.getTipId()+","+stalnaPostavka.getPostavkaId()+")";
    }

    @Override
    public String getQueryForUpdate() {
        return "Update eksponat set nazivEksponata='"+nazivEksponata+"', visina="+visina+", tezina="+tezina+", starost='"+starost+"', tipEksponataId="+tipEksponata.getTipId()+", stalnaPostavkaId="+stalnaPostavka.getPostavkaId()+" where eksponatId="+eksponatId;
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
        this.eksponatId=id;
    }
    
    
    
    
}