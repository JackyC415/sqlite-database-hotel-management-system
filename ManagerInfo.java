import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ManagerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblAge;
	private JLabel lblGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInfo frame = new ManagerInfo();
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
	public ManagerInfo() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(33, 40, 575, 218);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String displayCustomersql = "select m_name, m_salary, m_age, m_gender from Manager";
					PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(420, 283, 89, 23);
		contentPane.add(btnLoadData);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(538, 283, 89, 23);
		contentPane.add(btnExit);
		
		lblName = new JLabel("Name");
		lblName.setBounds(74, 15, 46, 14);
		contentPane.add(lblName);
		
		lblNewLabel = new JLabel("Salary");
		lblNewLabel.setBounds(224, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(383, 15, 46, 14);
		contentPane.add(lblAge);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(514, 15, 46, 14);
		contentPane.add(lblGender);
	}

}
