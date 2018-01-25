import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateRoom extends JFrame {
Connection conn = null;
PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Ava;
	private JTextField txt_Status;
	private JTextField txt_Room;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateRoom frame = new updateRoom();
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
	public updateRoom() throws SQLException {
		conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(115, 11, 206, 34);
		contentPane.add(lblUpdateRoomStatus);
		
		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);
		
		JLabel lblCleanStatus = new JLabel("Clean Status:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblCleanStatus);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(208, 84, 86, 20);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		
		txt_Ava = new JTextField();
		txt_Ava.setBounds(208, 184, 86, 20);
		contentPane.add(txt_Ava);
		txt_Ava.setColumns(10);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(208, 237, 86, 20);
		contentPane.add(txt_Status);
		txt_Status.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				String updateSQL = "Update Room set r_guestid = ?, r_checkstatus = ?, r_cleanstatus = ? where r_id = ?";
				
				try{
					pst = conn.prepareStatement(updateSQL);
					
					pst.setInt(1, Integer.parseInt(txt_ID.getText()));
					pst.setString(2, txt_Ava.getText());
					pst.setString(3, txt_Status.getText());
					pst.setInt(4, Integer.parseInt(txt_Room.getText()));
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update Sucessful");
					close();
				}catch (SQLException e1){
					e1.printStackTrace();
				}
				catch(Exception s){
					if(txt_Room.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter the Room ID");
					}
					else{
						JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
					}
				}
			
			}
		});
		btnUpdate.setBounds(216, 315, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnExit.setBounds(332, 315, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblRoomId = new JLabel("Room ID:");
		lblRoomId.setBounds(27, 133, 79, 14);
		contentPane.add(lblRoomId);
		
		txt_Room = new JTextField();
		txt_Room.setBounds(208, 130, 86, 20);
		contentPane.add(txt_Room);
		txt_Room.setColumns(10);
	}

}
