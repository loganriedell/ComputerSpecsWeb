/**
 * 
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** *@author logie - Logan Riedell
* CIS175 - Spring 2021
* Feb 11, 2021
*/
@Entity
@Table(name = "computers")
public class Computer{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COM_ID")
	private int com_id;
	@Column(name="GPU")
	private String gpu;
	@Column(name="OS")
	private String operatingSystem;
	//Relationships
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="CPU_ID")
	private CPU cpu;
	
	
	public Computer()
	{
		super();
	}
	
	public Computer(String gpu, String operatingSystem)
	{
		super();
		this.gpu = gpu;
		this.operatingSystem = operatingSystem;
	}
	//public Computer(String gpu, String operatingSystem)
	{
		/*super();
		this.gpu = gpu;
		this.operatingSystem = operatingSystem;*/
	}

	public CPU getCpu() {
		return this.cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public int getId()
	{
		return this.com_id;
	}
	

	@Override
	public String toString() {
		return "ID: " + this.getId() + " GPU: " + this.getGpu() + " OS: " + this.getOperatingSystem();
	}
	
}
