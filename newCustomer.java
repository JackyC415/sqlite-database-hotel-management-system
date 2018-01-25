import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class newCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Name;
	private JTextField txt_Gender;
	private JTextField txt_Country;
	private JTextField txt_RRN;
	private JTextField txt_Status;
	private JTextField txt_Deposit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newCustomer frame = new newCustomer();
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
	public newCustomer() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(35, 111, 46, 14);
		contentPane.add(lblName_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(35, 76, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(35, 151, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setBounds(35, 191, 142, 14);
		contentPane.add(lblCountry);
		
		JLabel lblReserveRoomNumber = new JLabel("Reserve Room Number:");
		lblReserveRoomNumber.setBounds(35, 231, 158, 14);
		contentPane.add(lblReserveRoomNumber);
		
		JLabel lblCheckInStatus = new JLabel("Check In Status:");
		lblCheckInStatus.setBounds(35, 274, 94, 14);
		contentPane.add(lblCheckInStatus);
		
		JLabel lblDeposite = new JLabel("Deposit:");
		lblDeposite.setBounds(35, 316, 94, 14);
		contentPane.add(lblDeposite);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(271, 73, 86, 20);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		
		txt_Name = new JTextField();
		txt_Name.setBounds(271, 108, 86, 20);
		contentPane.add(txt_Name);
		txt_Name.setColumns(10);
		
		txt_Gender = new JTextField();
		txt_Gender.setBounds(271, 148, 86, 20);
		contentPane.add(txt_Gender);
		txt_Gender.setColumns(10);
		
		txt_Country = new JTextField();
		txt_Country.setBounds(271, 188, 86, 20);
		contentPane.add(txt_Country);
		txt_Country.setColumns(10);
		
		txt_RRN = new JTextField();
		txt_RRN.setBounds(271, 228, 86, 20);
		contentPane.add(txt_RRN);
		txt_RRN.setColumns(10);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(271, 271, 86, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
		
		txt_Deposit = new JTextField();
		txt_Deposit.setBounds(271, 313, 86, 20);
		contentPane.add(txt_Deposit);
		txt_Deposit.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		String insertTableSQL = "Insert into Guest" +
						"(g_id, g_name, g_gender, g_countryname, g_roomReserved, g_checkstatus, g_deposit) Values"
						+"(?,?,?,?,?,?,?)";
	    		

	    		try{
	    			pst = conn.prepareStatement(insertTableSQL);
	    			pst.setLong(1, Integer.parseInt(txt_ID.getText()));
	    			pst.setString(2, txt_Name.getText());
	    			pst.setString(3, txt_Gender.getText());
	    			pst.setString(4, txt_Country.getText());
	    			pst.setString(5, (txt_RRN.getText()));
	    			pst.setString(6, txt_Status.getText());
	    			pst.setLong(7, 	Integer.parseInt(txt_Deposit.getText()));
	    			
	    			pst.executeUpdate();
	    			close();
	    			JOptionPane.showMessageDialog(null, "Insert Successful");
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(243, 387, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(358, 387, 89, 23);
		contentPane.add(btnExit);
	}
}
