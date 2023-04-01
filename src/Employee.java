

public class Employee { 
	
	// Class declares variables that will be shared amongst all employee types
	// Declares basic setters and getters for each variable

	public String firstName, lastName;
	public String address, job;
	public double monthPay, annualPay, taxPay; 
	public int ssn;
	static double tax = 0.0475; // tax rate is 4.75 %
	
	void setFirstName(String n) { 
		firstName = n; 
	}
	
	String getFirstName() { 
		return firstName; 
	}
	
	void setLastName(String n) { 
		lastName = n;
	}
	
	String getLastName() { 
		return lastName; 
	}
	
	void setAddress(String location) { 
		address = location;
	}
	
	String getAddress() { 
		return address;
	}
	
	String getJob() { 
		return job; 
	}
	
	int getSSN() {
		return ssn;
	}
	
	// set payment for a month
	void setMonthPay(int num) {
		monthPay = num;
		annualPay = num * 12;
	}
	
	// retrieves payment for a month
	double getMonthPay() { 
		return monthPay;
	}
		
	// retrieves income for a year
	double getAnnualPay() { 
		return annualPay; 
	}
	
	
	// calculates taxes that must be paid
	void calcTax() 
	{
		double tmp = tax*annualPay;
		taxPay = tmp;
	}
	
	// retrieves taxes to be paid
	double getTax() { return taxPay; }
		
}









