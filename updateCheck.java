import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateCheck extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Room;
	private JTextField txt_Status;
	private JTextField txt_Date;
	private JTextField txt_Time;
	private JTextField txt_Payment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateCheck frame = new updateCheck();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public updateCheck() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateCheckStatus = new JLabel("Update Check Status");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		contentPane.add(lblUpdateCheckStatus);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(25, 88, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Room ID:");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Check Status:");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Reserved Date:");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Check In Time:");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Payment Status:");
		lblNewLabel_5.setBounds(25, 302, 97, 14);
		contentPane.add(lblNewLabel_5);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(248, 85, 86, 20);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		
		txt_Room = new JTextField();
		txt_Room.setBounds(248, 126, 86, 20);
		contentPane.add(txt_Room);
		txt_Room.setColumns(10);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(248, 171, 86, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
		
		txt_Date = new JTextField();
		txt_Date.setBounds(248, 216, 86, 20);
		contentPane.add(txt_Date);
		txt_Date.setColumns(10);
		
		txt_Time = new JTextField();
		txt_Time.setBounds(248, 258, 86, 20);
		contentPane.add(txt_Time);
		txt_Time.setColumns(10);
		
		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 86, 20);
		contentPane.add(txt_Payment);
		txt_Payment.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException { 
				String updateSQL = "Update CheckStatus set  c_roomid = ?, c_checkstatus = ?, c_time = ?, c_paymentstatus = ? where c_guestid = ?";
				try{
					pst = conn.prepareStatement(updateSQL);
					
					pst.setInt(1, Integer.parseInt(txt_Room.getText()));
					pst.setString(2, txt_Status.getText());
					pst.setString(3, txt_Time.getText());
					pst.setString(4, txt_Payment.getText());
					pst.setInt(5, Integer.parseInt(txt_ID.getText()));
					
					pst.executeUpdate();
		
	    			JOptionPane.showMessageDialog(null, "Update Successful");
	    			close();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				catch(Exception e2) {
					if(txt_ID.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter the Guest ID");
					}
					else{
					JOptionPane.showMessageDialog(null, "Please Enter a valid number");
				}
				}
				
				
				
				
			}
		});
		btnUpdate.setBounds(218, 378, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(321, 378, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String insertSQL = "Insert into CheckStatus (c_guestid, c_roomid, c_checkstatus,c_date,c_time,c_paymentstatus) values (?,?,?,?,?,?)";
				try{
					pst = conn.prepareStatement(insertSQL);
					
					pst.setInt(1, Integer.parseInt(txt_ID.getText()));
					pst.setInt(2, Integer.parseInt(txt_Room.getText()));
					pst.setString(3, txt_Status.getText());
					pst.setString(4, txt_Date.getText());
					pst.setString(5, txt_Time.getText());
					pst.setString(6, txt_Payment.getText());
					
					pst.executeUpdate();
		
	    			JOptionPane.showMessageDialog(null, "Add Successful");
	    			close();
				}catch(SQLException e1){
					e1.printStackTrace();
				}
				catch(NumberFormatException s){
					JOptionPane.showMessageDialog(null, "Please Enter a valid number");
				}
			}
		});
		btnAdd.setBounds(106, 378, 89, 23);
		contentPane.add(btnAdd);
	}

}
