package oop_CW;

import javax.swing.JPanel;

@SuppressWarnings("serial")


public class ImagePanel extends JPanel{
	private ImageComponent img;
	
	public ImagePanel(){
		this.img = new ImageComponent();
		this.add(img);
	}

	public ImageComponent getImageComponent() {return this.img;}
}
