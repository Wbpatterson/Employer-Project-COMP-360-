
public class Main {

	public static void main(String[] args) {
		Tester person1 = new Tester("John", "Doe");
		Designer person2 = new Designer("Bruce", "Wayne");
		MarketingManager person3 = new MarketingManager("Clark", "Kent");
		
		person1.setmonthPay(2000);
		person1.calcAnuualPay();
		person1.setOt(5);
		person1.setOtPay();
		
	
		//System.out.println(person1.getAnnualPay() + person1.getOtPay());
		
		person1.printinfo();
	}

}
