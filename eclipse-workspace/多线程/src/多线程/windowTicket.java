package 多线程;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class windowTicket extends JFrame implements Runnable,ActionListener{
	sellTicket ticketAgent;
	Thread 张平,李明,赵某;
	static JTextArea text;
	JButton startBuy=new JButton("开始买票");
	windowTicket(){
		ticketAgent=new sellTicket();
		张平=new Thread(this);
		张平.setName("张平");
		李明=new Thread(this);
		李明.setName("李明");
		赵某=new Thread(this);
		赵某.setName("赵某");
		text=new JTextArea(10,30);
		startBuy.addActionListener(this);
		add(text,BorderLayout.CENTER);
		add(startBuy,BorderLayout.NORTH);
		setVisible(true);
		setSize(360,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		try {
			张平.start();
			李明.start();
			赵某.start();
		}
		catch(Exception exp) {}
	}
	public void run() {
		if(Thread.currentThread()==张平) {
			ticketAgent.售票规则(20);
		}
		else if(Thread.currentThread()==李明) {
			ticketAgent.售票规则(10);
		}
		else if(Thread.currentThread()==赵某) {
			ticketAgent.售票规则(5);
		}
	}

}
