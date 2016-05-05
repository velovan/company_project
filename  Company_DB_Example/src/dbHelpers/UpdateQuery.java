/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Company;;

/**
 * @author ViVol
 *
 */
public class UpdateQuery {

	private Connection connection;

	public UpdateQuery(String dbName, String uname, String pwd) {

		String url = "jdbc:mysql://localhost:3306/" + dbName;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doUpdate(Company company){
		String query = "update company set main_company=?, sub_company=?, earnings=? where companyID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, company.getMain_company());
			ps.setString(2, company.getSub_company());
			ps.setInt(3, company.getEarnings());
			ps.setInt(4, company.getCompanyID());			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
