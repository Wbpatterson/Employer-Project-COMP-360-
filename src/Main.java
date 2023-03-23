
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	public HashMap<String, Employee> employees = new HashMap<String, Employee>();
	String currEmployee = "";
	
	JFrame frame = new JFrame("Employee Roster");
	JPanel panel = new JPanel(new GridLayout(2,0));
	JTextArea textArea = new JTextArea();
	JComboBox<String> comboBox = new JComboBox<String>();;
	
	JTextField textField = new JTextField();
	
	JButton tester = new JButton("add Tester");
	JButton designer = new JButton("add Designer");
	JButton manager = new JButton("add Manager");
	
	JButton getfName = new JButton("get First Name"); 		// button to retrieve first name
	JButton getlName = new JButton("get Last Name");  		// button to retrieve last name
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
	JButton printInfo = new JButton("Print Info");
	
	
	Main(){
		
		// Text Box properties
		textArea.setBounds(450, 30, 400, 300);
		textArea.setEditable(false);
		
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
		printInfo.setBounds(100, 150, 125, 50);
		printInfo.setFocusable(false);
		printInfo.addActionListener(this);
		
		// Drop-down box properties
		comboBox.setBounds(100, 30, 130, 30);
		comboBox.addActionListener(this);
		
		// frame additions 
		frame.add(printInfo);
		frame.add(textField);
		frame.add(comboBox);
		frame.add(manager);
		frame.add(designer);
		frame.add(tester);
		frame.add(clear);
		frame.add(textArea);
		
		// frame properties
		frame.setSize(900, 800);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		//Tester person1 = new Tester("John", "Doe");
		//Designer person2 = new Designer("Bruce", "Wayne");
		//MarketingManager person3 = new MarketingManager("Clark", "Kent");

		new Main();	
	}
	
	
	public void createTester() {
		String name1 = JOptionPane.showInputDialog("Enter Tester First Name:", "");
		String name2 = JOptionPane.showInputDialog("Enter Tester First Name:", "");
		
		if(name1 == null || name2 == null) {
			textArea.append("Caneceled\n");
		}
		else if(name1 == "" || name2 == "") {
			textArea.append("Error must enter First and Last Name for Tester\n");
		}
		else {
			Tester tmp = new Tester(name1, name2);
			String fullName = name1 + "" + name2;
			employees.put(fullName, tmp);
			comboBox.addItem(fullName);
			textArea.append("Added Designer " + fullName + "\n" );
		}
	}
	
	public void createDesigner() {
		String name1 = JOptionPane.showInputDialog("Enter Designer First Name:", "");
		String name2 = JOptionPane.showInputDialog("Enter Designer Last Name:", "");
		
		if(name1 == null || name2 == null) {
			textArea.append("Caneceled\n");
		}
		else if(name1 == "" || name2 == "") {
			textArea.append("Error must enter First and Last Name for Tester\n");
		}
		else {
			Designer tmp = new Designer(name1, name2);
			String fullName = name1 + "" + name2;
			employees.put(fullName, tmp);
			comboBox.addItem(fullName);
			textArea.append("Added Tester " + fullName + "\n");
			comboBox.getModel();
		}
	}
	
	public void createManager() {
		String name1 = JOptionPane.showInputDialog("Enter Manager First Name:", "");
		String name2 = JOptionPane.showInputDialog("Enter Manager Last Name:", "");
		
		if(name1 == null || name2 == null) {
			textArea.append("Caneceled\n");
		}
		else if(name1 == "" || name2 == "") {
			textArea.append("Error must enter First and Last Name for Tester\n");
		}
		else {
			MarketingManager tmp = new MarketingManager(name1, name2);
			String fullName = name1 + "" + name2;
			employees.put(fullName, tmp);
			comboBox.addItem(fullName);
			textArea.append("Added Manager " + fullName + "\n");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// clears text area text
		if(e.getSource()==clear) {
			textArea.setText("");
		}
		
		// assigns employee to evaluated from drop-down box
		else if(e.getSource()==comboBox) {
			currEmployee = (String) comboBox.getSelectedItem();
		}
		
		// Creates and initializes a Tester Object 
		else if(e.getSource()==tester) {
			createTester();
		}
		
		// Creates and initializes a Designer Object
		else if(e.getSource()==designer) {
			createDesigner();
		}
		
		// Creates and initializes a MarketingManager Object
		else if(e.getSource()==manager) {
			createManager();
		}
		
		// Prints Employee Info 
		else if (e.getSource()==printInfo) {
			if(currEmployee == "") {
				textArea.append("No Employee selected\n");
			}
			else {
				Employee person = employees.get(currEmployee);
				textArea.append("First Name: "+ person.getFirstName() + "\n");
				textArea.append("Last Name: "+ person.getLastName() + "\n");
				//textArea.append()
			}
			
		}
	}
}
