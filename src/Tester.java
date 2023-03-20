
public class Tester extends Employee {
	
	private int overtimeHr;
	private double overtimePay;
	
	Tester() {}
	
	// constructor
	Tester(String fname, String lname){
		firstName = fname;
		lastName = lname;
		job = "Tester";
		address = "unkown";
		monthPay = annualPay = taxPay = ssn = 0;
		overtimeHr = 0;
		overtimePay = 0;
	}
	
	void setOt(int n) {
		overtimeHr = n;
	}
	
	int getOt() {
		return overtimeHr;
	}
	
	// set payment for overtime work 
	void setOtPay() {
		
		// formula calculates hourly wage 
		double div = ((getMonthPay() / 4) /5) / 8;
		overtimePay = (div*2) * getOt();
	}
	
	double getOtPay() {
		return overtimePay;
	}
	
	
	
}
