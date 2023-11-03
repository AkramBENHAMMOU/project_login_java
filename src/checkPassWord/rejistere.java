package checkPassWord;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import java.util.regex.Pattern;
import java.io.*;

import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class rejistere extends JFrame {

	private JPanel contentPane;
	private JTextField namelbl;
	private JTextField usernamelbl;
	private JTextField emaillbl;
	private JTextField phonelbl;
	private JPasswordField passwordlbl;
	private JPasswordField confirmpasslbl;
	private JLabel genderlbl;
	private JLabel imagelbl;
	private  JButton registerbtn;
	private JLabel imgpathlbl;
	
	/**
	 * @wbp.nonvisual location=312,269
	 */
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField imgpathlbl_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rejistere frame = new rejistere();
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
	 **/
	public rejistere() {
		setUndecorated(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 450, 25);
		contentPane.add(panel);
		
		Border borderpnl = BorderFactory.createMatteBorder(2,2 ,2 ,2 , Color.black);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setBounds(10, 2, 286, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JLabel closebtn = new JLabel("X");
		closebtn.setBounds(421, 1, 20, 21);
		closebtn.setBackground(Color.BLUE);
		closebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				closebtn.setForeground(Color.red);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closebtn.setForeground(Color.black);
				
			}
		});
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		closebtn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(closebtn);
		
		Border bordercls = BorderFactory.createMatteBorder(2,2 ,2 ,2 , Color.black);
		closebtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.BLUE));
		
		JLabel minbtn = new JLabel("-");
		minbtn.setBounds(391, -2, 20, 24);
		minbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
			
			public void mouseEntered(MouseEvent e) {
				minbtn.setForeground(Color.white);
			
			}
			
			public void mouseExited(MouseEvent e) {
				minbtn.setForeground(Color.black);
			
			}
		});
		minbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		
		minbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		minbtn.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(minbtn);
		
		Border bordermin = BorderFactory.createMatteBorder(2,2 ,2 ,2 , Color.black);
		 minbtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Name * :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(59, 47, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Username * :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(59, 72, 109, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email * :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(59, 97, 60, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Phone  :");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(59, 122, 70, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Password * :");
		lblNewLabel_2_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(59, 151, 86, 14);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Confirm Password*:");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(59, 178, 137, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel genderlbl = new JLabel("Gender * :");
		genderlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		genderlbl.setBounds(61, 203, 84, 14);
		contentPane.add(genderlbl);
		
		JLabel imagelbl = new JLabel("Image * :");
		imagelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		imagelbl.setBounds(59, 226, 80, 20);
		contentPane.add(imagelbl);
		
		namelbl = new JTextField();
		namelbl.setBounds(194, 47, 210, 20);
		contentPane.add(namelbl);
		namelbl.setColumns(10);
		
		usernamelbl = new JTextField();
		usernamelbl.setColumns(10);
		usernamelbl.setBounds(194, 72, 210, 20);
		contentPane.add(usernamelbl);
		
		emaillbl = new JTextField();
		
		//Force to type email Form
		emaillbl.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				emailValid();
			}
		});
		
		
		emaillbl.setColumns(10);
		emaillbl.setBounds(194, 97, 210, 20);
		contentPane.add(emaillbl);
		
		
		
		//type just digit in phone label
		phonelbl = new JTextField();
		phonelbl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if(!Character.isDigit(key)) {
					e.consume();
				}
			}
		});
		
		
		phonelbl.setColumns(10);
		phonelbl.setBounds(194, 123, 210, 20);
		contentPane.add(phonelbl);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(212, 203, 60, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_1.setBounds(287, 203, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		passwordlbl = new JPasswordField();
		passwordlbl.setBounds(195, 151, 210, 20);
		contentPane.add(passwordlbl);
		
		confirmpasslbl = new JPasswordField();
		confirmpasslbl.setBounds(194, 177, 210, 20);
		contentPane.add(confirmpasslbl);
		
		JButton btnselectimg = new JButton("select image");
		btnselectimg.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		btnselectimg.setBackground(Color.LIGHT_GRAY);
		btnselectimg.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnselectimg.setBounds(190, 226, 91, 23);
		contentPane.add(btnselectimg);
		
		
		btnselectimg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter  filter = new FileNameExtensionFilter("Images","pnj","jpg","jpeg");
				chooser.addChoosableFileFilter(filter);
				chooser.setDialogTitle("Choose your image");
				int returnvalue = chooser.showDialog(null,"ok");
				if(returnvalue == JFileChooser.APPROVE_OPTION) {
					File selectedimg = chooser.getSelectedFile();
                    String path = selectedimg.getAbsolutePath();
					
					imgpathlbl_2.setText(path);
					
				}
			}
		});
		
		registerbtn = new JButton("Register");
		registerbtn.setForeground(Color.WHITE);
		registerbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		registerbtn.setBorderPainted(false);
		registerbtn.setBackground(new Color(0, 128, 0));
		registerbtn.setBounds(58, 259, 129, 30);
		contentPane.add(registerbtn);
		registerbtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				 
				 if (checkemptyfields()) {
			            JOptionPane.showMessageDialog(null, "Please make sure to enter all your information", "Missing Information", JOptionPane.ERROR_MESSAGE);
			        } else {
			            String nom = namelbl.getText();
			            String user = usernamelbl.getText();
			            String tele = phonelbl.getText();
			            String mail = emaillbl.getText();
			            String mdp = String.valueOf(passwordlbl.getPassword());
			            String confmdp = String.valueOf(confirmpasslbl.getPassword());
			            String gender = "Male";
			            if (rdbtnNewRadioButton_1.isSelected()) {
			                gender = "Female";
			            }
			            if (!matchingpassw(mdp, confmdp)) {
			                JOptionPane.showMessageDialog(null, "The passwords don't match", "Passwords Matching", JOptionPane.ERROR_MESSAGE);
			            } 
			            else {
			                PreparedStatement ps;
			                String query = "INSERT INTO user_login(username, name, password, phone, email, gender, image) VALUES(?, ?, ?, ?, ?, ?, ?)";
			                try {
			                    ps = connectionBSD.getConnection().prepareStatement(query);
			                    ps.setString(1, user);
			                    ps.setString(2, nom);
			                    ps.setString(3, mdp);
			                    ps.setString(4, tele);
			                    ps.setString(5, mail);
			                    ps.setString(6, gender);
			                    try {
			                    	
			    					String kda=imgpathlbl_2.getText();
			    					
			                        InputStream image = new FileInputStream(new File(kda));
			                        
			                        ps.setBlob(7, image);
			                    } catch (Exception ex) {
			                        JOptionPane.showMessageDialog(null, "Image couldn't be copied to DB", "Error", JOptionPane.ERROR_MESSAGE);
			                    }
			                    
			                    
			                  if(!checkUser()) {
			                    if (ps.executeUpdate() != 0) {
			                        JOptionPane.showMessageDialog(null, "You are successfully registered", "Success", JOptionPane.PLAIN_MESSAGE);
			                    } else {
			                        JOptionPane.showMessageDialog(null, "Your account hasn't been created", "Error", JOptionPane.ERROR_MESSAGE);
			                    }
			                  }
			                } catch (Exception e5) {
			                    JOptionPane.showMessageDialog(null, "Connection to DB Failed", "Failed", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        }
			    }
			});
	
		
		
		
		JButton have_acc_btn = new JButton("Already have an account ?");
		have_acc_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				lg.setLocationRelativeTo(null);
				dispose();
			}
		});
		have_acc_btn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		have_acc_btn.setForeground(Color.BLACK);
		have_acc_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		have_acc_btn.setBorderPainted(false);
		have_acc_btn.setBackground(Color.LIGHT_GRAY);
		have_acc_btn.setBounds(230, 260, 174, 29);
		contentPane.add(have_acc_btn);
		
		JLabel ou_lb = new JLabel("OU");
		ou_lb.setFont(new Font("Tahoma", Font.BOLD, 11));
		ou_lb.setHorizontalAlignment(SwingConstants.CENTER);
		ou_lb.setBounds(190, 260, 38, 29);
		contentPane.add(ou_lb);
		
		imgpathlbl_2 = new JTextField();
		imgpathlbl_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		imgpathlbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		imgpathlbl_2.setText("image path");
		imgpathlbl_2.setBounds(297, 227, 86, 20);
		contentPane.add(imgpathlbl_2);
		imgpathlbl_2.setColumns(10);
		
		
		
	}
	private boolean checkemptyfields() {
		
		return(namelbl.getText().equals("") || (usernamelbl.getText().equals("")) || emaillbl.getText().equals("")|| phonelbl.getText().equals("")|| String.valueOf(passwordlbl.getPassword()).equals("")|| String.valueOf(confirmpasslbl.getPassword()).equals("")||imgpathlbl_2.getText().equals("image path") );
	}
	private boolean matchingpassw(String p1 , String p2) {
		return(p1.equals(p2));
	}
	private boolean checkUser() {
		boolean check = false;
		PreparedStatement ps;
		ResultSet rs;
		String query = "SELECT username FROM user_login WHERE username = ?";
		try {
			ps=connectionBSD.getConnection().prepareStatement(query);
			String user = usernamelbl.getText(); 
			ps.setString(1, user);
			rs=ps.executeQuery();
			if(rs.next()) {
				check = true;
				JOptionPane.showMessageDialog(null, "This user is already exist","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
			   
			}
			
		}
		catch(Exception ex1) {
			JOptionPane.showMessageDialog(null,"No connection to DB","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
			
		}
		return check;
	}
	
	//email valid
	private void emailValid() {
		String email = emaillbl.getText();
		if(!isValid(email)) {
			JOptionPane.showMessageDialog(null,"Your E-mail is not valid","Error E-mail",JOptionPane.ERROR_MESSAGE);
			emaillbl.requestFocus();
		}
	}
	
	private boolean isValid(String email) {
		boolean check =false;
		String mailForm = "^[a-zA-Z0-9_$&]+@[a-zA-Z0-9]+\\.+[a-zA-Z]{2,4}$";
		return Pattern.matches(mailForm, email);
	}
}
