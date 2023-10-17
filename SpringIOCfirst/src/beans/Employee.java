package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Employee {
	private int empId;
	private String empName;
	private Address address;
	private BankAcount account;

	public Employee() {
	}

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(Address address) {
		super();
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", account=" + account
				+ "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public BankAcount getAccount() {
		return account;
	}

	public void setAccount(BankAcount account) {
		this.account = account;
	}

}
