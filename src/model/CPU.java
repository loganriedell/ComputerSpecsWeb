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

@Entity
@Table(name="cpus")
public class CPU {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CPU_ID")
	private int CPU_ID;
	@Column(name="CORES")
	private int cores;
	@Column(name="PINS")
	private int pins;
	@Column(name="NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable
	 (name="cpu_computer_relate", joinColumns={ @JoinColumn(name="CPU_ID", referencedColumnName="CPU_ID") },
	inverseJoinColumns={ @JoinColumn(name="COM_ID", referencedColumnName="COM_ID", unique=true) })
	private List<Computer> listOfComputers;

	public CPU()
	{
		super();
	}
	public CPU(int cores, int pins, String name)
	{
		super();
		this.cores = cores;
		this.pins = pins;
		this.name = name;
		
	}
	public int getId() {
		return CPU_ID;
	}
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
	}
	public int getPins() {
		return pins;
	}
	public void setPins(int pins) {
		this.pins = pins;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Computer> getListOfComputers() {
		return listOfComputers;
	}

	public void setListOfComputers(List<Computer> listOfComputers) {
		this.listOfComputers = listOfComputers;
	}

	@Override
	public String toString() {
		return "CPU [id=" + CPU_ID + ", cores=" + cores + ", pins=" + pins + ", name=" + name + ", listOfComputers="
				+ listOfComputers + "]";
	}

}
