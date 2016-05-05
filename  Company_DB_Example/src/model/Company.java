/**
 * 
 */
package model;

/**
 * @author ViVol
 *
 */
public class Company {

	private int companyID;
	private String main_company;
	private String sub_company;
	private int earnings;

	/*
	 * default constructor
	 */
	public Company() {
		this.companyID = 1;
		this.main_company = "No Main Company";
		this.sub_company = "No Sub Company";
		this.earnings = 0;
	}

	/**
	 * @param companyID
	 * @param main_company
	 * @param sub_company
	 * @param earnings
	 */
	public Company(int companyID, String main_company, String sub_company, int earnings) {
		this.companyID = companyID;
		this.main_company = main_company;
		this.sub_company = sub_company;
		this.earnings = earnings;
	}
	
	
	/**
	 * @return the companyID
	 */
	public int getCompanyID() {
		return companyID;
	}

	/**
	 * @param companyID
	 *            the companyID to set
	 */
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	/**
	 * @return the main_company
	 */
	public String getMain_company() {
		return main_company;
	}

	/**
	 * @param main_company
	 *            the title to set
	 */
	public void setMain_company(String main_company) {
		this.main_company = main_company;
	}

	/**
	 * @return the sub_company
	 */
	public String getSub_company() {
		return sub_company;
	}

	/**
	 * @param sub_company
	 *            the author to set
	 */
	public void setSub_company(String sub_company) {
		this.sub_company = sub_company;
	}

	/**
	 * @return the pages
	 */
	public int getEarnings() {
		return earnings;
	}

	/**
	 * @param earnings
	 *            the pages to set
	 */
	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}
	
	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", title=" + main_company + ", author=" + sub_company + ", pages=" + earnings + "]";
	}

}
