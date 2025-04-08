package com.odfin.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.odifn.core.Employee;
import com.odifn.core.Firm;

import layout.TableLayout;

public class MainFrame extends JFrame {	

	private int index = 0;
	
	private JButton btnClose = new JButton("Schließen");
	private JButton btnLastPage = new JButton("<");
	private JButton btnNextPage = new JButton(">");
	
	private JLabel lblCompany = new JLabel("Firma: ");
	private JLabel lblName = new JLabel("Vorname: ");
	private JLabel lblLastname = new JLabel("Nachname: ");
	
	private JTextField txtName = new JTextField("");
	private JTextField txtLastname = new JTextField("");
	


	private Employee[] odfinEmployees = {
			new Employee("Philip", "Kulik"),
			new Employee("Timo", "Rosenstengel"),
			new Employee("Enes", "Avsar"),
			new Employee("Tolga", "Saral"),
			new Employee("Leon", "Winterberg"),
			new Employee("Pasquale", "Hoffmann")
			};
	private Firm odfin = new Firm("Opta data Finance GmbH", odfinEmployees);	
	

	private Employee[] odItsEmployees = {
			new Employee("Max", "Stadler"),
			new Employee("Alexander", "Noetzel"),
			new Employee("Tristan", "Amann"),
			new Employee("Jonas", "Pawlak"),
			new Employee("Matej", "Yankov")
			};
	private Firm odIts = new Firm("Opta data IT-Solutions GmbH", odItsEmployees);
	
	private Firm currentFirm = odfin;
	
	private JComboBox<String> cmbCompany = new JComboBox<String>();
	
	public MainFrame() {		
		setTitle("Mitarbeiterverwaltung");
		setSize(500, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		refreshFirm();
		
		add(createPanel());
		

	}
	
	private JPanel createPanel() {
		JPanel panel = new JPanel();
		double tableSize[][] = {
				{20, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, 10, TableLayout.FILL, TableLayout.PREFERRED, 20},
				{20, TableLayout.PREFERRED, 20, TableLayout.PREFERRED, 10, TableLayout.PREFERRED, 40, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, 30},
			};//Spalte Zeile 8 Spalten, 11 Zeilen
		TableLayout tablelayout = new TableLayout(tableSize);
		panel.setLayout(tablelayout);
		
		//Company
		panel.add(lblCompany, "1, 1");
		panel.add(cmbCompany, "2, 1, 7, 1");
		cmbCompany.addItem(odfin.getName());
		cmbCompany.addItem(odIts.getName());
		cmbCompany.addActionListener(e ->{
			int selectedIndex = cmbCompany.getSelectedIndex();
			
			switch (selectedIndex) {
			case 0 -> currentFirm = odfin;
			case 1 -> currentFirm = odIts;
			default -> throw new IllegalArgumentException("Unexpected value: " + selectedIndex);
			}
			index = 0;
			refreshFirm();
		});
		//(x, y) (Spalte, Zeile)
		//Vorname
		panel.add(lblName, "2, 3");
		panel.add(txtName, "3, 3, 5, 3");
		txtName.setEditable(false);
		
		//Nachname
		panel.add(lblLastname, "2, 5");
		panel.add(txtLastname, "3, 5");
		txtLastname.setEditable(false);
		
		//Zurück
		panel.add(btnLastPage, "1, 7");
		btnLastPage.addActionListener(e ->{
			if(index >= 1) {	
				index--;
				refreshFirm();
			}
		});
		
		//Nächster
		panel.add(btnNextPage, "7, 7");
		btnNextPage.addActionListener(e ->{
			if(index < currentFirm.getTotalEmployees()) {
				index++;
				refreshFirm();
			}
		});
		
		//die.
		panel.add(btnClose, "4, 9");
		btnClose.addActionListener(e -> System.exit(0));
		
        return panel;
	}
	
	private void refreshFirm() {
		txtName.setText(currentFirm.getEmployee(index).getName());
		txtLastname.setText(currentFirm.getEmployee(index).getLastname());
	}
		
}
