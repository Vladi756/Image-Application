package oop_CW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")


public class Checkbox extends JPanel {
	JCheckBox ch1 = new JCheckBox("Name");
	JCheckBox ch2 = new JCheckBox("Path");
	JCheckBox ch3 = new JCheckBox("Size");
	JCheckBox ch4 = new JCheckBox("Date");
	JCheckBox ch5 = new JCheckBox("Dimensions");

	private ImageComponent imgCmp;
	
	public Checkbox(ImageComponent img) {
		this.imgCmp = img;
		CheckboxListener checkListener = new CheckboxListener(imgCmp);
		this.add(ch1);
		ch1.addActionListener(checkListener);
		this.add(ch2);
		ch2.addActionListener(checkListener);
		this.add(ch3);
		ch3.addActionListener(checkListener);
		this.add(ch4);
		ch4.addActionListener(checkListener);
		this.add(ch5);
		ch5.addActionListener(checkListener);
	}

	public class CheckboxListener implements ActionListener {
		
		private Graphics g;
		private ImageComponent imgCmp;
		private boolean ch1Flag;
		private boolean ch2Flag;
		private boolean ch3Flag;
		private boolean ch4Flag;
		private boolean ch5Flag;
		
		public CheckboxListener(ImageComponent imgCmp) {
			this.imgCmp = imgCmp;
			this.ch1Flag = false;
			this.ch2Flag = false;
			this.ch3Flag = false;
			this.ch4Flag = false;
			this.ch5Flag = false;
		}
		
		public void checkFlag() {
			if(this.ch1Flag) {
				this.g = this.imgCmp.img.getGraphics();			
				this.g.setColor(Color.CYAN);
				this.g.setFont(g.getFont().deriveFont(20f));
				this.g.drawString("Name: " + this.imgCmp.getImageName(), 10, 20);
				this.imgCmp.repaint();
			}
			if(this.ch2Flag) {
				this.g = this.imgCmp.img.getGraphics();
				this.g.setColor(Color.CYAN);
				this.g.setFont(g.getFont().deriveFont(20f));
				this.g.drawString("Path: " + this.imgCmp.getImagePath(), 10, 40);
				this.imgCmp.repaint();
			}
			if(this.ch3Flag) {
				this.g = this.imgCmp.img.getGraphics();
				this.g.setColor(Color.CYAN);
				this.g.setFont(g.getFont().deriveFont(20f));
				this.g.drawString("Size: " + this.imgCmp.getImageSize() + " bytes", 10, 60);
				this.imgCmp.repaint();
			}
			if(this.ch4Flag) {
				try {
					this.g = this.imgCmp.img.getGraphics();
					this.g.setColor(Color.CYAN);
					this.g.setFont(g.getFont().deriveFont(20f));
					this.g.drawString("Date: " + this.imgCmp.getImageDate(), 10, 80);
					this.imgCmp.repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
			if(this.ch5Flag) {
				Dimension imageDimension = this.imgCmp.getImageDimension();
				this.g = this.imgCmp.img.getGraphics();
				this.g.setColor(Color.CYAN);
				this.g.setFont(g.getFont().deriveFont(20f));
				this.g.drawString("Dimension: " + imageDimension.width + "x" + imageDimension.height, 10, 100);
				this.imgCmp.repaint();
			} 
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JCheckBox checkbox = (JCheckBox) e.getSource();
			if(this.imgCmp.img != null) {
				if(checkbox == ch1) {
					if (ch1.isSelected()) {	
						ch1Flag = true;
						g = this.imgCmp.getGraphics();			
						g.setColor(Color.CYAN);
						g.setFont(g.getFont().deriveFont(20f));
						g.drawString("Name: " + this.imgCmp.getImageName(), 10, 20);
					} else {
						ch1Flag = false;
						this.imgCmp.updateImage(new File(this.imgCmp.getImagePath()));
						checkFlag();
					}
				} else if(checkbox == ch2) {
					if (ch2.isSelected()) {
						ch2Flag = true;
						g = this.imgCmp.getGraphics();
						g.setColor(Color.CYAN);
						g.setFont(g.getFont().deriveFont(20f));
						g.drawString("Path: " + this.imgCmp.getImagePath(), 10, 40);
					} else {
						ch2Flag = false;
						this.imgCmp.updateImage(new File(this.imgCmp.getImagePath()));
						checkFlag();
					}
				} else if(checkbox == ch3) {
					if(ch3.isSelected()) {
						ch3Flag = true;
						g = this.imgCmp.getGraphics();
						g.setColor(Color.CYAN);
						g.setFont(g.getFont().deriveFont(20f));
						g.drawString("Size: " + this.imgCmp.getImageSize() + " bytes", 10, 60);
					} else {
						this.ch3Flag = false;
						this.imgCmp.updateImage(new File(this.imgCmp.getImagePath()));
						checkFlag();
					}
				} else if(checkbox == ch4) {
					if(ch4.isSelected()) {
						try {
							ch4Flag = true;
							g = this.imgCmp.getGraphics();
							g.setColor(Color.CYAN);
							g.setFont(g.getFont().deriveFont(20f));
							g.drawString("Date: " + this.imgCmp.getImageDate(), 10, 80);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						ch4Flag = false;
						this.imgCmp.updateImage(new File(this.imgCmp.getImagePath()));
						checkFlag();
					}
				} else if(checkbox == ch5) {
					if(ch5.isSelected()) {
						ch5Flag = true;
						Dimension imageDimension = this.imgCmp.getImageDimension();
						g = this.imgCmp.getGraphics();
						g.setColor(Color.CYAN);
						g.setFont(g.getFont().deriveFont(20f));
						g.drawString("Dimension: " + imageDimension.width + "x" + imageDimension.height, 10, 100);
					} else {
						ch5Flag = false;
						this.imgCmp.updateImage(new File(this.imgCmp.getImagePath()));
						checkFlag();
					}
				}
			}
		}
	}
}
