package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;
import model.Country;

/**
 * Servlet implementation class CountrySelectionServlet
 */
@WebServlet("/countrySelectionServlet")
public class CountrySelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountrySelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CountryHelper cnh = new CountryHelper();
		String action = request.getParameter("userSelection");
		String path = "/viewCountriesServlet"; // Default path
		try {
			if (action.equals("Delete")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Country countryToRemove = cnh.getCountryById(selectId);
					cnh.removeCountry(countryToRemove);
			} else if (action.equals("Edit")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Country countryToEdit = cnh.getCountryById(selectId);
					request.setAttribute("countryToEdit", countryToEdit);
					path = "/edit-country.jsp";	
			} else if (action.equals("Add")) {
			path = "/add-country.html";
			}
		} catch (NumberFormatException e) {
			//Invalid ID selection, simply returns the user back to the list
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
