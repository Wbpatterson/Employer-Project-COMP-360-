
public class Designer extends Employee {
	
	private double bonus;
	private double profit;
	
	Designer() {}
	
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
	
	void setPorfit(double n) {
		profit = n;
	}
	
	double getProfit() {
		return profit;
	}
	
	double getBonus() {
		return bonus;
	}
	
	void designBonus() {
		 
		if(bonus == 10_000 || monthPay==0) {
			return;
		}
	
		bonus += 10_000;
		annualPay += bonus;
	}
	
	
	
	
}
