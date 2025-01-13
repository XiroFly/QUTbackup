package 实验;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class Text {
	public static  void main(String[] args) {
	  JFrame frame=new JFrame();
	  var button= new JButton("sjid");
	  var text= new JTextField(10);
	  frame.add(text);
	  button.addActionListener(new Listener(text));
	  frame.add(button);
	  frame.pack();
	  frame.setSize(200,200);
	  frame.setVisible(true);
	   }
}
class Listener implements ActionListener{
    JTextField field;
	
	Listener(JTextField a){
		field=a;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		System.out.print(field.getText()+"a");
	}
	
}