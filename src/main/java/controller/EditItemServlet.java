package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		
		String name = request.getParameter("name");
		String day = request.getParameter("day");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Task itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setDay(day);
		itemToUpdate.setName(name);
				
		dao.updateItem(itemToUpdate);

		getServletContext().getRequestDispatcher("/viewAllTasksServlet").forward(request, response);


	}

}
