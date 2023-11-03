package checkPassWord;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.SystemColor;

public class Login extends JFrame {
	private JPanel contentPane;
	private JLabel loginLbl;
	public JTextField UsernameTxt;
	private JPasswordField passwordField;
	public String name;

	
	


private boolean checkemptyfields() {
	return (UsernameTxt.getText().equals("")||String.valueOf(passwordField.getPassword()).equals(""));
	
}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		Border bd = BorderFactory.createMatteBorder(3,3,3,3,Color.black);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 128));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 450, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*Border*/
		
		Border borderpanel = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black);
		
		
		JLabel closeLbl = new JLabel("X");
		closeLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeLbl.setForeground(Color.red);
				closeLbl.setFont(new Font("Tahoma",Font.BOLD,16));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeLbl.setForeground(Color.black);
				closeLbl.setFont(new Font("Tahoma",Font.PLAIN,16));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		closeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		closeLbl.setBounds(420, 4, 25, 16);
		panel.add(closeLbl);
		/*border*/
		Border bordercloselbl = BorderFactory.createMatteBorder(1, 1, 1, 1  , Color.black );
		
		
		JLabel minimizeLbl = new JLabel("-");
		minimizeLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeLbl.setForeground(Color.white);
				minimizeLbl.setFont(new Font("Tahoma",Font.BOLD,22));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimizeLbl.setForeground(Color.black);
				closeLbl.setFont(new Font("Tahoma",Font.PLAIN,22));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			    setState(JFrame.ICONIFIED);
			}
		
		});
		minimizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
		minimizeLbl.setBounds(397, 3, 25, 16);
		panel.add(minimizeLbl);
		
		/*border*/
		Border borderminimizelbl = BorderFactory.createMatteBorder(1, 1, 1, 1  , Color.black );
		
		loginLbl = new JLabel("Login");
		loginLbl.setForeground(Color.WHITE);
		loginLbl.setOpaque(true);
		loginLbl.setBackground(SystemColor.textHighlight);
		loginLbl.setHorizontalAlignment(SwingConstants.LEFT);
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginLbl.setBounds(16, -3, 143, 28);
		panel.add(loginLbl);
		
		
		JButton loginbtn = new JButton("Connexion");
		loginbtn.addActionListener(new ActionListener() {
			/**
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				if(checkemptyfields()) {
					JOptionPane.showMessageDialog(null, "Please enter your username and your password", "Necessary Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					PreparedStatement ps;
					ResultSet rs;
					name = UsernameTxt.getText();
					String passw = String.valueOf(passwordField.getPassword());
					
					String quer ="SELECT * FROM user_login WHERE username=? AND password=? ";
				
					try {
						ps = connectionBSD.getConnection().prepareStatement(quer);
						ps.setString(1, name);
						ps.setString(2, passw);
						rs = ps.executeQuery();
						if(rs.next()) {
							dispose();			
							menu mn = new menu();
							mn.setVisible(true);
							mn.setLocationRelativeTo(null);
							
						}
						else {
							JOptionPane.showMessageDialog(null,"No user whith this username or password", "Invalid Information ",JOptionPane.ERROR_MESSAGE );
						}
					}
					catch(Exception e1){
						
						JOptionPane.showMessageDialog(null, "connection to DB faild", "error connection DB", JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
			}
		});
		
	
		loginbtn.setBorderPainted(false);
		loginbtn.setBackground(SystemColor.textHighlight);
		
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		loginbtn.setBounds(77, 173, 287, 33);
		contentPane.add(loginbtn);
		Border b = BorderFactory.createMatteBorder(3,3 ,3 ,3 , Color.green);
		loginbtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 255, 0)));
		
		
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginbtn.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginbtn.setBackground(new Color(0,0,139));
			}
		});
		
		
		JLabel lblNewLabel_3 = new JLabel("Username * :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(44, 80, 146, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Password * :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(44, 121, 95, 14);
		contentPane.add(lblNewLabel_4);
		
		
		
		UsernameTxt = new JTextField();
		UsernameTxt.setHorizontalAlignment(SwingConstants.LEFT);
		UsernameTxt.setBounds(200, 76, 183, 20);
		contentPane.add(UsernameTxt);
		UsernameTxt.setColumns(10);
		
		/*border*/
		Border borderpassword = BorderFactory.createMatteBorder(3,3,3,3,Color.gray);
		UsernameTxt.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.LIGHT_GRAY));
		
		/*border*/
		Border borderusername = BorderFactory.createMatteBorder(3,3,3,3,Color.gray);
		
		JLabel lblNewLabel = new JLabel("OU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(193, 208, 46, 23);
		contentPane.add(lblNewLabel);
		
		JButton btncreer = new JButton("Créer un compte");
		btncreer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rejistere rj = new rejistere();
				rj.setVisible(true);
				rj.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btncreer.setForeground(new Color(255, 255, 255));
		btncreer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncreer.setBorderPainted(false);
		btncreer.setBackground(new Color(0, 128, 0));
		btncreer.setBounds(142, 234, 160, 23);
		contentPane.add(btncreer);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.LIGHT_GRAY));
		passwordField.setBounds(200, 120, 183, 20);
		contentPane.add(passwordField);
	}
}
