package EmployeeRecordSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameHome extends JFrame {

	private JPanel contentPane;

	/**
	 * @author Sourov Halder
	 */
	public FrameHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHome.class.getResource("/images/main-icon.png")));
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabelFir = new JLabel("Welcome to");
		headerLabelFir.setForeground(Color.RED);
		headerLabelFir.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		headerLabelFir.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabelFir.setBounds(12, 235, 928, 48);
		contentPane.add(headerLabelFir);

		JLabel headerLabelSec = new JLabel("Employee Record System");
		headerLabelSec.setForeground(new Color(0, 0, 128));
		headerLabelSec.setFont(new Font("Times New Roman", Font.BOLD, 35));
		headerLabelSec.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabelSec.setBounds(12, 277, 928, 48);
		contentPane.add(headerLabelSec);

		JLabel instaLabel = new JLabel("Click here to open the system.");
		instaLabel.setForeground(new Color(0, 0, 0));
		instaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		instaLabel.setBounds(12, 338, 928, 48);
		contentPane.add(instaLabel);

		JButton backButton = new JButton(" OPEN");
		backButton.setIcon(new ImageIcon(FrameHome.class.getResource("/images/icon-7.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(400, 399, 153, 48);
		contentPane.add(backButton);

		JLabel imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon(FrameHome.class.getResource("/images/home-logo.png")));
		imgLabel.setBounds(400, 80, 153, 142);
		contentPane.add(imgLabel);
		setLocationRelativeTo(null);
	}
}