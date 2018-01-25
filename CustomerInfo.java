import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblCountry;
	private JLabel lblRoom;
	private JLabel lblStatus;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo frame = new CustomerInfo();
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
	public CustomerInfo() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(350, 279, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String displayCustomersql = "select * from Guest";
				PreparedStatement pst = conn.prepareStatement(displayCustomersql);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		btnLoadData.setBounds(233, 279, 89, 23);
		contentPane.add(btnLoadData);
		
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		contentPane.add(lblId);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(93, 11, 65, 14);
		contentPane.add(lblNewLabel);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(179, 11, 46, 14);
		contentPane.add(lblGender);
		
		table = new JTable();
		table.setBounds(10, 32, 573, 232);
		contentPane.add(table);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(276, 11, 46, 14);
		contentPane.add(lblCountry);
		
		lblRoom = new JLabel("Room");
		lblRoom.setBounds(361, 11, 46, 14);
		contentPane.add(lblRoom);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(439, 11, 46, 14);
		contentPane.add(lblStatus);
		
		lblNewLabel_1 = new JLabel("Deposite");
		lblNewLabel_1.setBounds(526, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
