
public class Designer extends Employee {
	
	private double bonus;
	
	Designer() {}
	
	Designer(String fname, String lname){
		firstName = fname;
		lastName = lname;
		job = "Designer";
		address = "unkown";
		monthPay = annualPay = taxPay = ssn = 0;
		bonus = 0;
	}
	
	double getBonus() {
		return bonus;
	}
	
	void designBonus(boolean b) {
		 
		if(bonus == 10_000) {
			System.out.println("Bonus already applied!");
		}
		else if(b == true) {
			bonus += 10_000;
			annualPay += bonus;
		}
		 
	}
	
	
	
	
}
