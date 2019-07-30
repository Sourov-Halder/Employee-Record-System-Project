package EmployeeRecordSystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.Toolkit;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameSalaried extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField desigField;
	private JTextField salaryField;

	/**
	 * @author Sourov Halder
	 */
	public FrameSalaried() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameSalaried.class.getResource("/images/main-icon.png")));
		setTitle("Salaried Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("Note: Fill up the form properly to add a new Salaried Employee.");
		headerLabel.setForeground(Color.RED);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		headerLabel.setBounds(12, 95, 928, 39);
		contentPane.add(headerLabel);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(221, 165, 144, 34);
		contentPane.add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameField.setBounds(387, 164, 265, 37);
		contentPane.add(nameField);
		nameField.setColumns(10);

		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		idLabel.setBounds(221, 215, 144, 34);
		contentPane.add(idLabel);

		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idField.setBounds(387, 214, 265, 37);
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel desigLabel = new JLabel("Designation");
		desigLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		desigLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		desigLabel.setBounds(221, 264, 144, 37);
		contentPane.add(desigLabel);

		desigField = new JTextField();
		desigField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		desigField.setBounds(387, 264, 265, 37);
		contentPane.add(desigField);
		desigField.setColumns(10);

		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		salaryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		salaryLabel.setBounds(221, 314, 144, 37);
		contentPane.add(salaryLabel);

		salaryField = new JTextField();
		salaryField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		salaryField.setBounds(387, 314, 265, 37);
		contentPane.add(salaryField);
		salaryField.setColumns(10);

		JButton OKButton = new JButton(" OK");
		OKButton.setIcon(new ImageIcon(FrameSalaried.class.getResource("/images/icon-5.png")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String id = idField.getText();
				String des = desigField.getText();
				double sal = Double.parseDouble(salaryField.getText());

				if (Main.uap.findEmployee(id) == null) {
					if (sal > 0) {
						Main.uap.addNewEmployee(name, id, des, sal);
						nameField.setText(null);
						idField.setText(null);
						desigField.setText(null);
						salaryField.setText(null);
						JOptionPane.showMessageDialog(null, "Added Successfully.");
						ObjectOutputStream oos = null;
						try {
							oos = new ObjectOutputStream(new FileOutputStream(Main.fileName));
							oos.writeObject(Main.uap);
						} catch (Exception f) {
							System.out.print("");
						}
					} else {
						nameField.setText(null);
						idField.setText(null);
						desigField.setText(null);
						salaryField.setText(null);
						JOptionPane.showMessageDialog(null, "Salary must be more than 0.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					nameField.setText(null);
					idField.setText(null);
					desigField.setText(null);
					salaryField.setText(null);
					JOptionPane.showMessageDialog(null, "ID is not available.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(397, 376, 111, 39);
		contentPane.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameSalaried.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fadd.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(531, 376, 111, 39);
		contentPane.add(backButton);
		setLocationRelativeTo(null);
	}
}