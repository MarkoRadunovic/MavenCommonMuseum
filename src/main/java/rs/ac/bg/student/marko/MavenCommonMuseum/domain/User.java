package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class User extends DomainObject{
    
    private long userId;
    private String username;
    private String password;
    private String ime;
    private String prezime;

    public User() {
    }

    public User(long userId, String username, String password, String ime, String prezime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        final User other = (User) obj;
        if (this.userId != other.userId) {
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
        return "Select * from user";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new LinkedList<>();
        while(rs.next()){
            long userId = rs.getLong("userId");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            User user = new User(userId, username, password, ime, prezime);
            list.add(user);
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