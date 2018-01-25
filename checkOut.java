import java.awt.BorderLayout;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkOut extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_Name;
	private JTextField txt_RoomNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut frame = new checkOut();
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
	public checkOut() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(161, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(36, 85, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(36, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		txt_Name = new JTextField();
		txt_Name.setBounds(169, 82, 86, 20);
		contentPane.add(txt_Name);
		txt_Name.setColumns(10);
		
		txt_RoomNumber = new JTextField();
		txt_RoomNumber.setBounds(169, 132, 86, 20);
		contentPane.add(txt_RoomNumber);
		txt_RoomNumber.setColumns(10);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteSQL = "Delete from Guest where g_name = ? and g_roomReserved = ?";
				

	    		try{
	    			pst = conn.prepareStatement(deleteSQL);
	    			pst.setString(1, txt_Name.getText());
	    			pst.setString(2, txt_RoomNumber.getText());
	    			
	    			pst.executeUpdate();
	    			
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			close();
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(186, 355, 115, 23);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(325, 355, 89, 23);
		contentPane.add(btnExit);
	}

}
