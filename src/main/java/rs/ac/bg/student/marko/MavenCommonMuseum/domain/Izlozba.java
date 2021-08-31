package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa koja nasledjuje apstraktnu klasu DomainObject i predstavlja izlozbu.
 * @author Marko Radunovic
 * @version 0.1
 */
public class Izlozba extends DomainObject{
   
	/**
	 * id izlozbe kao long
	 */
	private long izlozbaId;
    
	/**
	 * naziv izlozbe kao String
	 */
	private String nazivIzlozbe;
    
	/**
	 * datum pocetka izlozbe kao Date
	 */
	private Date datumPocetka;
    
	/**
	 * datum zavrsetka izlobe kao Date
	 */
	private Date datumZavrsetka;
    
	/**
	 * broj eksponata izlozbe kao int
	 */
	private int brojEksponata;
    
	/**
	 * ocena izlozbe kao double
	 */
	private double ocenaIzlozbe;
    
	/**
	 * kustos izlozbe kao instanca klase Kustos
	 */
	private Kustos kustos;
    
	/**
	 * lista ocena eksponata izlozbe kao List
	 */
	private List<OcenaEksponata> list;

    /**
     * Konstruktor koji inicijalizuje objekat klase Izlozba i nista vise
     */
	public Izlozba() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat klase Izlozba i postavlja vrednosti za sve atribute.
     * @param izlozbaId id izlozbe kao long
     * @param nazivIzlozbe naziv izlozbe kao String
     * @param datumPocetka datum pocetka izlozbe kao Date
     * @param datumZavrsetka datum zavrsetka izlozbe kao Date
     * @param brojEksponata broj eksponata izlozbe kao int
     * @param ocena ocena izlozbe kao double
     * @param kustos kustos izlozbe kao instanca klase Kustos
     * @param list lista ocena eksponata izlozbe kao List
     */
	public Izlozba(long izlozbaId, String nazivIzlozbe, Date datumPocetka, Date datumZavrsetka, int brojEksponata, double ocena, Kustos kustos, List<OcenaEksponata> list) {
        this.izlozbaId = izlozbaId;
        this.nazivIzlozbe = nazivIzlozbe;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.brojEksponata = brojEksponata;
        this.ocenaIzlozbe = ocena;
        this.kustos = kustos;
        this.list = list;
    }

	/**
	 * Vraca id izlozbe
	 * @return id izlozbe kao long
	 */
    public long getIzlozbaId() {
        return izlozbaId;
    }

    /**
     * Postavlja id izlozbe na novu vrednost
     * @param izlozbaId id izlozbe kao long
     */
    public void setIzlozbaId(long izlozbaId) {
        this.izlozbaId = izlozbaId;
    }

    /**
     * Vraca naziv izlozbe
     * @return naziv izlozbe kao String
     */
    public String getNazivIzlozbe() {
        return nazivIzlozbe;
    }

    /**
     * Postavlja naziv izlozbe na novu vrednost
     * @param nazivIzlozbe naziv izlozbe kao String
     */
    public void setNazivIzlozbe(String nazivIzlozbe) {
        this.nazivIzlozbe = nazivIzlozbe;
    }

    /**
     * Vraca datum pocetka izlozbe
     * @return datum pocetka kao Date
     */
    public Date getDatumPocetka() {
        return datumPocetka;
    }

    /**
     * Postavlja datum pocetka izlozbe na novu vrednost
     * @param datumPocetka datum pocetka kao Date
     */
    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    /**
     * Vraca datum zavrsetka izlozbe
     * @return datum zavrsetka kao Date
     */
    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    /**
     * Postavlja datum zavrsetka izlozbe na novu vrednost
     * @param datumZavrsetka datum zavrsetka kao Date
     */
    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    /**
     * Vraca broj eksponata u izlozbi
     * @return broj eksponata kao int
     */
    public int getBrojEksponata() {
        return brojEksponata;
    }

    /**
     * Postavlja broj eksponata u izlozbi na novu vrednost
     * @param brojEksponata broj eksponata kao int
     */
    public void setBrojEksponata(int brojEksponata) {
        this.brojEksponata = brojEksponata;
    }

    /**
     * Vraca ocenu izlozbe
     * @return ocena izlozbe kao double
     */
    public double getOcenaIzlozbe() {
        return ocenaIzlozbe;
    }

    /**
     * Postavlja ocenu izlozbe na novu vrednost
     * @param ocenaIzlozbe ocena izlozbe kao double
     */
    public void setOcenaIzlozbe(double ocenaIzlozbe) {
        this.ocenaIzlozbe = ocenaIzlozbe;
    }

    /**
     * Vraca kustosa izlozbe
     * @return kustos izlozbe kao instanca klase Kustos
     */
    public Kustos getKustos() {
        return kustos;
    }

    /**
     * Postavlja kustosa izlozbe na novu vrednost
     * @param kustos kustos izlozbe kao instanca klase Kustos
     */
    public void setKustos(Kustos kustos) {
        this.kustos = kustos;
    }

    /**
     * Vraca listu svih ocena eksponata na izlozbi
     * @return lista ocena eksponata na izlozbi kao List
     */
    public List<OcenaEksponata> getList() {
        return list;
    }

    /**
     * Postavlja listu svih ocena eksponata na novu vrednost
     * @param list lista ocena eksponata kao List
     */
    public void setList(List<OcenaEksponata> list) {
        this.list = list;
    }


    /**
     * Poredi dve izlozbe prema identifikacionom broju i proverava da li su iste. 
     * Ako jesu vraca true, a ako nisu vraca false.
     *
     * @return <ul>
     * 			<li>true - Ako su oba objekta klase Izlozba i imaju isti izlozbaId </li>
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
        final Izlozba other = (Izlozba) obj;
        if (this.izlozbaId != other.izlozbaId) {
            return false;
        }
        return true;
    }

    /**
     * Vraca naziv izlozbe kao String
     */
    @Override
    public String toString() {
        return nazivIzlozbe;
    }

    @Override
    public String getQueryForAll() {
        return "Select * from izlozba inner join kustos on izlozba.kustosId = kustos.kustosId inner join ocenaeksponata on izlozba.izlozbaId= ocenaeksponata.izlozbaId inner join eksponat on eksponat.eksponatId=ocenaeksponata.eksponatId inner join tipeksponata on eksponat.tipEksponataId = tipeksponata.tipId inner join stalnapostavka on eksponat.stalnaPostavkaId = stalnapostavka.postavkaId";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list =new LinkedList<>();
        while(rs.next()){
            
            long kustosId = rs.getLong("kustosId");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            int godine = rs.getInt("godine");
            String adresa = rs.getString("adresa");
            
            Kustos kustos = new Kustos(kustosId, ime, prezime, godine, adresa, null);
            
            long eksponatId = rs.getLong("eksponatId");
            String nazivEksponata = rs.getString("nazivEksponata");
            double visina = rs.getDouble("visina");
            double tezina = rs.getDouble("tezina");
            String starost = rs.getString("starost");
            
            long tipId = rs.getLong("tipId");
            String nazivTipaEksponata = rs.getString("nazivTipaEksponata");
            TipEksponata tipEksponata = new TipEksponata(tipId, nazivTipaEksponata);
            
            long postavkaId = rs.getLong("postavkaId");
            String nazivPostavke = rs.getString("nazivPostavke");
            Date datumFormiranja = new Date(rs.getDate("datumFormiranja").getTime());

            StalnaPostavka stalnaPostavka = new StalnaPostavka(postavkaId, nazivPostavke, datumFormiranja, 0, null);
            
            Eksponat eksponat = new Eksponat(eksponatId, nazivEksponata, visina, tezina, starost, tipEksponata, stalnaPostavka);
            
            long izlozbaId = rs.getLong("izlozbaId");
            String nazivIzlozbe =rs.getString("nazivIzlozbe");
            Date datumPocetka = new Date(rs.getDate("datumPocetka").getTime());
            Date datumZavrsetka = new Date(rs.getDate("datumZavrsetka").getTime());
            int brojEksponata= rs.getInt("brojEksponataIzlozbe");
            double ocenaIzlozbe  = rs.getDouble("ocenaIzlozbe");
            
            int ocena = rs.getInt("ocena");
            
            Izlozba izlozba = new Izlozba(izlozbaId, nazivIzlozbe, datumPocetka, datumZavrsetka, brojEksponata, ocenaIzlozbe, kustos, new LinkedList<OcenaEksponata>());
            
            OcenaEksponata ocenaEksponata = new OcenaEksponata(izlozba, eksponat, ocena);
            izlozba.getList().add(ocenaEksponata);
            
            if(list.contains(izlozba)){
                int indexOf = list.indexOf(izlozba);
                Izlozba izlozbaFromList = (Izlozba)list.get(indexOf);
                izlozbaFromList.getList().add(ocenaEksponata);
                ocenaEksponata.setIzlozba(izlozba);
            }else{
                list.add(izlozba);
            }
        }
        rs.close();
        return list;
    }

    @Override
    public String getQueryForSearch(String parametar) {
        return "Select * from izlozba inner join kustos on izlozba.kustosId = kustos.kustosId inner join ocenaeksponata on izlozba.izlozbaId= ocenaeksponata.izlozbaId inner join eksponat on eksponat.eksponatId=ocenaeksponata.eksponatId inner join tipeksponata on eksponat.tipEksponataId = tipeksponata.tipId inner join stalnapostavka on eksponat.stalnaPostavkaId = stalnapostavka.postavkaId where izlozba.nazivIzlozbe like '%"+parametar+"%' or DATE_FORMAT(izlozba.datumPocetka,'%d.%m.%Y') like '%"+parametar+"%' or DATE_FORMAT(izlozba.datumZavrsetka,'%d.%m.%Y') like '%"+parametar+"%' or izlozba.brojEksponataIzlozbe like '%"+parametar+"%' or izlozba.ocenaIzlozbe like '%"+parametar+"%' or CONCAT(kustos.ime,' ', kustos.prezime) like '%"+parametar+"%'";
    }

    @Override
    public String getQueryForInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Insert into izlozba(nazivIzlozbe,datumPocetka,datumZavrsetka,brojEksponataIzlozbe,ocenaIzlozbe,kustosId) values ('"+nazivIzlozbe+"', '"+sdf.format(datumPocetka)+"', '"+sdf.format(datumZavrsetka)+"', "+brojEksponata+", "+ocenaIzlozbe+", "+kustos.getKustosId()+")";
    }

    @Override
    public String getQueryForUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Update izlozba set nazivIzlozbe='"+nazivIzlozbe+"', datumPocetka='"+sdf.format(datumPocetka)+"', datumZavrsetka='"+sdf.format(datumZavrsetka)+"', brojEksponataIzlozbe="+brojEksponata+", ocenaIzlozbe="+ocenaIzlozbe+", kustosId="+kustos.getKustosId()+" where izlozbaId="+izlozbaId;
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
        this.izlozbaId = id;
    }
    
    
}
