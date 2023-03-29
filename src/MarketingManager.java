
public class MarketingManager extends Employee{
	
	private double bonus;
	
	MarketingManager() {}
	
	MarketingManager(String fname, String lname) {
		firstName = fname;
		lastName = lname;
		job = "Marketing Manager";
		address = "unkown";
		monthPay = annualPay = taxPay = ssn = 0;
		bonus = 0;
	}

	double getBonus() {
		return bonus;
	}
	
	void managerBonus(boolean b) {
		
		if(bonus == 5_000) {
			System.out.println("Bonus already applied");
		}
		else if(b == true) {
			bonus += 5_000;
			monthPay += (monthPay * 0.01);
		}
	}
	
	
}
