
public class Employee {

	public String firstName, lastName;
	public String address, job;
	public double monthPay, annualPay, taxPay; 
	public int ssn;
	static double tax = 0.0475; // tax rate is 4.75 %
	
	String getFirstName() {
		return firstName;
	}
	
	String getLastName() {
		return lastName;
	}
	
	// set payment for a month
	void setMonthPay(int num){
		monthPay = num;
	}
	
	// retrieves payment for a month
	double getMonthPay() {
		return monthPay;
	}
	
	// calculates income earned in a year
	void calcAnnualPay()
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
		
}









