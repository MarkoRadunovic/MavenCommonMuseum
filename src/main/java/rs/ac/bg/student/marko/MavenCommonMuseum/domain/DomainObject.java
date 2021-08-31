package rs.ac.bg.student.marko.MavenCommonMuseum.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Apstraktna klasa koja predstavlja opsti domenski objekat i nasledjuju je ostale domenske klase.
 * Implementira interfejs Serializable.
 * 
 * @author Marko Radunovic
 * @version 0.1
 */
public abstract class DomainObject implements Serializable{
	
	/**
	 * Vraca String vrednost koja predstavlja select upit u bazi.
	 * 
	 * @return  sql select upit kao String, za bazu klase koja implementira ovu metodu.
	 */
	public abstract String getQueryForAll();
    
	/**
	 * Vraca listu domenskih objekata dobijenu kao rezultat izvrsavanja upita nad bazom.
	 * 
	 * @param rs kao ResultSet koji predstavlja rezultat upita izvrsenog nad bazom.
	 * @return List kao listu domenskih objekata
	 * @throws SQLException
	 */
	public abstract List<DomainObject> getList(ResultSet rs) throws SQLException;
    
	/**
	 * Vraca String vrednost koja predstavlja select upit za bazu podataka definisan prema zadatom uslovom pretrage. 
	 * 
	 * @param parametar String vrednost koja predstavlja parametar pretrage za select upit.
	 * @return sql select upit kao String
	 */
	public abstract String getQueryForSearch(String parametar);
    
	/**
	 * Vraca String vrednost koja predstavlja insert upit za bazu podataka.
	 * 
	 * @return sql insert upit kao String
	 */
	public abstract String getQueryForInsert();
    
	/**
	 * Vraca String vrednost koja predstavlja update upit za bazu podataka.
	 * 
	 * @return sql update upit kao String
	 */
	public abstract String getQueryForUpdate();
    
	/**
	 * Vraca String vrednost koja predstavlja delete upit za bazu podataka.
	 *
	 * @return sql delete upit kao String
	 */
	public abstract String getQueryForDelete();
    
	/**
	 * Vraca boolean vrednost koja predstavlja potvrdu da je u bazi podataka podesen autoincrement za primarni kljuc. 
	 * 
	 * @throws UnsupportedOperationException ako nije jos uvek implementiran
	 * @return boolean koji oznacava da li je u bazi autoincrement za primarni kljuc
	 */
	public abstract boolean isAutoIncrement();
    
	/**
	 * Metoda koja postavlja id domenskog objekta na zadatu vrednost.
	 * 
	 * @param id long vrednost koja predstavlja id objekta
	 */
	public abstract void setId(long id);
}
