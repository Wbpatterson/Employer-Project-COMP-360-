
public class Employee {

	public String firstName, lastName;
	public String address, job;
	public double monthPay, annualPay, taxPay; 
	public int ssn;
	static double tax = 0.0475; // tax rate is 4.75 %
	
	// set payment for a month
	void setmonthPay(int num){
		monthPay = num;
	}
	
	// retrieves payment for a month
	double getMonthPay() {
		return monthPay;
	}
	
	// calculates income earned in a year
	void calcAnuualPay()
	{
		annualPay = getMonthPay() * 12;
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
	double getTax() {
		return taxPay;
	}
	
	void printinfo() {
		System.out.println("Frist Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Job: " + job);
		System.out.println("Address: " + address);
		System.out.println("Monthly Pay: " + monthPay);
		System.out.println("Annual Pay: " + annualPay);
	}
	
}









