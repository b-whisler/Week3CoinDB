package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class SelectionServlet
 */
@WebServlet("/selectionServlet")
public class SelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoinHelper ch = new CoinHelper();
		String action = request.getParameter("userSelection");
		String path = "/viewCollectionServlet"; // Default path
		try {
			if (action.equals("Delete")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Coin coinToRemove = ch.getCoinById(selectId);
					ch.removeCoin(coinToRemove); 
			} else if (action.equals("Edit")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Coin coinToEdit = ch.getCoinById(selectId);
					request.setAttribute("coinToEdit", coinToEdit);
					path = "/edit-coin.jsp";	
			} else if (action.equals("Add")) {
			path = "/index.html";
			}
		} catch (NumberFormatException e) {
			//Invalid ID selection, simply returns the user back to the list
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
