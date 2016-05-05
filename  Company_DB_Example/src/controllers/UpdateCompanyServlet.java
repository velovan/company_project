package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateQuery;
import model.Company;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller whicth starts the actual company update to the database", urlPatterns = { "/updateCompany" })
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Get the form data and set up a Company object
		int companyID = Integer.parseInt(request.getParameter("companyID"));
		String main_company = request.getParameter("main_company");
        String sub_company = request.getParameter("sub_company");
		int earnings = Integer.parseInt(request.getParameter("earnings"));
        
		Company company = new Company();
		company.setCompanyID(companyID);
		company.setSub_company(sub_company);
		company.setMain_company(main_company);
		company.setEarnings(earnings);
		
		//Create on UpdateQuery objects and use it to update the company
		UpdateQuery uq = new UpdateQuery("companydb", "root",  "asazip123");
		uq.doUpdate(company);
		
		//Pass control on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
//		doGet(request, response);
	}

}
