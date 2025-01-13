package chuangkou;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.regex.*;

public class Changkou {
   public static void main (String args[]) {
	new  calculationframe ();
	 new frame();
		
   }
}
   class calculationframe extends JFrame{
	   Toolkit tool=Toolkit.getDefaultToolkit();
	   Dimension screen=tool.getScreenSize();
	   JPanel pan =new JPanel();
	   JTextArea area1=new JTextArea(20,20);
	   JTextArea area2=new JTextArea(20,20);
	    
        
	   calculationframe(){
		 this.setTitle("计算");
		 this.setBounds(screen.height/4,screen.width/4,screen.height/2,screen.width/4);
		 var listener= new DocuListener(this);
		   area1.getDocument().addDocumentListener(listener);
	        pan.add(area1);
	        pan.add(area2);
	        this.add(pan);
		 this.setVisible(true);
	   }
	  
   }
   class DocuListener implements DocumentListener{
	   calculationframe frame;
	   DocuListener(calculationframe frame) {
		   this.frame=frame;
	   }
	   public void changedUpdate(DocumentEvent e) {
		   String a=frame.area1.getText();
		   String str[]=a.split("[^0-9.]+");//首项必须为数字否则首项为空串；
		   double x[]=new double[str.length];
		   double sum=0;
		   for(int i=0;i<str.length;i++) {
			  x[i]=Double.parseDouble(str[i]) ;
			 sum+=x[i];
		   }
		   frame.area2.setText(null);
		   frame.area2.append("总和:"+sum);
		   frame.area2.append("平均："+sum/(x.length));
		   
	   }
	   public void removeUpdate(DocumentEvent e) {
		   changedUpdate(e);
	   }
	   public void insertUpdate(DocumentEvent e) {
		   changedUpdate(e);
	   }
   }
   class frame extends JFrame{
	   Toolkit tool=Toolkit.getDefaultToolkit();
	   Dimension size=tool.getScreenSize();
	   JRadioButton button1=new JRadioButton("+");
	   JRadioButton button2=new JRadioButton("-");
	   JRadioButton button3=new JRadioButton("*");
	   JRadioButton button4=new JRadioButton("/");
	   ButtonGroup   group=new ButtonGroup();
	   JPanel right=new JPanel();
	   JPanel left=new JPanel();
	   JTextField s1=new  JTextField(20);
	   JTextField s2=new  JTextField(20);
	   JTextField r1=new  JTextField(20);
	   frame(){
		  this.setTitle("计算");
		 this.setBounds(size.height/3, size.width/4, size.height/2, size.width/2);
		this.setLayout(new FlowLayout());
		set();
		
		this.setVisible(true);
		
	   }
	   void set() {
		                             
		
		group.add(button1);
		group.add(button2);
		group.add(button3);
		group.add(button4);
		right.setLayout(new GridLayout(2,2));
		right.add(button1);
		right.add(button2);
		right.add(button3);
		right.add(button4);
		left.add(s1);
		left.add(s2);
		left.add(r1);
		this.add(left);
		this.add(right);
		button1.addActionListener(new ButtonListener(this,"+"));
		button2.addActionListener(new ButtonListener(this,"-"));
		button3.addActionListener(new ButtonListener(this,"*"));
		button4.addActionListener(new ButtonListener(this,"/"));
	   }
	   
   }
   class  ButtonListener implements ActionListener{
	   frame frame;
	   String a;
	   ButtonListener(frame frame,String str){
		   this.frame=frame;
		  this.a=str;
		  
	   }
	   
	   public void actionPerformed(ActionEvent e) {
		try {
			double x=Double.parseDouble(frame.s1.getText())  ;
		
		double y=Double.parseDouble(frame.s2.getText());
		double result=0;
		   switch(a) {
		   case "+":
			   result=x+y;break;
		   case"-":
			   result=x-y;break;
		   case"*":
			   result=x*y;break;
		   case"/":
			   result=x/y;break;
		   }
		   frame.r1.setText(""+result);
		   }
		catch(NumberFormatException ex){
		frame.r1.setText("请输入数字");
		}
	}
   }
   
   

	
   


