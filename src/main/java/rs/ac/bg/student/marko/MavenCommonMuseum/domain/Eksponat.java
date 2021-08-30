package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Eksponat extends DomainObject{
    private long eksponatId;
    private String nazivEksponata;
    private double visina;
    private double tezina;
    private String starost;
    private TipEksponata tipEksponata;
    private StalnaPostavka stalnaPostavka;

    public Eksponat() {
    }

    public Eksponat(long eksponatId, String nazivEksponata, double visina, double tezina, String starost, TipEksponata tipEksponata, StalnaPostavka stalnaPostavka) {
        this.eksponatId = eksponatId;
        this.nazivEksponata = nazivEksponata;
        this.visina = visina;
        this.tezina = tezina;
        this.starost = starost;
        this.tipEksponata = tipEksponata;
        this.stalnaPostavka = stalnaPostavka;
    }

    public long getEksponatId() {
        return eksponatId;
    }

    public void setEksponatId(long eksponatId) {
        this.eksponatId = eksponatId;
    }

    public String getNazivEksponata() {
        return nazivEksponata;
    }

    public void setNazivEksponata(String nazivEksponata) {
        this.nazivEksponata = nazivEksponata;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public String getStarost() {
        return starost;
    }

    public void setStarost(String starost) {
        this.starost = starost;
    }

    public TipEksponata getTipEksponata() {
        return tipEksponata;
    }

    public void setTipEksponata(TipEksponata tipEksponata) {
        this.tipEksponata = tipEksponata;
    }

    public StalnaPostavka getStalnaPostavka() {
        return stalnaPostavka;
    }

    public void setStalnaPostavka(StalnaPostavka stalnaPostavka) {
        this.stalnaPostavka = stalnaPostavka;
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
        final Eksponat other = (Eksponat) obj;
        if (this.eksponatId != other.eksponatId) {
            return false;
        }
        return true;
    }

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