

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
	
	void setSSN(int n) {
		ssn = n;
	}
	double getTaxRate() {
		return tax*100;
	}
	
	// set payment for a month
	void setMonthPay(double num) {
		monthPay = num;
		annualPay = num * 12;
	}
	
	// retrieves payment for a month
	double getMonthPay() { 
		return round(monthPay);
	}
		
	// retrieves income for a year
	double getAnnualPay() { 
		return round(annualPay); 
	}
	
	
	// retrieves taxes to be paid
	double getTax() { 
		double tmp = tax*annualPay;
		taxPay = tmp;
		
		return round(tmp); 
	}
		
	double round(double n) {
    	double roundOff = (double) Math.round(n * 100) / 100;
    	return roundOff;
    }
}









