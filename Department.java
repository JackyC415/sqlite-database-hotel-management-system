import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Department extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department frame = new Department();
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
	public Department() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(23, 36, 442, 221);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String displayCustomersql = "select d_name, d_budget from Department";
					PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(288, 268, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					close();
			}
		});
		btnNewButton_1.setBounds(387, 268, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(45, 11, 105, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Budget");
		lblNewLabel_1.setBounds(331, 11, 75, 14);
		contentPane.add(lblNewLabel_1);
	}

}
