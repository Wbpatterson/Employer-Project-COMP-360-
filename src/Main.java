
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.util.Arrays;
import java.util.HashMap;

public class Main implements ActionListener {
	
	//private static final long serialVersionUID = 1L;

	public HashMap<String, Employee> employees = new HashMap<String, Employee>();
	String currEmployee = "";
	
	JFrame frame = new JFrame("Employee Roster");
	JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea); 
	JComboBox<String> comboBox = new JComboBox<String>();;
	JTextField textField = new JTextField();
	
	JButton tester = new JButton("add Tester");
	JButton designer = new JButton("add Designer");
	JButton manager = new JButton("add Manager");
	
	JButton setMonth = new JButton("Set Monthly Pay");			// button to set/change the Monthly Payment
	JButton setAddress = new JButton("Set Address");			// button to set/change Address
	JButton setOvertimeHr = new JButton("Set Overtime Hr"); 	// button to set/change Over-time Hour
	JButton clear = new JButton("clear");                       // button to clear text box
	JButton printInfo = new JButton("Print Info");              // button to print all an employees info 
	JButton setDesignBonus = new JButton("Designer Bonus");
	JButton setManagerBonus = new JButton("Manager Bonus");
	JButton setSSN = new JButton("set Social Security Number");
	
	
	Main(){
		// panel for setters
		panel1.setBounds(50, 150, 200, 500);
		panel1.setBackground(Color.black);
		//panel1.setBackground(Color.gray);
		
		panel2.setBounds(265,150, 150, 500);
		//panel2.setBackground(Color.gray);
		
		// Text Box properties
		scroll.setBounds(450, 30, 400, 300);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospace", Font.BOLD, 14));
		
		
		textField.setBounds(100, 90, 200, 30);
		textField.setToolTipText("Enter info");
		
		// Tester Object button properties
		tester.setBounds(450, 425, 150, 50);
		tester.setFocusable(false);
		tester.addActionListener(this);
		
		// Designer Object button properties
		designer.setBounds(450, 490, 150, 50);
		designer.setFocusable(false);
		designer.addActionListener(this);
		
		// Manager Object button properties
		manager.setBounds(450, 550, 150, 50);
		manager.setFocusable(false);
		manager.addActionListener(this);
		
		// Clear button properties 
		clear.setBounds(600, 350, 125, 50);
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		// Print Info button properties
		printInfo.setPreferredSize(new Dimension(150,50));
		printInfo.setFocusable(false);
		printInfo.addActionListener(this);
		
		// set Address Button properties
		setAddress.setPreferredSize(new Dimension(150,50));
		setAddress.setFocusable(false);
		setAddress.addActionListener(this);
		
		// set Monthly Payment button
		setMonth.setPreferredSize(new Dimension(150,50));
		setMonth.setFocusable(false);
		setMonth.addActionListener(this);
		
		// set Overtime Hours button (Tester only)
		setOvertimeHr.setPreferredSize(new Dimension(150,50));
		setOvertimeHr.setFocusable(false);
		setOvertimeHr.addActionListener(this);
		
		// set Bonus button (Designer only)
		setDesignBonus.setPreferredSize(new Dimension(150,50));
		setDesignBonus.setFocusable(false);
		setDesignBonus.addActionListener(this);
		
		// set Bonus button (Marketing Manager only)
		setManagerBonus.setPreferredSize(new Dimension(150,50));
		setManagerBonus.setFocusable(false);
		setManagerBonus.addActionListener(this);
		
		// Drop-down box properties
		comboBox.setBounds(100, 30, 200, 30);
		comboBox.addActionListener(this);
		comboBox.getSelectedIndex();
		
		// panel additions 
		panel1.add(setManagerBonus);
		panel1.add(setDesignBonus);
		panel1.add(printInfo);
		panel1.add(setAddress);
		panel1.add(setMonth);
		panel1.add(setOvertimeHr);
		
		// frame additions 
		//frame.add(panel2);
		frame.add(panel1);
		frame.add(comboBox);
		frame.add(manager);
		frame.add(designer);
		frame.add(tester);
		frame.add(clear);
		frame.add(scroll);
		
		// frame properties
		frame.getContentPane().setBackground(Color.gray);
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	Employee createObject(String  job, String fname, String lname, String location, int social) {
		if(job.equals("Tester")) {
			Tester tmp = new Tester(fname, lname, location, social);
			return tmp;
		}
		
		else if(job.equals("Designer") ) {
			Designer tmp = new Designer(fname, lname);
			return tmp;
		}
		
		else if(job.equals("Marketing Manager")) {
			MarketingManager tmp = new MarketingManager(fname, lname);
			return tmp;
		}
		
		return null;
	}
	
	void createEmployee(String job) {
		JTextField firstName = new JTextField();
		JTextField lastName = new JTextField();
		JTextField location = new JTextField();
		JTextField social = new JTextField();
		
		Object[] fields = {
				"First Name: ",  firstName,
				"Last Name: ", lastName,
				"Address: ",  location,
				"Social Securit Number: ", social,
		};
		
		// Creates dimensions for box that ask basic information to construct Employee
		UIManager.put("OptionPane.minimumSize",new Dimension(300,200)); 
		int choice = JOptionPane.showConfirmDialog(null, fields, "Create Employee", JOptionPane.OK_CANCEL_OPTION);
		
		if(choice == -1 || choice == 2) { 
			textArea.append("Canceled\n");
			return;
		}
		
		if(firstName.getText().equals("") || lastName.getText().equals("")) { 
			textArea.append("Error must enter First and Last Name for " + job  + "\n");
			return;
		}	
	
		int convert = Integer.parseInt(social.getText());
		
		var tmp = createObject(job, firstName.getText(), lastName.getText(), location.getText(), convert);
		String fullName = firstName.getText().strip() + " " + lastName.getText().strip();
		employees.put(fullName, tmp);
		comboBox.addItem(fullName);
		textArea.append("Added " + job + " " + fullName + "\n" );
		
	}
	
	void basicInfo(Tester person) {
		textArea.append("Overime Hours: " + person.getOt() + "\n");
		textArea.append("Overtime Pay: $" + person.getOtPay() + "\n");
	}
	
	void basicInfo(Designer person) {
		textArea.append("Design bonus: $" + person.getBonus() + "\n");
	}
	
    void basicInfo(MarketingManager person) {
    	textArea.append("Manager Bonus: $" + person.getBonus() + "\n");
	}
	
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// clears text area text
		if(e.getSource()==clear) {
			textArea.setText("");
		}
		
		// assigns employee to evaluated from drop-down box
		else if(e.getSource()==comboBox){
			currEmployee = (String) comboBox.getSelectedItem();
		}
		
		// Creates and initializes a Tester Object 
		else if(e.getSource()==tester) {
			createEmployee("Tester");
		}
		// Creates and initializes a Designer Object
		else if(e.getSource()==designer) {
			createEmployee("Designer");
		}
		
		// Creates and initializes a MarketingManager Object
		else if(e.getSource()==manager) {
			createEmployee("Marketing Manager");
		}
		
		// Prints Employee Info 
		else if (e.getSource()==printInfo) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}

			var person = employees.get(currEmployee);
			textArea.append(" -------------------------Employee Info----------------------------\n");
			textArea.append("First Name: "+ person.getFirstName() + "\n");
			textArea.append("Last Name: "+ person.getLastName() + "\n");
			textArea.append("Address: "+ person.getAddress( ) + "\n");
			textArea.append("Social Security Number: "+ person.getSSN( ) + "\n");
			textArea.append("Job: " + person.getJob() + "\n");
			textArea.append("Monthly Payment: $" + person.getMonthPay() + "\n");
			textArea.append("Gross Annual Payment: $" + person.getAnnualPay() + "\n");
			textArea.append("Post-Tax Annual Payment: $" + (person.getAnnualPay() - person.getTax()) + "\n");
	
			switch(person.getJob()) {
			
			case "Tester": basicInfo((Tester) person);
						   break;
			
			case "Designer": basicInfo((Designer) person);
						     break;
						     
			case "Marketing Manager": basicInfo((MarketingManager) person);
									  break;
			}
			
			textArea.append(" ------------------------------------------------------------------------\n");
			
		}
		
		
		else if(e.getSource()==setAddress) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}
			
			String address = JOptionPane.showInputDialog("Enter an address");
			Employee person = employees.get(currEmployee);
			person.setAddress(address);
		}
		
		else if(e.getSource()==setMonth) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}
		
			String tmp = JOptionPane.showInputDialog("Enter Monthly Payment", null);
			
			int monthPayment = Integer.parseInt(tmp);
			
			Employee person = employees.get(currEmployee);
			person.setMonthPay(monthPayment);
			person.calcTax();
		}
		
		else if(e.getSource()==setOvertimeHr) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}
			
			Employee person = employees.get(currEmployee);
			if(!person.getJob().equals("Tester")) {
				textArea.append("Error only Testers can apply Over-time Hours\n");
				return;
			}
			
			if(person.getMonthPay() == 0) {
				textArea.append("Error Monthly Pay Rate has not been set\n");
				return;
			}
			
			int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter the total Worked Overtime hours")); 
			Tester person2 = (Tester) employees.get(currEmployee);
			person2.setOt(hours);
			person2.setOtPay(); // Applies overtime pay to annual pay 
			person2.applyOt();
			person2.calcTax();
		}
		
		else if(e.getSource()==setDesignBonus) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}
			
			Employee person = employees.get(currEmployee);
			if(!person.getJob().equals("DesigncomboBoxer")) {
				textArea.append("Bonus can only be applied to Designer\n");
				return;
			}
			
			Designer person2 = (Designer) employees.get(currEmployee);
			
			if(person2.getBonus() == 10_000) {
				textArea.append("Designer Bonus already Applied\n");
			}
			else {
				person2.designBonus();
				textArea.append("$10,000 Bonus Applied!\n");
			}	
		}
		
		else if(e.getSource()==setManagerBonus) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}
			
			Employee person = employees.get(currEmployee);
			if(!person.getJob().equals("Marketing Manager")) {
				textArea.append("Bonus can only be applied to Marketing Managerr\n");
				return;
			}
			
			MarketingManager person2 = (MarketingManager) employees.get(currEmployee);
			
			if(person2.getBonus() == 5_000) {
				textArea.append("Marketing Manager Bonus already applied\n");
			}
			else if(person2.getMonthPay() == 0) {
				textArea.append("");
			}
			else {
				person2.managerBonus();
				textArea.append("Markeitng Manager Bonus applied\n");
			}
		}	
	}
	
	
	public static void main(String[] args) {
		
		new Main();	
	}
}
