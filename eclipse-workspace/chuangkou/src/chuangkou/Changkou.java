package chuangkou;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.regex.*;
/*实验名称：《实验五 Java Swing的应用》
时间：2022.5.11
实验地点：信控楼406+412机房
实验目的及要求：掌握窗体、常用组件、容器的创建与使用，掌握设置容器常用的布局方式。重点掌握组件的事件处理。
实验内容：
1、 编写应用程序，有一个标题为“计算”的窗口，窗口的布局为FlowLayout布局。在窗口中添加两个文本区，当用户在一个文本区中输入若干个数时
（用空格、逗号或任意非数字字符分隔），另一个文本区同时对输入的数进行求和运算并求出平均值，也就是说随着用户输入的变化，另一个文本区不断地更新求和及平均值。
2、 编写一个应用程序，有一个标题为“计算”的窗口，窗口的布局为FlowLayout布局。设计四个按钮，分别命名为加、减、乘、除，另外，窗口中还有3个文本框。
单击相应的按钮，将两个文本框的数字做运算，在第三个文本框中显示结果。要求处理NumberFormatException。
*/
public class Changkou {
   public static void main (String args[]) {
	 var frame1=new  calculationframe ();
	 var frame2=new frame();
		
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
   
   

	
   


