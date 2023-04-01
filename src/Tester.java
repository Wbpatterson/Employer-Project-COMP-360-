
public class Tester extends Employee {
	
	private int overtimeHr;
	private double overtimePay;
	
	Tester() {}
	
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
	
	// Set Overtime Hours
	void setOt(int n) {
		overtimeHr = n;
	}
	
	// Get Overtime Hours
     int getOt() {
		return overtimeHr;
	}
	
	// set payment for overtime work 
	void setOtPay() {
		
		if(overtimePay != 0) {
			annualPay -= overtimePay;
		}
		
		// formula calculates hourly wage based on 40 hour work week 5 days at work each week
		double div = ((getMonthPay() / 4) /5) / 8;
		overtimePay = (div*2) * overtimeHr;
	}
	
	// Get Overtime Pay
	double getOtPay() {
		return overtimePay;
	}
	
	// Apply Overtime Pay to Annual Pay
	void applyOt() {
		double tmp = annualPay + overtimePay;
		annualPay = tmp;
	}
	
	
}
