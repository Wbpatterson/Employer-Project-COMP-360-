
public class Designer extends Employee {
	
	private double bonus;
	
	Designer() {}
	
	// constructor
	Designer(String fname, String lname){
		firstName = fname;
		lastName = lname;
		job = "Designer";
		address = "unkown";
		monthPay = annualPay = taxPay = ssn = 0;
		bonus = 0;
	}
	
	void designBonus(boolean b) {
		
		if(b == true) {
			bonus += 10_000;
		}
		else if(bonus == 10_000) {
			System.out.println("Bonus already applied");
		}
	}
	
	
	
	
}
