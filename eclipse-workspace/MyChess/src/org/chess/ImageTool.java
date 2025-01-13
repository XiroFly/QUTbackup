package org.chess;
import java.awt.Image;
import javax.swing.ImageIcon;
public class ImageTool {
	public static Image loadImage(String path){
		try {
			ImageIcon im = new ImageIcon("image\\"+path);
			return im.getImage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		ImageIcon im=new ImageIcon("image\\main.gif");
		System.out.println(im);
	}
}
