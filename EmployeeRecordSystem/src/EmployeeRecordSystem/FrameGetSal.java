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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameGetSal extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField salaryField;

	/**
	 * @author Sourov Halder
	 */
	public FrameGetSal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameGetSal.class.getResource("/images/main-icon.png")));
		setTitle("Salary Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("Note: Enter an ID and Click on \"OK\" button to get salary information of an Employee.");
		headerLabel.setForeground(Color.RED);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		headerLabel.setBounds(12, 95, 928, 39);
		contentPane.add(headerLabel);

		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		idLabel.setBounds(142, 173, 144, 34);
		contentPane.add(idLabel);

		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idField.setBounds(314, 170, 265, 37);
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel RBLabel = new JLabel("Result Box");
		RBLabel.setForeground(Color.BLUE);
		RBLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		RBLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RBLabel.setBounds(12, 267, 928, 48);
		contentPane.add(RBLabel);

		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		salaryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		salaryLabel.setBounds(142, 312, 144, 37);
		contentPane.add(salaryLabel);

		salaryField = new JTextField();
		salaryField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salaryField.setBounds(314, 314, 265, 37);
		contentPane.add(salaryField);
		salaryField.setColumns(10);

		JButton OKButton = new JButton(" OK");
		OKButton.setIcon(new ImageIcon(FrameGetSal.class.getResource("/images/icon-6.png")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();

				if (Main.uap.findEmployee(id) != null) {
					double sal = Main.uap.getSalary(id);
					salaryField.setText(String.valueOf(sal));
					idField.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "ID doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(610, 169, 116, 39);
		contentPane.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameGetSal.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(610, 313, 116, 39);
		contentPane.add(backButton);
		setLocationRelativeTo(null);
	}
}