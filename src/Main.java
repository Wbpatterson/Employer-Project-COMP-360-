
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
import java.util.HashMap;

public class Main implements ActionListener {
	
	//private static final long serialVersionUID = 1L;

	public HashMap<String, Employee> employees = new HashMap<String, Employee>();
	String currEmployee = "";
	
	JFrame frame = new JFrame("Employee Roster");
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea); 
	JComboBox<String> comboBox = new JComboBox<String>();;
	JTextField textField = new JTextField();
	
	JButton tester = new JButton("add Tester");
	JButton designer = new JButton("add Designer");
	JButton manager = new JButton("add Manager");
	
	JButton getfName = new JButton("get First Name"); 			// button to retrieve first name -> delete possibly
	JButton getlName = new JButton("get Last Name");  			// button to retrieve last name  -> delete possibly
	JButton setMonth = new JButton("Set Monthly Pay");			// button to set/change the Monthly Payment
	JButton getMonth = new JButton("Get Monthly Pay");      	// button to retrieve Monthly Payment
	JButton getAnnual = new JButton("Get Annual Pay");      	// button to retrieve Annual Payment
	JButton setAddress = new JButton("Set Address");			// button to set/change Address
	JButton getAddress = new JButton("Get Address");			// button to retrieve Address
	JButton setOvertimeHr = new JButton("Set Overtime Hr"); 	// button to set/change Over-time Hours
	JButton getOvertimeHr = new JButton("Get Overtime Hr"); 	// button to retrieve Over-time Hours
	JButton getOvertimePay = new JButton("Get Overtime Pay");   // button to retrieve Over-time Pay
	JButton designBonus = new JButton("Designer Bonus");        // button to apply a Designer Bonus
	JButton managerBonus = new JButton("Manager Bonus");		// button  to a apply a Marketing Manager Bonus
	JButton clear = new JButton("clear");                       // button to clear text box
	JButton printInfo = new JButton("Print Info");              // button to print all an employees info
	
	
	Main(){
		
		panel.setBounds(50, 150, 150, 500);
		panel.setBackground(Color.gray);
		
		// Text Box properties
		scroll.setBounds(450, 30, 400, 300);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospace", Font.BOLD, 14));
		
		
		textField.setBounds(100, 90, 200, 30);
		textField.setToolTipText("Enter info");
		
		// Tester Object button properties
		tester.setBounds(450, 425, 125, 50);
		tester.setFocusable(false);
		tester.addActionListener(this);
		
		// Designer Object button properties
		designer.setBounds(450, 490, 125, 50);
		designer.setFocusable(false);
		designer.addActionListener(this);
		
		// Manager Object button properties
		manager.setBounds(450, 550, 125, 50);
		manager.setFocusable(false);
		manager.addActionListener(this);
		
		
		// Clear button properties 
		clear.setBounds(600, 350, 100, 50);
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		// Print Info button properties
		printInfo.setPreferredSize(new Dimension(125,50));
		printInfo.setFocusable(false);
		printInfo.addActionListener(this);
		
		// get first name button
		getfName.setPreferredSize(new Dimension(125,50));
		getfName.setFocusable(false);
		getfName.addActionListener(this);
		
		// Drop-down box properties
		comboBox.setBounds(100, 30, 200, 30);
		comboBox.addActionListener(this);
		comboBox.getSelectedIndex();
		
		// panel additions 
		panel.add(printInfo);
		//panel.add(getfName);
		
		// frame additions 
		frame.add(panel);
		frame.add(comboBox);
		frame.add(manager);
		frame.add(designer);
		frame.add(tester);
		frame.add(clear);
		frame.add(scroll);
		
		// frame properties
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	Employee createObject(String  job, String fname, String lname) {
		if(job.equals("Tester")) {
			Tester tmp = new Tester(fname, lname);
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
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		
		Object[] fields = {
				"First Name: ",  field1,
				"Last Name: ", field2
		};
		
		UIManager.put("OptionPane.minimumSize",new Dimension(300,200)); 
		int choice = JOptionPane.showConfirmDialog(null, fields, "Create Employee", JOptionPane.OK_CANCEL_OPTION);
		
		if(choice == -1 || choice == 2) { 
			textArea.append("Canceled\n");
			return;
		}
		
		if(field1.getText().equals("") || field2.getText().equals("")) { 
			textArea.append("Error must enter First and Last Name for " + job  + "\n");
			return;
		}	
	
		var tmp = createObject(job, field1.getText(), field2.getText());
		String fullName = field1.getText().strip() + " " + field2.getText().strip();
		employees.put(fullName, tmp);
		comboBox.addItem(fullName);
		textArea.append("Added " + job + " " + fullName + "\n" );
		
	}
	
	void basicInfo(Tester person) {
		textArea.append("Overime Hours: " + person.getOt() + "\n");
		textArea.append("Overtime Pay: " + person.getOtPay() + "\n");
	}
	
	void basicInfo(Designer person) {
		textArea.append("Design bonus: " + person.getBonus() + "\n");
	}
	
    void basicInfo(MarketingManager person) {
    	textArea.append("Manager Bonus: " + person.getBonus() + "\n");

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
			textArea.append("------Employee Info------\n");
			textArea.append("First Name: "+ person.getFirstName() + "\n");
			textArea.append("Last Name: "+ person.getLastName() + "\n");
			textArea.append("Address: "+ person.getAddress( ) + "\n");
			textArea.append("Job: " + person.getJob() + "\n");
			
			switch(person.getJob()) {
			
			case "Tester": basicInfo((Tester) person);
						   break;
			
			case "Designer": basicInfo((Designer) person);
						     break;
						     
			case "Marketing Manager": basicInfo((MarketingManager) person);
									  break;
			}
		}
		
		else if(e.getSource()==getfName) {
			
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
				return;
			}
			
			Employee person = employees.get(currEmployee);
			textArea.append("First Name: " + person.getFirstName() + "\n");
			
		}
	}
	
	
	public static void main(String[] args) {
		
		new Main();	
	}
}
