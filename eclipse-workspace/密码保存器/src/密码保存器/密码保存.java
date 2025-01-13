package 密码保存器;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class 密码保存 {
	static String a="";static String b="";static String c="";//保存修改变量
    public   static  void main (String arg[]) {
    	var button= new JButton("登入");
    	Inframe frame=  new Inframe("添加");
    	 button.addActionListener(new listener(frame));
		  frame.label1.setText("账号");
		  frame.label2.setText("密码");
		  frame.field3.setVisible(false);
		  frame.field4.setVisible(false);
		  frame.label3.setText(null);
		  frame.label4.setText(null);
		  frame.button.setVisible(false);
		  frame.add(button,BorderLayout.SOUTH);
		 
		  frame.setVisible(true);
    }
}

class Outframe extends JFrame{
	JButton 添加 =new JButton ("添加");
	JButton 修改=new JButton ("修改");
	JButton 查询=new JButton("查询");
	Outframe(){
		
		this.setTitle("密码保存器");
		添加.addActionListener(new Outlistener("添加"));
		修改.addActionListener(new Outlistener("修改"));
		查询.addActionListener(new Outlistener("查询"));
		添加.setSize(20, 20);
		修改.setSize(20, 20);
		this.add(添加,BorderLayout.NORTH);
		this.add(修改,BorderLayout.CENTER );
		this.add(查询,BorderLayout.SOUTH);
		this.setBounds(500, 200, 200, 200);
		this.pack();
		this.setVisible(true);
		
	}
}
class Outlistener implements ActionListener{
	String a;
	Outlistener(String a){
		this.a=a;
	}
	public void actionPerformed(ActionEvent e) {
	  Inframe frame=new Inframe(a);
		if(a.equals("修改")) {
			frame.button.addActionListener(new Inxlistener(frame.field1,frame.field2, frame.field3));
		    frame.label3.setText("");	
		}
	frame.setVisible(true);
	}
}
class Inframe extends JFrame{
	JPanel panel=new JPanel();
	JLabel label1;JTextField field1 =new JTextField(20);
	JLabel label2;JTextField field2=new JTextField(20);
	JLabel label3;JTextField field3=new JTextField(20);
	JLabel label4;JTextField field4=new JTextField(20);
	JButton button =new JButton("确认");
	Inframe(String a){
		this.setTitle(a); 
        this.sets(a);
        button.setSize(20, 20);
        
		panel.setLayout(new GridLayout(4,2));
		panel.setSize(120, 80);
		panel.add(label1);panel.add(field1);
		panel.add(label2);panel.add(field2);
		panel.add(label3);panel.add(field3);
		panel.add(label4);panel.add(field4);
		this.add(panel);
		this.add(button,BorderLayout.SOUTH);
		this.setBounds(500, 200, 200, 200);
		this.pack();
		
	}
	
	void sets(String a) {
	if(a.equals("添加")) {
		label1=new JLabel("网址不能和已有的重复");
		label2=new JLabel("用户名");
		label3=new JLabel("输入密码");
		label4=new JLabel("再次输入密码");
		button.addActionListener(new InTlistener(field1,field2,field3,field4));
	}
    if(a.equals("查询")) {
		label1=new JLabel("备注（网址）");
		label2=new JLabel("用户名");
		label3=new JLabel("输入密码");
		label4=new JLabel(" ");
		field4.setText("输入你所能记起的所有信息");
		button.addActionListener(new InClistener(field1,field2,field3));
		}
   if(a.equals("修改")) {
	   label1=new JLabel("备注（网址）");
		label2=new JLabel("用户名");
		label3=new JLabel("输入密码");
		label4=new JLabel(" ");
		field4.setText("匹配账号信息都将修改");
		
   }
		
	
	}
	
}
class pop extends JFrame{
	JLabel label ;
	pop(String a){
		label =new JLabel(a);
		label.setSize(10, 50);
		this.add(label);
		this.pack();
		this.setBounds(500, 200, 200, 200);
		this.setVisible(true);
	}
}
class InTlistener implements ActionListener{//添加
    String  sql;JTextField field1;JTextField field2;JTextField field3;JTextField field4;
    String  备注;
    String  用户名;
    String  密码;
    
   InTlistener( JTextField field1,JTextField field2,JTextField field3,JTextField field4){
   this.field1=field1;
   this.field2=field2;
   this.field3=field3;
   this.field4=field4;
   }
	public void actionPerformed(ActionEvent e) {
		if(field3.getText().equals(field4.getText() )  ) {
			  备注= field1.getText();
			  用户名=field2.getText();
			  密码=field3.getText();
		   }
			   else  new pop("密码输入不一致");//弹窗;
			   
		if(备注!=null) {//网址为主键，不能为空。
			this.sql="INSERT INTO 个人密码   "+" VALUES (' ',  '"+用户名   +"', "+" '"+密码+"' , "+"'"+备注+"')"	;
			//	+"[ VALUES (' ',  ']"+用户名   +"[', ]"+"[ ']"+密码+"[' , ]"+"'"+备注+"')"	;
			linkdatabase(this.sql);
			new pop("success!"); //弹窗
		}
		
	}
	void linkdatabase(String sql) {
		
		try {
            Class.forName("com.hxtt.sql.access.AccessDriver");//导入Access驱动文件，本质是.class文件
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:Access:///D:\\Users\\fly\\eclipse-workspace\\Database2.accdb","","");
            //与数据库建立连接，getConnection()方法第一个参数为jdbc:Access:///+文件总路径,第二个参数是用户名，第三个参数是密码（Access是没有用户名和密码此处为空字符串）
            Statement sta = con.createStatement();
            	sta.executeUpdate(sql);
            	//有一个弹窗；
            
            
            con.close();//关闭数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }	
}
class InClistener implements ActionListener{//查询

	    String  sql;
	   
	    JTextField a;
	    JTextField b;
	    JTextField c;
	    JFrame frame=new JFrame();//文本区显示
	    JTextArea area=new JTextArea(100,100);
	    
	   InClistener( JTextField field1,JTextField field2,JTextField field3){
		   a=field1;b=field2;c=field3;
		  var panel= new JScrollPane(area); //添加滚动条
		   frame.add(panel);
		   frame.pack();
		   frame.setLocationByPlatform(true);
		  
	   } 
		public void actionPerformed(ActionEvent e) {
			    String  备注="";
			    String  用户名="";
			    String  密码="";
			 if(!a.getText().equals("")) {
				 if(!b.getText().equals("")||!c.getText().equals(""))
				   备注=" 备注（网址）  like "+"'%"+ a.getText()+"%'"+" and ";
				 else 备注= " 备注（网址）  like "+"'%"+a.getText()+"%'";
				   }
			 
				   if(!b.getText().equals("")) {
					   if(!c.getText().equals(""))
						  用户名=" 账号  like "+ "'"+b.getText()+"'"+" and ";
					   else   用户名= " 账号  like "+"'"+b.getText()+"'";
						  }
				   if(!c.getText().equals("")) {
						  密码=" 密码  = "+ "'"+c.getText()+"'";
				   }
				this.sql="SELECT *"+" FROM 个人密码 "+" WHERE "+备注+用户名+密码;
				linkdatabase(this.sql);//连接数据库
				frame.setVisible(true);
			}
			
		
		void linkdatabase(String sql) {//model=查询
			
			try {
	            Class.forName("com.hxtt.sql.access.AccessDriver");//导入Access驱动文件，本质是.class文件
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            Connection con = DriverManager.getConnection("jdbc:Access:///D:\\Users\\fly\\eclipse-workspace\\Database2.accdb","","");
	            //与数据库建立连接，getConnection()方法第一个参数为jdbc:Access:///+文件总路径,第二个参数是用户名，第三个参数是密码（Access是没有用户名和密码此处为空字符串）
	            Statement sta = con.createStatement();//不敏感，不更新
	            	ResultSet res = sta.executeQuery(sql);
	            	while(res.next()){
	            	 String a= res.getString(1);
	            	 String b=res.getString(3);
	            	 var c=res.getString(4);
	            	 area.append("备注（网址）"+a);
	            	 area.append("账号"+b);
	            	 area.append("密码"+c);
	            	 area.append(""+'\n');
	            	}
	               
	               
	            	con.close();//关闭数据库连接
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }	
}
class Inerlistener implements ActionListener{//修改，一定知道账号
	String e;                                                                                                                                                                     ;
	String f;
	String g;
	String sql;
	JTextField a;
    JTextField b;
    JTextField c;
    
	Inerlistener (JTextField ...t){
		this.a=t[0];
   	 this.b=t[1];
   	 this.c=t[2];
	}
	public void actionPerformed(ActionEvent e) {
		if(!a.getText().equals(""))
			this.e= a.getText();
			if(!b.getText().equals(""))
			f=b.getText();
			if(!c.getText().equals("")) {
				g=c.getText();
			}
		this.sql="SELECT *"+" FROM 个人密码"+" WHERE "+密码保存.a+密码保存.b+密码保存.c;
		linkdatabasein(this.sql,this.e,f,g);
		new pop("success!");//提示弹窗
		密码保存.a="";密码保存.b="";//储存归零，以便下次定位
	}
void linkdatabasein(String sql,String a,String b,String c) {
		
		try {
            Class.forName("com.hxtt.sql.access.AccessDriver");//导入Access驱动文件，本质是.class文件
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:Access:///D:\\Users\\fly\\eclipse-workspace\\Database2.accdb","","");
            //与数据库建立连接，getConnection()方法第一个参数为jdbc:Access:///+文件总路径,第二个参数是用户名，第三个参数是密码（Access是没有用户名和密码此处为空字符串）
            Statement sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            	ResultSet res=  sta.executeQuery(sql);
            	
            	while(res.next()) {
            		if(b!=null)
            		res.updateString(2, b);//3账号
            		if(c!=null)
            			res.updateString(3, c);//4密码
            		if(a!=null)
            			res.updateString(4, a);//1备注
            		res.updateRow();
            		if(a==null&&b==null&&c==null)
            			res.deleteRow();
            	}
            con.close();//关闭数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}	
class Inxlistener implements ActionListener{//获取字符串用于定位
       JTextField a;
       JTextField b;
       JTextField c;
     Inxlistener( JTextField a0,JTextField a1,JTextField a2){
    	 this.a=a0;
    	 this.b=a1;
    	 this.c=a2;
    	 this.c.setVisible(false);//3不可见
     }
	public void actionPerformed(ActionEvent e) {
		 if(!a.getText().equals("")) {
			 if(!b.getText().equals("")||!c.getText().equals(""))
			   密码保存.a=" 备注（网址）  = "+"'"+ a.getText()+"'"+" and ";
			 else 密码保存.a= " 备注（网址）  = "+"'"+a.getText()+"'";
			   }
		 
			   if(!b.getText().equals("")) {
				   if(!c.getText().equals(""))
					 密码保存.b=" 账号  = "+ "'"+b.getText()+"'"+" and ";
				   else   密码保存.b= " 账号  = "+"'"+b.getText()+"'";
					  }
		Inframe inerframe=new Inframe("修改");//弹出第三层窗口
		inerframe.field4.setText("匹配账号都将修改，全为空则删除");
		inerframe.button.addActionListener(new Inerlistener(inerframe.field1,inerframe.field2,inerframe.field3));
		 inerframe.setVisible(true);
	}
	
}	

	 
	  
class listener implements ActionListener{//登入界面
	String a,b;
	Inframe frame;
	listener (Inframe frame){
		this.frame=frame;
		
	}
	public void actionPerformed(ActionEvent e) {
		this.a=frame.field1.getText();
		this.b=frame.field2.getText();
		// TODO 自动生成的方法存根
		try {
          Class.forName("com.hxtt.sql.access.AccessDriver");
      } catch (ClassNotFoundException a) {
          a.printStackTrace();
      }
      try {
          Connection con = DriverManager.getConnection("jdbc:Access:///D:\\Users\\fly\\eclipse-workspace\\Database2.accdb","","");
          Statement sta = con.createStatement();//不敏感，不更新
          String sql="select * from 程序  ";
          ResultSet res = sta.executeQuery(sql);
      	res.next();
      	 if(a.equals( res.getString(2))&&b.equals(res.getString(3)))
      		 new Outframe();
      	 else {
      		 new pop("账号或密码错误");
      		 System.out.println(a);
      	 }
      	 }
      	
      	 catch (SQLException e1) {
               e1.printStackTrace();
           }
	}
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	


