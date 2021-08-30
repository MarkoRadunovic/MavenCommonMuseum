package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TipEksponata extends DomainObject{

    private long tipId;
    private String nazivTipaEksponata;

    public TipEksponata() {
    }

    public TipEksponata(long tipId, String nazivTipaEksponata) {
        this.tipId = tipId;
        this.nazivTipaEksponata = nazivTipaEksponata;
    }

    public String getNazivTipaEksponata() {
        return nazivTipaEksponata;
    }

    public long getTipId() {
        return tipId;
    }

    public void setNazivTipaEksponata(String nazivTipaEksponata) {
        this.nazivTipaEksponata = nazivTipaEksponata;
    }

    public void setTipId(long tipId) {
        this.tipId = tipId;
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
        final TipEksponata other = (TipEksponata) obj;
        if (this.tipId != other.tipId) {
            return false;
        }
        return true;
    }

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