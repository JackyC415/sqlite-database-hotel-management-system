import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.EventQueue;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

public class Manager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	public void close()
	{
		System.exit(0);
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Manager() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewCustomerForm = new JButton("New Customer Form");
		btnNewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				newCustomer custom = new newCustomer();
				custom.setVisible(true);
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnNewCustomerForm.setBounds(10, 26, 170, 23);
		contentPane.add(btnNewCustomerForm);
		
		JButton btnNewButton = new JButton("Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Room room = new Room();
				room.setVisible(true);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 225, 170, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Department");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Department dept = new Department();
					dept.setVisible(true);
					
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setBounds(10, 268, 170, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All Employee Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					Employee em = new Employee();
					em.setVisible(true);
					
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(10, 353, 170, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Customer Info");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					CustomerInfo customer = new CustomerInfo();
					customer.setVisible(true);				
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(10, 180, 170, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnManagerInfo = new JButton("Manager Info");
		btnManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ManagerInfo mana = new ManagerInfo();
				mana.setVisible(true);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnManagerInfo.setBounds(10, 308, 170, 23);
		contentPane.add(btnManagerInfo);
		
		JButton btnNewButton_4 = new JButton("Check Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOut check;
				try {
					check = new checkOut();
					check.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(10, 66, 170, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update Check Status");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				updateCheck update = new updateCheck();
				update.setVisible(true);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(10, 100, 170, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Update Room Status");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					updateRoom room = new updateRoom();
					room.setVisible(true);
				}catch(Exception s)
				{
					s.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(10, 146, 170, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnPickUpSerice = new JButton("Pick up Service");
		btnPickUpSerice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				pickUp pick = new pickUp();
				pick.setVisible(true);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnPickUpSerice.setBounds(190, 26, 115, 23);
		contentPane.add(btnPickUpSerice);
		
		JButton btnSearchRoom = new JButton("Search Room");
		btnSearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				searchRoom search = new searchRoom();
				search.setVisible(true);
				}
				catch (Exception ss){
					ss.printStackTrace();
				}
			}
		});
		btnSearchRoom.setBounds(203, 225, 114, 23);
		contentPane.add(btnSearchRoom);

		JButton btnNewButton_7 = new JButton("Log Out");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn.close();
					close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.setBounds(190, 391, 115, 23);
		contentPane.add(btnNewButton_7);
	}
}
