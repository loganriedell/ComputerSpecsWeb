/**
 * 
 */
package Default;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import controller.CPUHelper;
import controller.Modifier;
import model.CPU;
import model.Computer;

/** *@author logie - Logan Riedell
* CIS175 - Spring 2021
* Feb 11, 2021
*/
public class Main {
	static Modifier mod = new Modifier();
	public static void main(String[] args)
	{
		//showMenu();
		CPUHelper help = new CPUHelper();
		CPU cpu = new CPU(16, 478, "AMD blah");
		Computer com = new Computer("GTX Random", "MacOS Ultra Random");
		List<Computer> comList = new ArrayList<Computer>();
		comList.add(com);
		Computer com2 = new Computer("Something stupid", "Windows");
		comList.add(com2);
		cpu.setListOfComputers(comList);
		help.insertCPU(cpu);
		List<CPU> cpus = help.showCPUs();
		
		for(CPU cpuu: cpus)
		{
			System.out.println(cpuu.getListOfComputers());
		}
		
		
	}
	
	public static void showMenu()
	{
		String menu = "Press 1 to add new data \nPress 2 to delete data\nPress 3 to edit" +
			 "\nPress 4 to show all data";
		boolean keepAsking = true;
		while(keepAsking)
		{
			
			int answer = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (answer == 1)
			{
				addComputer();
			}
			else if (answer == 2)
			{
				removeComputer();
			}
			else if(answer == 3)
			{
				edit();
			}
			else if(answer == 4)
			{
				viewAll();
			}
			else
			{
				mod.clean();
				keepAsking = false;
			}
			
		}
	}
	
	public static void addComputer()
	{
		String cpu = JOptionPane.showInputDialog("Please enter the CPU name: ");
		String gpu = JOptionPane.showInputDialog("Please enter the GPU name: ");
		String os = JOptionPane.showInputDialog("Please enter the operating system: ");
		Computer toAdd = new Computer(cpu, gpu, os);
		mod.insertComputer(toAdd);
	}
	public static void removeComputer()
	{
		int index = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Id number of the computer you'd like to delete: "));
		mod.deleteComputer(index);
	}
	public static void edit()
	{
		int indexToEdit = Integer.parseInt(JOptionPane.showInputDialog("What is the ID number of the computer you would like to edit?"));
		Computer found = mod.searchId(indexToEdit);
		String message = "These are the specs: " + found.toString() + "\nEnter the number that represents the information you would like to edit: " +
		"\n1 CPU\n2 GPU\n3 Operating System";
		int spec = Integer.parseInt(JOptionPane.showInputDialog(message));
		String newValue = JOptionPane.showInputDialog("What would you like to replace it with?");
		if(spec == 1)
		{
			found.setCpu(newValue);
		}
		else if(spec == 2)
		{
			found.setGpu(newValue);
		}
		else
		{
			found.setOperatingSystem(newValue);
		}
		mod.updateCom(found);
	}
	
	public static void viewAll()
	{
		String output = "";
		List<Computer> computers = mod.showComputers();
		for(Computer com: computers)
		{
			output += com.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}
	
}
