import java.awt.EventQueue;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

public class Login {
Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;

	private JFrame frame;
	private JTextField txt_username;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		initialize();
		conn = Javaconnect.getDBConnection();
	}
	public void close(){
		this.frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(357, 114, 67, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(357, 187, 67, 27);
		frame.getContentPane().add(lblPassword);
		
		txt_username = new JTextField();
		txt_username.setBounds(419, 117, 86, 20);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loginsql = "select * from Manager where m_name=? and password=?";
				try{
					pst = conn.prepareStatement(loginsql);
					pst.setString(1, txt_username.getText());
					pst.setString(2, txt_password.getText());
					
					rs = pst.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Login Successful");
						Manager manager = new Manager();
						manager.setVisible(true);
						close();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Username and Password is incorrect");
				}
			}
		});
		btnLogin.setBounds(400, 275, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(418, 190, 87, 20);
		frame.getContentPane().add(txt_password);
	}
}
