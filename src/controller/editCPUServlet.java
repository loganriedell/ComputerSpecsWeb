package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CPU;

/**
 * Servlet implementation class editCPUServlet
 */
@WebServlet("/editCPUServlet")
public class editCPUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCPUServlet() {
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
		CPUHelper help = new CPUHelper();
		String whatDo = request.getParameter("doThis");
		
		if (whatDo.equals("delete"))
		{
			try {
				int id = Integer.parseInt(request.getParameter("cpu_id"));
				help.deleteCPU(id);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Did not pick cpu");
			}		
		}
		getServletContext().getRequestDispatcher("/viewAllCPUsServlet").forward(request, response);
	}

}
