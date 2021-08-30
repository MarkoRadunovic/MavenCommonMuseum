package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DomainObject implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract String getQueryForAll();
    public abstract List<DomainObject> getList(ResultSet rs) throws SQLException;
    public abstract String getQueryForSearch(String parametar);
    public abstract String getQueryForInsert();
    public abstract String getQueryForUpdate();
    public abstract String getQueryForDelete();
    public abstract boolean isAutoIncrement();
    public abstract void setId(long id);
}
