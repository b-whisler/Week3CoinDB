package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class EditCoinServlet
 */
@WebServlet("/editCoinServlet")
public class EditCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoinHelper ch = new CoinHelper();
		String country = request.getParameter("country");
		int year = Integer.parseInt(request.getParameter("year"));
		String denom = request.getParameter("denomination");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Coin coinToUpdate = ch.getCoinById(tempId);
		coinToUpdate.setCountry(country);
		coinToUpdate.setYear(year);
		coinToUpdate.setDenomination(denom);
		ch.editCoin(coinToUpdate);
		getServletContext().getRequestDispatcher("/viewCollectionServlet").forward(request, response);
	}

}
