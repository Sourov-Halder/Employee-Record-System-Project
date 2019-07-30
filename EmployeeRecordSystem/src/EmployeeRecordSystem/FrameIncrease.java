package EmployeeRecordSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
public class FrameIncrease extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField salField;

	/**
	 * @author Sourov Halder
	 */
	public FrameIncrease() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameIncrease.class.getResource("/images/main-icon.png")));
		setTitle("Increase Salary");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("Note: Fill up the form properly and Click on \"OK\" button to get salary information of an Employee.");
		headerLabel.setForeground(Color.RED);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		headerLabel.setBounds(12, 105, 928, 39);
		contentPane.add(headerLabel);

		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		idLabel.setBounds(207, 170, 144, 34);
		contentPane.add(idLabel);

		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idField.setBounds(381, 171, 265, 37);
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel salLabel = new JLabel("Salary");
		salLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		salLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		salLabel.setBounds(207, 217, 144, 37);
		contentPane.add(salLabel);
		setLocationRelativeTo(null);

		salField = new JTextField();
		salField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salField.setBounds(381, 219, 265, 37);
		contentPane.add(salField);
		salField.setColumns(10);

		JButton OKButton = new JButton(" OK");
		OKButton.setIcon(new ImageIcon(FrameIncrease.class.getResource("/images/icon-5.png")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				double sal = Double.parseDouble(salField.getText());

				if (Main.uap.findEmployee(id) != null) {
					if (sal > 0) {
						Main.uap.increaseSalary(id, sal);
						idField.setText(null);
						salField.setText(null);
						JOptionPane.showMessageDialog(null, "Increased Successfully.");
						ObjectOutputStream oos = null;
						try {
							oos = new ObjectOutputStream(new FileOutputStream(Main.fileName));
							oos.writeObject(Main.uap);
						} catch (Exception f) {
							System.out.print("");
						}
					} else {
						idField.setText(null);
						salField.setText(null);
						JOptionPane.showMessageDialog(null, "Increase amount must be more than 0.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					idField.setText(null);
					salField.setText(null);
					JOptionPane.showMessageDialog(null, "ID doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(391, 281, 108, 39);
		contentPane.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameIncrease.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(526, 281, 108, 39);
		contentPane.add(backButton);
	}
}