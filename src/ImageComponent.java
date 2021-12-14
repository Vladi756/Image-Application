package oop_CW;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")


public class ImageComponent extends JComponent {
	public BufferedImage img;
	private BasicFileAttributes metadata;
	private String name;
	private String imagePath;
	private Dimension imageDimension;
	private long size;
	private FileTime date;
	
	public ImageComponent() {
		setMinimumSize(new Dimension(400, 110));
	}
	
	public void updateImage(File img) {
		try {
			this.img = ImageIO.read(img);
			Dimension size = new Dimension(this.img.getWidth(), this.img.getHeight());
			this.imageDimension = size;
			this.size = img.length();
			this.setMinimumSize(size);
			this.setPreferredSize(size);
			JFrame masterFrame = (JFrame) JFrame.getFrames()[0];
			masterFrame.setSize(new Dimension(this.img.getWidth(), this.img.getHeight() + 115));
			repaint();
		} catch(IOException x) {
			x.printStackTrace();
		}
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int margin = 0;
		int w = getWidth();
		int h = getHeight();
		
		g.drawImage(this.img, margin, margin, w, h, this);
		
	}
	
	// GETTERS // 
	public String getImageName() {return this.name;}
	
	public String getImagePath() {return this.imagePath;}
	
	public long getImageSize() {return this.size;}
	
	public Dimension getImageDimension() {return this.imageDimension;}
	
	public FileTime getImageDate() throws IOException {
		Path file = Paths.get(this.getImagePath());
		this.metadata = Files.readAttributes(file, BasicFileAttributes.class);
		this.date = this.metadata.creationTime();
		return this.date;
	}
	
	
	// SETTERS // 
	
	public void setImageName(String n) {this.name = n;}
	public void setImagePath(String p) {this.imagePath = p;}
}