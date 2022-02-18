package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class AddCoinServlet
 */
@WebServlet("/addCoinServlet")
public class AddCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		int year = Integer.parseInt(request.getParameter("year"));
		String denom = request.getParameter("denomination");
		Coin nc = new Coin(country, year, denom);
		CoinHelper ch = new CoinHelper();
		ch.addCoin(nc);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
