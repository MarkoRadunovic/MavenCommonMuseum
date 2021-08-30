package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class StalnaPostavka extends DomainObject {

    private long postavkaId;
    private String nazivPostavke;
    private Date datumFormiranja;
    private int brojEksponata;
    private Kustos kustos;

    public StalnaPostavka() {
    }

    public StalnaPostavka(long postavkaId, String nazivPostavke, Date datumFormiranja, int brojEksponata, Kustos kustos) {
        this.postavkaId = postavkaId;
        this.nazivPostavke = nazivPostavke;
        this.datumFormiranja = datumFormiranja;
        this.brojEksponata = brojEksponata;
        this.kustos = kustos;
    }

    public long getPostavkaId() {
        return postavkaId;
    }

    public void setPostavkaId(long postavkaId) {
        this.postavkaId = postavkaId;
    }

    public String getNazivPostavke() {
        return nazivPostavke;
    }

    public void setNazivPostavke(String nazivPostavke) {
        this.nazivPostavke = nazivPostavke;
    }

    public Date getDatumFormiranja() {
        return datumFormiranja;
    }

    public void setDatumFormiranja(Date datumFormiranja) {
        this.datumFormiranja = datumFormiranja;
    }

    public int getBrojEksponata() {
        return brojEksponata;
    }

    public void setBrojEksponata(int brojEksponata) {
        this.brojEksponata = brojEksponata;
    }

    public Kustos getKustos() {
        return kustos;
    }

    public void setKustos(Kustos kustos) {
        this.kustos = kustos;
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
        final StalnaPostavka other = (StalnaPostavka) obj;
        if (this.postavkaId != other.postavkaId) {
            return false;
        }
        return true;
    }

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
