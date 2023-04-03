
public class Tester extends Employee {
	
	private double overtimeHr;
	private double overtimePay;
	
	Tester(String fname, String lname, String location, int social){
		firstName = fname;
		lastName = lname;
		job = "Tester";
		address = location;
		monthPay = annualPay = taxPay = 0;
		ssn = social;
		overtimeHr = 0;
		overtimePay = 0;
	}
	
	// Sets Overtime Hours
	void setOt(double n) {
		overtimeHr = n;
	}
	
	// Returns Overtime Hours
     double getOt() {
		return round(overtimeHr);
	}
	
	// Set payment for overtime work 
	void setOtPay() {
		
		if(overtimePay != 0) {
			annualPay -= overtimePay;
		}
		
		// formula calculates hourly wage based on 40 hour work week 5 days at work each week
		double div = ((monthPay / 4) /5) / 8;
		overtimePay = (div*2) * overtimeHr;
	}
	
	// Return Overtime Pay
	double getOtPay() {
		return round(overtimePay);
	}
	
	// Apply Overtime Pay to Annual Pay
	void applyOt() {
		double tmp = annualPay + overtimePay;
		annualPay = tmp;
	}
	
	
}
