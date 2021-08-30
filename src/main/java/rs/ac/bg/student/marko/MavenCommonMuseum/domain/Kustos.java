package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class Kustos extends DomainObject{
    
    private long kustosId;
    private String ime;
    private String prezime;
    private int godine;
    private String adresa;
    private Specijalnost specijalnost;

    public Kustos() {
    }

    public Kustos(long kustosId, String ime, String prezime, int godine, String adresa, Specijalnost specijalnost) {
        this.kustosId = kustosId;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.adresa = adresa;
        this.specijalnost = specijalnost;
    }

    public long getKustosId() {
        return kustosId;
    }

    public void setKustosId(long kustosId) {
        this.kustosId = kustosId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Specijalnost getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(Specijalnost specijalnost) {
        this.specijalnost = specijalnost;
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
        final Kustos other = (Kustos) obj;
        if (this.kustosId != other.kustosId) {
            return false;
        }
        return true;
    }

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
