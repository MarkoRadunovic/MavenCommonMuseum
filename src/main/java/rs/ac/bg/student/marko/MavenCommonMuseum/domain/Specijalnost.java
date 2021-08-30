package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Specijalnost extends DomainObject{
    private long specijalnostId;
    private String oblast;

    public Specijalnost() {
    }

    public Specijalnost(long specijalnostId, String oblast) {
        this.specijalnostId = specijalnostId;
        this.oblast = oblast;
    }

    public String getOblast() {
        return oblast;
    }

    public long getSpecijalnostId() {
        return specijalnostId;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public void setSpecijalnostId(int specijalnostId) {
        this.specijalnostId = specijalnostId;
    }

    @Override
    public String toString() {
        return oblast;
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
        final Specijalnost other = (Specijalnost) obj;
        if (this.specijalnostId != other.specijalnostId) {
            return false;
        }
        return true;
    }

    @Override
    public String getQueryForAll() {
        return "select * from specijalnost";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long specijalnostId = rs.getLong("specijalnostId");
            String oblast = rs.getString("oblast");
            Specijalnost specijalnost = new Specijalnost(specijalnostId, oblast);
            
            list.add(specijalnost);
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
