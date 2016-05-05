package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadRecord;
import model.Company;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get a company and use the data to fill in a table for updating the record", urlPatterns = { "/update" })
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
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
	    //Get the companyID
		int companyID = Integer.parseInt(request.getParameter("companyID"));
		
		//create ReadRecord class
		ReadRecord rr = new ReadRecord("companydb", "root",  "asazip123", companyID);
		
		//Use ReadRecord to get the company data
		rr.doRead();
		Company company = rr.getCompany();
		
		//Pass Company and control to the updateForm.jsp
		request.setAttribute("company", company);
		
		String url = "/updateForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
