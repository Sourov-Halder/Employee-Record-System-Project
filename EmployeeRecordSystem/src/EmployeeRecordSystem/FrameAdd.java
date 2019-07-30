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
public class FrameAdd extends JFrame {

	private JPanel contentPane;

	/**
	 * @author Sourov Halder
	 */
	public FrameAdd() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAdd.class.getResource("/images/main-icon.png")));
		setTitle("Add Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("Choose a catagory to add Employee");
		headerLabel.setForeground(new Color(32, 178, 170));
		headerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(264, 191, 427, 48);
		contentPane.add(headerLabel);

		JButton salariedButton = new JButton(" Salaried");
		salariedButton.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/icon-9.png")));
		salariedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fsal.setVisible(true);
			}
		});
		salariedButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		salariedButton.setBounds(340, 252, 279, 48);
		contentPane.add(salariedButton);

		JButton hourlyButton = new JButton(" Hourly");
		hourlyButton.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/icon-9.png")));
		hourlyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fhourly.setVisible(true);
			}
		});
		hourlyButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hourlyButton.setBounds(340, 313, 279, 48);
		contentPane.add(hourlyButton);

		JButton comButton = new JButton(" Commission");
		comButton.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/icon-9.png")));
		comButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fcom.setVisible(true);
			}
		});
		comButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comButton.setBounds(340, 374, 280, 48);
		contentPane.add(comButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(410, 510, 142, 40);
		contentPane.add(backButton);

		JLabel imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/option.png")));
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setBounds(410, 75, 142, 132);
		contentPane.add(imgLabel);
		setLocationRelativeTo(null);
	}
}