package oop_CW;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")


public class ImageDemo extends JFrame {
	
	ImagePanel panel = new ImagePanel();
	ImageComponent cmp = panel.getImageComponent();
	Button btn = new Button(cmp);
	Checkbox check = new Checkbox(cmp);
	
    public ImageDemo() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Custom component");
        
        setMinimumSize(new Dimension(400, 110));
        setPreferredSize(new Dimension(400, 110));
        
        add(check, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }

    public static void launch() {
        new ImageDemo();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> launch());
    }
}


