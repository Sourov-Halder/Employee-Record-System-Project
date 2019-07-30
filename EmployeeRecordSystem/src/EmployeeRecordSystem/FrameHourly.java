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
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameHourly extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField desigField;
	private JTextField hourlyRateField;
	private JTextField workingHourField;

	/**
	 * @author Sourov Halder
	 */
	public FrameHourly() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameHourly.class.getResource("/images/main-icon.png")));
		setTitle("Hourly Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("Note: Fill up the form properly to add a new Hourly Employee.");
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

		JLabel hourlyRateLabel = new JLabel("Hourly Rate ");
		hourlyRateLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		hourlyRateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hourlyRateLabel.setBounds(221, 314, 144, 37);
		contentPane.add(hourlyRateLabel);

		hourlyRateField = new JTextField();
		hourlyRateField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hourlyRateField.setBounds(387, 314, 265, 37);
		contentPane.add(hourlyRateField);
		hourlyRateField.setColumns(10);

		JLabel workingLabel = new JLabel("Working Hour");
		workingLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		workingLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		workingLabel.setBounds(221, 369, 144, 34);
		contentPane.add(workingLabel);

		workingHourField = new JTextField();
		workingHourField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		workingHourField.setBounds(387, 364, 265, 39);
		contentPane.add(workingHourField);
		workingHourField.setColumns(10);
		setLocationRelativeTo(null);

		JButton OKButton = new JButton(" OK");
		OKButton.setIcon(new ImageIcon(FrameHourly.class.getResource("/images/icon-5.png")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String id = idField.getText();
				String des = desigField.getText();
				double hr = Double.parseDouble(hourlyRateField.getText());
				int hw = Integer.parseInt(workingHourField.getText());

				if (Main.uap.findEmployee(id) == null) {
					if (hr > 0) {
						Main.uap.addNewEmployee(name, id, des, hr, hw);
						nameField.setText(null);
						idField.setText(null);
						desigField.setText(null);
						hourlyRateField.setText(null);
						workingHourField.setText(null);
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
						hourlyRateField.setText(null);
						workingHourField.setText(null);
						JOptionPane.showMessageDialog(null, "Hourly Rate must be more than 0.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					nameField.setText(null);
					idField.setText(null);
					desigField.setText(null);
					hourlyRateField.setText(null);
					workingHourField.setText(null);
					JOptionPane.showMessageDialog(null, "ID is not available.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(398, 430, 110, 39);
		contentPane.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameHourly.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fadd.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(531, 430, 110, 39);
		contentPane.add(backButton);
	}
}