
public class Designer extends Employee {
	
	private double bonus;
	private double profit;
	
	Designer(String fname, String lname, String location, int social){
		firstName = fname;
		lastName = lname;
		job = "Designer";
		address = location;
		monthPay = annualPay = taxPay = 0;
		profit = 0;
		ssn = social;
		bonus = 0;
	}
	
	
	// Sets total Profits
	void setPorfit(double n) {
		profit = n;
	}
	
	// Returns Best Product Profits
	double getProfit() {
		return round(profit);
	}
	
	// Returns amount of Bonus
	double getBonus() {
		return bonus;
	}
	
	// Applies Bonus if not already applied 
	void designBonus() {
		 
		if(bonus == 10_000 || monthPay==0) {
			return;
		}
	
		bonus += 10_000;
		annualPay += bonus;
	}
	
	
	
	
}
