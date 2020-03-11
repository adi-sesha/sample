package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
@GenericGenerator(name = "employeeGenerator", strategy = "increment")
//@AllArgsConstructor
//@XmlRootElement(name = "employee")
public class Employee implements Serializable {

	//private static final long serialVersionUID = 1L;

	//private int empid;
	@Id
	@GeneratedValue(generator = "employeeGenerator")
	@Column(name = "id")
	private int id;

	@Column(name = "uniqueid")
	private String uniqueid;
	
	@Column(name = "name")
	private String name;
	
	public String getEname() {
		return name;
	}

	public void setEname(String ename) {
		this.name = ename;
	}
	//private String ename;
	/*private double sal;
	private List<Address> addresslist;
	private List<Department> deptlist;*/

	/*public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public List<Address> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}

	public List<Department> getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List<Department> deptlist) {
		this.deptlist = deptlist;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", sal=" + sal + ", addresslist=" + addresslist
				+ ", deptlist=" + deptlist + "]";
	}*/

}
