/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Company;

/**
 * @author ViVol
 *
 */
public class ReadRecord{

	private Connection connection;
	private ResultSet results;
	
	private Company company = new Company();
	private int companyID;
	
	public ReadRecord(String dbName, String uname, String pwd, int companyID){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.companyID = companyID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRead(){
		String query = "select * from company where companyID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.companyID);
			this.results = ps.executeQuery();
			this.results.next();
			
			company.setCompanyID(this.results.getInt(1));
			company.setSub_company(this.results.getString("sub_company"));
			company.setMain_company(this.results.getString("main_company"));
			company.setEarnings(this.results.getInt("earnings"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Company getCompany() {
		return this.company;
	}
	
}
