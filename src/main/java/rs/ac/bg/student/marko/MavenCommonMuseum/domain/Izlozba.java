package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class Izlozba extends DomainObject{
    private long izlozbaId;
    private String nazivIzlozbe;
    private Date datumPocetka;
    private Date datumZavrsetka;
    private int brojEksponata;
    private double ocenaIzlozbe;
    private Kustos kustos;
    private List<OcenaEksponata> list;

    public Izlozba() {
    }

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

    public long getIzlozbaId() {
        return izlozbaId;
    }

    public void setIzlozbaId(long izlozbaId) {
        this.izlozbaId = izlozbaId;
    }

    public String getNazivIzlozbe() {
        return nazivIzlozbe;
    }

    public void setNazivIzlozbe(String nazivIzlozbe) {
        this.nazivIzlozbe = nazivIzlozbe;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public int getBrojEksponata() {
        return brojEksponata;
    }

    public void setBrojEksponata(int brojEksponata) {
        this.brojEksponata = brojEksponata;
    }

    public double getOcenaIzlozbe() {
        return ocenaIzlozbe;
    }

    public void setOcenaIzlozbe(double ocenaIzlozbe) {
        this.ocenaIzlozbe = ocenaIzlozbe;
    }

    public Kustos getKustos() {
        return kustos;
    }

    public void setKustos(Kustos kustos) {
        this.kustos = kustos;
    }

    public List<OcenaEksponata> getList() {
        return list;
    }

    public void setList(List<OcenaEksponata> list) {
        this.list = list;
    }


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
