
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
import javax.swing.plaf.FontUIResource;

import java.util.Arrays;
import java.util.HashMap;

public class Main implements ActionListener {
	
	//private static final long serialVersionUID = 1L;

	public HashMap<String, Employee> employees = new HashMap<String, Employee>();
	String currEmployee = "";
	
	JFrame frame = new JFrame("Employee Roster");
	JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
	
	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea); 
	JComboBox<String> comboBox = new JComboBox<String>();;
	
	JButton tester = new JButton("Add Tester");
	JButton designer = new JButton("Add Designer");
	JButton manager = new JButton("Add Manager");
	
	JButton editInfo = new JButton("Edit Info");	
	JButton setMonth = new JButton("Set Monthly Pay");			// button to set/change the Monthly Payment
	JButton setOvertimeHr = new JButton("Set Overtime Hr"); 	// button to set/change Over-time Hour
	JButton clear = new JButton("Clear");                       // button to clear text box
	JButton printInfo = new JButton("Print Info");              // button to print all an employees info 
	JButton setDesignBonus = new JButton("Apply Designer Bonus");
	JButton setManagerBonus = new JButton("Apply Manager Bonus");
	JButton setSSN = new JButton("set Social Security Number");
	
	
	Main(){
		// Panel1 properties
		panel1.setBounds(50, 400, 225, 300);
		panel1.setBackground(Color.black);
		
		// Panel2 properties
		panel2.setBounds(500,475, 225, 225);
		panel2.setBackground(Color.black);
		
		// Panel3 properties
		panel3.setBounds(50,125, 225, 230);
		panel3.setBackground(Color.black);
		
		// Text Box properties -> 450 default
		scroll.setBounds(325, 30, 600, 425);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospace", Font.BOLD, 18));
		textArea.setBackground(Color.LIGHT_GRAY);
	
		
		// Tester Object button properties
		tester.setPreferredSize(new Dimension(200,50));
		tester.setFocusable(false);
		tester.addActionListener(this);
		tester.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Designer Object button properties
		designer.setPreferredSize(new Dimension(200,50));
		designer.setFocusable(false);
		designer.addActionListener(this);
		designer.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Manager Object button properties
		manager.setPreferredSize(new Dimension(200,50));
		manager.setFocusable(false);
		manager.addActionListener(this);
		manager.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Clear button properties 
		clear.setPreferredSize(new Dimension(200,50));
		clear.setFocusable(false);
		clear.addActionListener(this);
		clear.setFont(new Font("Arial", Font.BOLD, 16));
		
		// Print Info button properties
		printInfo.setPreferredSize(new Dimension(200,50));
		printInfo.setFocusable(false);
		printInfo.addActionListener(this);
		printInfo.setFont(new Font("Arial", Font.BOLD, 15));
		
		// set Monthly Payment button
		setMonth.setPreferredSize(new Dimension(200,50));
		setMonth.setFocusable(false);
		setMonth.addActionListener(this);
		setMonth.setFont(new Font("Arial", Font.BOLD, 15));
		
		// set Overtime Hours button (Tester only)
		setOvertimeHr.setPreferredSize(new Dimension(200,50));
		setOvertimeHr.setFocusable(false);
		setOvertimeHr.addActionListener(this);
		setOvertimeHr.setFont(new Font("Arial", Font.BOLD, 15));
		
		// set Bonus button (Designer only)
		setDesignBonus.setPreferredSize(new Dimension(200,50));
		setDesignBonus.setFocusable(false);
		setDesignBonus.addActionListener(this);
		setDesignBonus.setFont(new Font("Arial", Font.BOLD, 15));
		
		// set Bonus button (Marketing Manager only)
		setManagerBonus.setPreferredSize(new Dimension(200,50));
		setManagerBonus.setFocusable(false);
		setManagerBonus.addActionListener(this);
		setManagerBonus.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Edit Info button
		editInfo.setPreferredSize(new Dimension(200,50));
		editInfo.setFocusable(false);
		editInfo.addActionListener(this);
		editInfo.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Drop-down box properties
		comboBox.setBounds(50, 30, 200, 30);
		comboBox.addActionListener(this);
		comboBox.getSelectedIndex();
		
		// Panel additions 
		panel1.add(setMonth);
		panel1.add(setOvertimeHr);
		panel1.add(setDesignBonus);
		panel1.add(setManagerBonus);
		
		// Panel2 additions
		panel2.add(clear);
		panel2.add(printInfo);
		panel2.add(editInfo);
		
		
		// Panel3 additions
		panel3.add(tester);
		panel3.add(designer);
		panel3.add(manager);
		
		// frame additions 
		frame.add(panel3);
		frame.add(panel2);
		frame.add(panel1);
		frame.add(comboBox);
		//frame.add(clear);
		frame.add(scroll);
		
		// frame properties
		frame.getContentPane().setBackground(Color.gray);
		frame.setSize(950, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
		UIManager.put("TextField.font", new FontUIResource(new Font("SansSerif",Font.PLAIN,15)));
	}
	
	Employee createObject(String  job, String fname, String lname, String location, int social) {
		
		switch(job) {
		
		case "Tester":     Tester tmp = new Tester(fname, lname, location, social);
					       return tmp;
		
		case "Designer":   Designer tmp2 = new Designer(fname, lname, location, social);
						   return tmp2;
	
		case "Marketing "
			+ "Manager":   MarketingManager tmp3 = new MarketingManager(fname, lname, location, social);
						   return tmp3;
		}
		
		return null;
	}
	
	void editInfo() { 
		var person = employees.get(currEmployee);
		JTextField firstName = new JTextField(person.getFirstName());
		JTextField lastName = new JTextField(person.getLastName());
		JTextField location = new JTextField(person.getAddress());
		JTextField social = new JTextField(String.valueOf(person.getSSN()));
		
		Object[] fields = {
				"First Name: ",  firstName,
				"Last Name: ", lastName,
				"Address: ",  location,
				"Social Security Number: ", social,
		};
		
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400,300)); 
		int choice = JOptionPane.showConfirmDialog(null, fields, "Create Employee", JOptionPane.OK_CANCEL_OPTION);
		
	
		person.setFirstName(firstName.getText());
		person.setLastName(lastName.getText());
		person.setAddress(location.getText());
		
		if(intcheck(social.getText()) == 0){
			return;
		}
		
		person.setSSN(intcheck(social.getText()));
		
		String fullName = firstName.getText().strip() + " " + lastName.getText().strip();
	       
		comboBox.removeItem(currEmployee);
		employees.remove(currEmployee);
		employees.put(fullName, person);
		comboBox.addItem(fullName);
		//textArea.append("Added " + person.job + " " + fullName + "\n" );
		
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
				"Social Security Number: ", social,
		};
		
		// Creates dimensions for box that ask basic information to construct Employee
		UIManager.put("OptionPane.minimumSize",new Dimension(400,300)); 
		int choice = JOptionPane.showConfirmDialog(null, fields, "Create Employee", JOptionPane.OK_CANCEL_OPTION);
		
		
		if(choice == -1 || choice == 2) { 
			return;
		}
		
		if(firstName.getText().equals("") || lastName.getText().equals("") || location.getText().equals("") || social.getText().equals("")) { 
			textArea.append("Error must enter First Name, Last Name, Address, and Social Security Number for" + job  + "\n");
			return;
		}
		
		int convert = intcheck(social.getText());
		if(convert == 0) { return;}
		
		var tmp = createObject(job, firstName.getText(), lastName.getText(), location.getText(), convert);
		String fullName = firstName.getText().strip() + " " + lastName.getText().strip();
		employees.put(fullName, tmp);
		comboBox.addItem(fullName);
		textArea.append("Added " + job + " " + fullName + "\n" );
		
	}
	
	void basicInfo(Tester person) {
		textArea.append("Overime Hours:  " + person.getOt() + "\n");
		textArea.append("Overtime Pay:  $" + person.getOtPay() + "\n");
	}
	
	void basicInfo(Designer person) {
		textArea.append("Best Product Profit:  $" + person.getProfit() + "\n");
		textArea.append("Design bonus:  $" + person.getBonus() + "\n");
	}
	
    void basicInfo(MarketingManager person) {
    	textArea.append("Total Sales:  " + person.getSales() + "\n");
    	textArea.append("Manager Bonus:  $" + person.getBonus() + "\n");
	}
	
    int intcheck(String n) {
    	
    	if(n == null || n.equals("")) {
    		return 0;
    	}
    	
    	int x = 0;
    	
    	try{
    		x = Integer.parseInt(n);
    		return x;
    	}
    	catch(Exception e) {textArea.append("Canceled: Valid Integer not Entered\n");}
    	
    	return 0;
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
		
		else if(currEmployee == ""){
			textArea.append("No Employee Selected\n");
		}
		
		else if(e.getSource()==editInfo) {
			editInfo();
		}
		// Prints Employee Info 
		else if (e.getSource()==printInfo) {

			var person = employees.get(currEmployee);
			textArea.append("-".repeat(35) + "Employee Info" + "-".repeat(35) + "\n");
			textArea.append("First Name:  "+ person.getFirstName() + "\n");
			textArea.append("Last Name:  "+ person.getLastName() + "\n");
			textArea.append("Address:  "+ person.getAddress( ) + "\n");
			textArea.append("Social Security Number: "+ person.getSSN( ) + "\n");
			textArea.append("Job:  " + person.getJob() + "\n");
			textArea.append("Monthly Payment:  $" + person.getMonthPay() + "\n");
			textArea.append("Gross Annual Payment:  $" + person.getAnnualPay() + "\n");
			textArea.append("Post-Tax Annual Payment:  $" + (person.getAnnualPay() - person.getTax()) + "\n");
			textArea.append("Tax Rate:" + person.getTaxRate() + "%\n");
	
			switch(person.getJob()) {
			
			case "Tester": 			  basicInfo((Tester) person);
						   			  break;
			
			case "Designer": 	      basicInfo((Designer) person);
						     		  break;
						     
			case "Marketing Manager": basicInfo((MarketingManager) person);
									  break;
			}
			
			textArea.append("-".repeat(100) + "\n");
		}
		
		
		else if(e.getSource()==setMonth) {
			
			UIManager.put("OptionPane.minimumSize",new Dimension(200,100)); 
			String tmp = JOptionPane.showInputDialog("Enter Monthly Payment", null);
			
			int monthPayment = intcheck(tmp);
			
			Employee person = employees.get(currEmployee);
			person.setMonthPay(monthPayment);
			person.calcTax();
		}
		
		else if(e.getSource()==setOvertimeHr) {
			
			Employee person = employees.get(currEmployee);
			if(!person.getJob().equals("Tester")) {
				textArea.append("Error only Testers can apply Over-time Hours\n");
				return;
			}
			
			if(person.getMonthPay() == 0) {
				textArea.append("Error Monthly Pay Rate has not been set\n");
				return;
			}
			
			UIManager.put("OptionPane.minimumSize",new Dimension(200,100)); 
			int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter the total Worked Overtime hours")); 
			Tester person2 = (Tester) employees.get(currEmployee);
			person2.setOt(hours);
			person2.setOtPay(); // Applies overtime pay to annual pay 
			person2.applyOt();
			person2.calcTax();
		}
		
		else if(e.getSource()==setDesignBonus) {
			
			var person = employees.get(currEmployee);
			if(!person.getJob().equals("Designer")) {
				textArea.append("Bonus can only be applied to Designer\n");
				return;
			}
			
			UIManager.put("OptionPane.minimumSize",new Dimension(200,100)); 
			String tmp = JOptionPane.showInputDialog("Enter Designer profit", null);
			Designer person2 = (Designer) employees.get(currEmployee);
			
			int check = intcheck(tmp);
			if(check == 0) {return;}
			
			if(person2.getBonus() == 10_000 ) {
				textArea.append("Designer Bonus already Applied\n");
			}
			else if(person2.getMonthPay() == 0) {
				textArea.append("Monthly Pay Rate not Set Up\n");
			}
			else {
				
				if(check > person2.getProfit())
				{
					person2.setPorfit(check);
				}
				
				if(check > 2_000) {
					person2.designBonus();
					textArea.append("$10,000 Bonus Applied!\n");
				}
				else {
					textArea.append("Designer product profit must be greater than $2,000 to recieve bonus\n");
				}
				
			}	
		}
		
		else if(e.getSource()==setManagerBonus) {
			
			var person = employees.get(currEmployee);
			if(!person.getJob().equals("Marketing Manager")) {
				textArea.append("Bonus can only be applied to Marketing Managerr\n");
				return;
			}
			
			MarketingManager person2 = (MarketingManager) employees.get(currEmployee);
			UIManager.put("OptionPane.minimumSize",new Dimension(200,100)); 
			String tmp = JOptionPane.showInputDialog("Enter Manager Sales", null);
			
			int check = intcheck(tmp);
			if(check==0) { return; }
			
			
			person2.addSales(check);
			
			if(person2.getBonus() == 5_000) {
				textArea.append("Marketing Manager Bonus already applied\n");
			}
			else if(person2.getMonthPay() == 0) {
				textArea.append("Monthly Pay Rate not Set Up\n");
			}
			else {
				
				if(person2.getSales() > 1_000) {
					person2.managerBonus();
					textArea.append("Markeitng Manager Bonus applied\n");
				}
				else {
					textArea.append("Marketing Mananger Total Sales must be greater\n");
					textArea.append("than 1,000 to receive bonus\n");
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		new Main();	
	}
}
