package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Computer;

/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/viewAllComputersServlet";
		String whatDo = request.getParameter("doThis");
		Modifier mod = new Modifier();
		if (whatDo.equals("delete"))
		{
			try
			{
				int id = Integer.parseInt(request.getParameter("id"));
				mod.deleteComputer(id);	
			}
			catch (NumberFormatException e) 
			{
				System.out.println("Forgot to select an computer");
			} 
		}
		else if (whatDo.equals("edit"))
		{
			try 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Computer com = mod.searchId(id);
				request.setAttribute("comToEdit", com);
				path = "/edit-computer.jsp";
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select an computer");
				}
		}
		else if(whatDo.equals("add"))
		{
			path = "/add-computer.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
