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
public class Room extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room frame = new Room();
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
	public Room() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 40, 592, 235);
		contentPane.add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String displayCustomersql = "select r_id, r_checkstatus, r_cleanstatus, r_price, r_bedtype, r_roomNumber from Room";
					PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(329, 310, 89, 23);
		contentPane.add(btnLoadData);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton.setBounds(428, 310, 89, 23);
		contentPane.add(btnNewButton);
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(119, 15, 69, 14);
		contentPane.add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		contentPane.add(lblCleanStatus);
		
		lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(342, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setBounds(427, 15, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(513, 15, 89, 14);
		contentPane.add(lblRoomNumber);
		
		lblId = new JLabel("ID");
		lblId.setBounds(52, 15, 46, 14);
		contentPane.add(lblId);
	}

}
