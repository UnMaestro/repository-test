package com.odifn.core;

import javax.swing.UIManager;

import com.odfin.gui.MainFrame;

public class EmployeeApp {

	public static void main(String[] args) {
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (Exception e) {}	
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

}
