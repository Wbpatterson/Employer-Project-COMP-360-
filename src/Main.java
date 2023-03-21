
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public HashMap<String, Employee> employees = new HashMap<String, Employee>();
	String currEmployee;
	
	JFrame frame = new JFrame("Employee Roster");
	JPanel panelL = new JPanel(new FlowLayout());
	JPanel panelR = new JPanel(new FlowLayout());
	JTextArea textArea = new JTextArea();
	JComboBox comboBox;
	
	JTextField textField = new JTextField();
	
	JButton tester = new JButton("add Tester");
	JButton designer = new JButton("add Designer");
	JButton manager = new JButton("add Manager");
	
	JButton getfName = new JButton("get First Name");
	JButton getlName = new JButton("get Last Name");
	JButton setMonth = new JButton("Set Monthly Pay");
	JButton getMonth = new JButton("Get Monthly Pay");
	JButton getAnnual = new JButton("Get Annual Pay");
	JButton setAddress = new JButton("Set Address");
	JButton getAddress = new JButton("Get Address");
	JButton setOvertimeHr = new JButton("Set Overtime Hr");
	JButton getOvertimeHr = new JButton("Get Overtime Hr");
	JButton getOvertimePay = new JButton("Get Overtime Pay");
	JButton designBonus = new JButton("Designer Bonus");
	JButton managerBonus = new JButton("Manager Bonus");
	JButton clear = new JButton("clear");
	
	
	Main(){
		
		textArea.setBounds(450, 30, 400, 300);
		
		tester.setBounds(450, 425, 125, 50);
		tester.setFocusable(false);
		tester.addActionListener(this);
	
		clear.setBounds(450, 350, 100, 50);
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(100, 30, 100, 30);
	
		
		frame.add(comboBox);
		frame.add(tester);
		frame.add(clear);
		frame.add(textArea);
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Tester person1 = new Tester("John", "Doe");
		Designer person2 = new Designer("Bruce", "Wayne");
		MarketingManager person3 = new MarketingManager("Clark", "Kent");
		
		/*  Tester Test Cases:
 		person1.setmonthPay(2000);
		person1.calcAnuualPay();
		person1.setOt(5);
		person1.setOtPay();
		//System.out.println(person1.getAnnualPay() + person1.getOtPay());
		person1.printinfo();
		*/
		
		/*
		person2.setmonthPay(4000);
		person2.calcAnnualPay();
		person2.calcTax();
		person2.designBonus(true);
		person2.designBonus(true);
		person2.printinfo();
		*/
		
		new Main();

		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clear) {
			textArea.setText("");
		}
		
		else if(e.getSource()==tester) {
			Tester p1 = new Tester("Joe", "Smoe");
			employees.put("Joe", p1 );
			textArea.append("\nadded employee");
			comboBox.addItem("Joe Smoe");
			currEmployee = "Joe Smoe";
		}
		
	}

}
