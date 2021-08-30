package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class OcenaEksponata extends DomainObject{
   
    private Izlozba izlozba;
    private Eksponat eksponat;
    private int ocena;

    public OcenaEksponata() {
    }

    public OcenaEksponata(Izlozba izlozba, Eksponat eksponat, int ocena) {
        this.izlozba = izlozba;
        this.eksponat = eksponat;
        this.ocena = ocena;
    }

    public Izlozba getIzlozba() {
        return izlozba;
    }

    public void setIzlozba(Izlozba izlozba) {
        this.izlozba = izlozba;
    }

    public Eksponat getEksponat() {
        return eksponat;
    }

    public void setEksponat(Eksponat eksponat) {
        this.eksponat = eksponat;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
