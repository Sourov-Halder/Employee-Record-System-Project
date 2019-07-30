package EmployeeRecordSystem;

import java.awt.Font;
import java.awt.Toolkit;
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
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameCommission extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField idField;
	private JTextField desigField;
	private JTextField comField;
	private JTextField saleField;

	/**
	 * @author Sourov Halder
	 */
	public FrameCommission() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCommission.class.getResource("/images/main-icon.png")));
		setTitle("Commission Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("Note: Fill up the form properly to add a new Commission Employee.");
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

		JLabel comLabel = new JLabel("Commission");
		comLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		comLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		comLabel.setBounds(221, 314, 144, 37);
		contentPane.add(comLabel);

		comField = new JTextField();
		comField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comField.setBounds(387, 314, 265, 37);
		contentPane.add(comField);
		comField.setColumns(10);

		JLabel saleLabel = new JLabel("Sales no.");
		saleLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		saleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		saleLabel.setBounds(221, 369, 144, 34);
		contentPane.add(saleLabel);

		saleField = new JTextField();
		saleField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saleField.setBounds(387, 364, 265, 39);
		contentPane.add(saleField);
		saleField.setColumns(10);
		setLocationRelativeTo(null);

		JButton OKButton = new JButton(" OK");
		OKButton.setIcon(new ImageIcon(FrameCommission.class.getResource("/images/icon-5.png")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String id = idField.getText();
				String des = desigField.getText();
				double com = Double.parseDouble(comField.getText());
				double sale = Double.parseDouble(saleField.getText());

				if (Main.uap.findEmployee(id) == null) {
					if (com > 0) {
						Main.uap.addNewEmployee(name, id, des, com, sale);
						nameField.setText(null);
						idField.setText(null);
						desigField.setText(null);
						comField.setText(null);
						saleField.setText(null);
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
						comField.setText(null);
						saleField.setText(null);
						JOptionPane.showMessageDialog(null, "Commission must be more than 0.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					nameField.setText(null);
					idField.setText(null);
					desigField.setText(null);
					comField.setText(null);
					saleField.setText(null);
					JOptionPane.showMessageDialog(null, "ID is not available.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(399, 430, 109, 39);
		contentPane.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameCommission.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fadd.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(531, 430, 109, 39);
		contentPane.add(backButton);
	}
}