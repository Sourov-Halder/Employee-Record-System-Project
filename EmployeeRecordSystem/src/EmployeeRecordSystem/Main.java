package EmployeeRecordSystem;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.DefaultListModel;

public class Main {

	static FrameHome fhome = new FrameHome();
	static FrameMenu fmenu = new FrameMenu();
	static FrameAdd fadd = new FrameAdd();
	static FrameSalaried fsal = new FrameSalaried();
	static FrameHourly fhourly = new FrameHourly();
	static FrameCommission fcom = new FrameCommission();
	static FrameGetSal fget = new FrameGetSal();
	static FrameIncrease finc = new FrameIncrease();
	static FrameDisplay fdis = new FrameDisplay();
	static UapCSE uap = null;
	static DefaultListModel<String> employees = new DefaultListModel<String>();
	static String fileName = "data.txt";

	public static void main(String[] args) {
		fhome.setVisible(true);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			uap = (UapCSE) ois.readObject();
		} catch (Exception e) {
			uap = new UapCSE();
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
				System.out.println("No data available.");
			}
		}
	}
}