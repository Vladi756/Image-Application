package oop_CW;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Button extends JPanel{
	private JButton btn = new JButton("Open");
	private JFileChooser fc = new JFileChooser();
	private ImageComponent imgCmp;
	
	public Button (ImageComponent imgCmp) {
		this.imgCmp = imgCmp;
		this.add(this.btn);
		this.btn.addActionListener((ev) -> changeFile(fc));
	}
	
	public String getPath(JFileChooser fc) {
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			String filePath = fc.getSelectedFile().getAbsolutePath();
			return filePath;
		} else {
			String s = "No Selection";
			return s;
		}
	}
	
	public File changeFile(JFileChooser fc) {
		File file = new File(this.getPath(fc));
		this.imgCmp.updateImage(file);
		this.imgCmp.setImageName(fc.getSelectedFile().getName());
		this.imgCmp.setImagePath(fc.getSelectedFile().getAbsolutePath());
		return file;
	}
}
