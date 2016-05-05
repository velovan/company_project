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
public class ReadQuery {

	private Connection connection;
	private ResultSet results;
	
	public ReadQuery(String addName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + addName;
		
		// set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRead(){
		String query = "select * from company"; 
				
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table = "";
		table += "<table border=1>";
		
		try {
			while(this.results.next()){
				Company comp = new Company();
		        comp.setCompanyID(this.results.getInt("companyID"));		
		        comp.setMain_company(this.results.getString("main_company"));		
		        comp.setSub_company(this.results.getString("sub_company"));		
		        comp.setEarnings(this.results.getInt("earnings"));		
		        
		        table += "<tr>";
		        table += "<td>";		      
		        table += comp.getMain_company();
		        table += "</td>";		        
		        table += "<td>";		      
		        table += comp.getSub_company();
	            table += "</td>";		
	            table += "<td>";		      
	            table += comp.getEarnings();
	             table += "</td>";		
	             table += "<td>";		      
	                 table += "<a href=update?companyID=" + comp.getCompanyID()+ ">update</a> <a href=delete?companyID=" + comp.getCompanyID() + ">delete</a>";
	             table += "</td>";		
		        table += "</tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";		
		return table;
	}
	
	
}
