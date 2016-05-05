package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Company;;

/**
 * Servlet implementation class AddServlet 
 */                                                                                                                                           
@WebServlet(description = "Controller for adding a new company to the database", urlPatterns = { "/addCompany" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the data
		String main_company = request.getParameter("main_company");
		String sub_company = request.getParameter("sub_company");
		int earnings = Integer.parseInt(request.getParameter("earnings"));
		
		//Set up a company object
		Company company = new Company();
		company.setMain_company(main_company);
		company.setSub_company(sub_company);
		company.setEarnings(earnings);
		
		//Set up on addQuery object
		AddQuery aq = new AddQuery("companydb", "root",  "asazip123");
		
		//Pass the company to addQuery to add to the database
		aq.doAdd(company);
		
		//pass execution control to the ReadServlet
		String url = "/read";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
//		doGet(request, response);
	}

}
