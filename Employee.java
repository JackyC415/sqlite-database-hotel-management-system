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
public class Employee extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblJob;
	private JLabel lblName;
	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(21, 34, 441, 230);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String displayCustomersql = "select e_salary, e_job, e_name, e_department from Employee";
				PreparedStatement pst = conn.prepareStatement(displayCustomersql);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(273, 275, 89, 23);
		contentPane.add(btnLoadData);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(390, 275, 89, 23);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("Salary");
		lblNewLabel.setBounds(41, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblJob = new JLabel("JOB");
		lblJob.setBounds(159, 11, 46, 14);
		contentPane.add(lblJob);
		
		lblName = new JLabel("Name");
		lblName.setBounds(273, 11, 46, 14);
		contentPane.add(lblName);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(376, 11, 86, 14);
		contentPane.add(lblDepartment);
	}
}
