package usuario;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class Login {

	
	private JFrame frame;
	private JTextField textField_1;
	private JPasswordField passwordField;

//	public static void main(String[] args) {
//		
//					new Login();
//	}

	public Login() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		frame.setBackground(new Color(0, 51, 102));
		frame.getContentPane().setBackground(new Color(0, 51, 102));
		frame.setBounds(100, 100, 445, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblToYourAccount = new JLabel(" TO YOUR ACCOUNT");
		lblToYourAccount.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		lblToYourAccount.setForeground(new Color(255, 255, 255));
		lblToYourAccount.setBounds(168, 99, 207, 66);
		frame.getContentPane().add(lblToYourAccount);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Nirmala UI", Font.BOLD, 18));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(112, 99, 68, 66);
		frame.getContentPane().add(lblLogin);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(0, 51, 102));
		textField_1.setColumns(10);
		textField_1.setBounds(112, 191, 216, 20);
		frame.getContentPane().add(textField_1);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBackground( new Color(255, 255, 255));
		loginButton.setFont(new Font("Nirmala UI", Font.BOLD, 11));
		loginButton.setForeground(new Color(0, 51, 102));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		LoginAction loginAction = new LoginAction();
		loginButton.addActionListener(loginAction);
		loginButton.setBounds(112, 311, 218, 23);
		frame.getContentPane().add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(0, 51, 102));
		passwordField.setBounds(112, 244, 216, 20);
		frame.getContentPane().add(passwordField);
		
		JCheckBox rememberCheck = new JCheckBox("Remember me");
		rememberCheck.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		rememberCheck.setForeground(new Color(255, 255, 255));
		rememberCheck.setBackground(new Color(0, 51, 102));
		rememberCheck.setBounds(112, 281, 97, 23);
		frame.getContentPane().add(rememberCheck);
		
		JLabel senha = new JLabel("PASSWORD");
		senha.setForeground(new Color(255, 255, 255));
		senha.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		senha.setBounds(112, 222, 68, 14);
		frame.getContentPane().add(senha);
		
		JLabel login = new JLabel("EMAIL");
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 11));
		login.setBounds(112, 166, 46, 14);
		frame.getContentPane().add(login);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/usuario/icon.png")));
		lblNewLabel.setBounds(179, 11, 80, 95);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private class LoginAction implements ActionListener{
		   
		public void actionPerformed(ActionEvent event) {
				
				if(checkLogin(textField_1.getText(), new String(passwordField.getPassword()))) {
					frame.dispose();
					new TelaPrincipal().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!","Erro!",JOptionPane.WARNING_MESSAGE);
					}
				}
			public boolean checkLogin(String login, String senha) {
			return login.equals("admin")&& senha.equals("admin");
			}
	    }
}
