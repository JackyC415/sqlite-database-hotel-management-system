import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pickUp extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pickUp frame = new pickUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public pickUp() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPickUpService = new JLabel("Pick Up Service");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickUpService.setBounds(139, 11, 158, 25);
		contentPane.add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("Type of Car");
		lblTypeOfCar.setBounds(32, 97, 119, 14);
		contentPane.add(lblTypeOfCar);
		
		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setBounds(32, 148, 88, 14);
		contentPane.add(lblDriver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Merceds", "BMW", "Toyota", "Volkswagan", "Honda", "Lexus", "Lambo", "Ford", "Ferrai"}));
		comboBox.setBounds(123, 94, 97, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Peter", "John", "Steve", "Laura", "Jason", "Mary", "Marco", "Donna", "Albert", "Jessica"}));
		comboBox_1.setBounds(123, 145, 97, 25);
		contentPane.add(comboBox_1);
		
		JLabel lblInfo = new JLabel("Age");
		lblInfo.setBounds(24, 208, 46, 14);
		contentPane.add(lblInfo);
		
		JButton btnRegister = new JButton("Display");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select dr_age, dr_name, dr_gender, dr_style, p_year, p_brand, p_availability, p_airport from"
							+ " Driver, PickUpCar where dr_name = ? and p_brand = ?";
				try{
				
					PreparedStatement pst = conn.prepareStatement(SQL);
					pst.setString(1, (String) comboBox_1.getSelectedItem());
					pst.setString(2, (String) comboBox.getSelectedItem());
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				}catch (SQLException ss)
				{
					ss.printStackTrace();
				}
				
				
			}
		});
		btnRegister.setBounds(246, 354, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnExit.setBounds(388, 354, 89, 23);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(10, 233, 623, 38);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(105, 208, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(174, 208, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblTypeOfDriver = new JLabel("Type");
		lblTypeOfDriver.setBounds(256, 208, 50, 14);
		contentPane.add(lblTypeOfDriver);
		
		JLabel lblDateOfThe = new JLabel("Date of the Car");
		lblDateOfThe.setBounds(316, 208, 105, 14);
		contentPane.add(lblDateOfThe);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(414, 208, 46, 14);
		contentPane.add(lblBrand);
		
		JLabel lblAirport = new JLabel("Airport");
		lblAirport.setBounds(570, 208, 46, 14);
		contentPane.add(lblAirport);
		
		JLabel lblAvailable = new JLabel("Available");
		lblAvailable.setBounds(487, 208, 73, 14);
		contentPane.add(lblAvailable);
	}
}
