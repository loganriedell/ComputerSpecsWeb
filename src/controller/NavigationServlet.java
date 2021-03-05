package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CPU;
import model.Computer;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String whatDo = request.getParameter("action");
		Modifier mod = new Modifier();
		String gpu = request.getParameter("gpu");
		String os = request.getParameter("os");
		//Persists the new Computer if cpu was picked from list
		if(whatDo.equals("Add Computer"))
		{
			try
			{
				int cpuID = Integer.parseInt(request.getParameter("id"));
				Computer com = new Computer(gpu, os);
				mod.insertComputer(com);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Didn't choose cpu");
			}
		}
		// Makes new cpu persist it finds that cpu and assigns the id to cpuID in Computer object then Persists the Computer Object
		else if (whatDo.equals("Add CPU"))
		{
			CPUHelper help = new CPUHelper();
			int pins = Integer.parseInt(request.getParameter("pins"));
			int cores = Integer.parseInt(request.getParameter("cores"));
			String name = request.getParameter("cpuName");
			CPU cpu = new CPU(cores, pins, name);
			help.insertCPU(cpu);
			CPU persistedCPU = help.searchByName(name);
			int id = persistedCPU.getId();
			Computer com = new Computer(gpu, os);
			mod.insertComputer(com);
		}
		//Redirects to add cpu if user hasn't selected one and need to make a new one
		else if (whatDo.equals("Add New CPU"))
		{
			request.setAttribute("os", os);
			request.setAttribute("gpu", gpu);
			path = "/add-cpu.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
