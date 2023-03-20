
public class MarketingManager extends Employee{
	
	private double bonus;
	
	MarketingManager() {}
	
	// constructor 
	MarketingManager(String fname, String lname) {
		firstName = fname;
		lastName = lname;
		job = "Marketing Manager";
		address = "unkown";
		monthPay = annualPay = taxPay = ssn = 0;
		bonus = 0;
	}
	
	void managerBonus(boolean b) {
		
		if(b == true) {
			bonus += 5_000;
			monthPay += (monthPay * 0.01);
		}
		else if(bonus == 5_000) {
			System.out.println("Bonus already applied");
		}
	}
	
	
}
