
public class MarketingManager extends Employee{
	
	private double bonus;
	private int sales;
	
	MarketingManager() {}
	
	MarketingManager(String fname, String lname, String location, int social) {
		firstName = fname;
		lastName = lname;
		job = "Marketing Manager";
		address = location;
		monthPay = annualPay = taxPay = 0;
		ssn = social;
		sales = 0;
		bonus = 0;
	}
	
	void addSales(int n) {
		sales += n;
	}
	
	int getSales() {
		return sales;
	}
	
	double getBonus() {
		return bonus;
	}
	
	void managerBonus() {
		
		if(bonus == 5_000 || monthPay==0) {
			return;
		}
		
		bonus += 5_000;
		monthPay += (monthPay * 0.01);
		annualPay = (monthPay * 12) + bonus;
		
	}
	
	
}
