package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;

/**
 * Servlet implementation class todoServlet
 */
@WebServlet("/addTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String name = request.getParameter("name");
			String day = request.getParameter("day");
		
			Task li = new Task(name, day);
			ListItemHelper dao = new ListItemHelper();
			dao.insertItem(li);
		
		    getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		    
		
	//	PrintWriter writer = response.getWriter();
	//	writer.println(userInput.toString());
	//	writer.close();
	}

}
