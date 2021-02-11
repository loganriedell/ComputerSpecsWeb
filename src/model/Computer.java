/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** *@author logie - Logan Riedell
* CIS175 - Spring 2021
* Feb 11, 2021
*/
@Entity
@Table(name = "computerspecs")
public class Computer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CPU")
	private String cpu;
	@Column(name="GPU")
	private String gpu;
	@Column(name="OS")
	private String operatingSystem;
	
	public Computer()
	{
		super();
	}
	public Computer(String cpu, String gpu, String operatingSystem)
	{
		super();
		this.cpu = cpu;
		this.gpu = gpu;
		this.operatingSystem = operatingSystem;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
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
		return this.id;
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + " CPU: " + this.getCpu() + " GPU: " + this.getGpu() + " OS: " + this.getOperatingSystem();
	}
	
}
