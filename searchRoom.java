import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchRoom extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField txt_Type;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchRoom frame = new searchRoom();
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
	public searchRoom() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(211, 11, 186, 31);
		contentPane.add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(10, 73, 96, 14);
		contentPane.add(lblRoomAvailable);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(53, 162, 96, 14);
		contentPane.add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Room Available");
		lblRoomAvailable_1.setBounds(195, 162, 79, 14);
		contentPane.add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		contentPane.add(lblPrice_1);
		
		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(324, 69, 205, 23);
		contentPane.add(checkRoom);
		
		txt_Type = new JTextField();
		txt_Type.setBounds(113, 70, 86, 20);
		contentPane.add(txt_Type);
		txt_Type.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select r_bedtype, r_checkstatus, r_cleanstatus, r_price from"
						+ " Room where r_bedtype = ?";
				String SQL2 = "select r_bedtype, r_checkstatus, r_cleanstatus, r_price from"
						+ " Room where r_checkstatus = 'Available'";
			try{			
				PreparedStatement pst = conn.prepareStatement(SQL);
				pst.setString(1,txt_Type.getText());
				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(checkRoom.isSelected())
				{
					Statement stm = conn.createStatement();
					rs = stm.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(333, 343, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(458, 343, 89, 23);
		contentPane.add(btnExit);
		
		table = new JTable();
		table.setBounds(27, 187, 502, 145);
		contentPane.add(table);
		
		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(326, 162, 96, 14);
		contentPane.add(lblCleanStatus);
	}
}
