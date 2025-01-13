package 实验课程;

import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class Window extends JFrame implements ItemListener,ActionListener {
		JTextField txt1,txt2;
		JCheckBox box1,box2,box3,box4;
		JButton btn1,btn2,btn3;
		EnglishTest et;JTextField ans;
		String str;int upline;int k=1;
		Window(){
			String line = "";
			int i = 0;
			try {
				FileReader fr = new FileReader("D:\\English.txt");
				BufferedReader br = new BufferedReader(fr);
				
				try {
					while((line=br.readLine()) != null){i++;}
					upline = i;
					br.close();
					} catch (IOException e) {
					e.printStackTrace();
					}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			et=new EnglishTest();et.getAnswer(1);
			setLayout(new java.awt.FlowLayout());
			//setBounds(100,100,500,500);
			setTitle("英语单词训练");
			txt1=new JTextField(25);txt2=new JTextField(10);txt1.setText(et.choose[0]);
			box1=new JCheckBox(et.choose[1]);box2=new JCheckBox(et.choose[2]);box3=new JCheckBox(et.choose[3]);box4=new JCheckBox(et.choose[4]);
			btn1=new JButton("下一题目");	btn2=new JButton("重新训练");btn3=new JButton("确定");ans = new JTextField(10);
			box1.addItemListener(this);
			box2.addItemListener(this);
			box3.addItemListener(this);
			box4.addItemListener(this);
			btn3.addActionListener(this);
			btn1.addActionListener(this);
			btn2.addActionListener(this);
			add(txt1);add(box1);add(box2);add(box3);add(box4);add(btn3);add(btn1);add(btn2);add(txt2);add(ans);
			pack();
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sign=e.getActionCommand();
				if(sign.equals("下一题目")&&k!=upline) {
					if(et.choose[0].equals("ended")) {
						ans.setText("练习已完成");
					}
					else {
						k++;
						et.getAnswer(k);
						txt1.setText(et.choose[0]);
						box1.setText(et.choose[1]);
						box2.setText(et.choose[2]);
						box3.setText(et.choose[3]);
						box4.setText(et.choose[4]);
						validate();repaint();
					}
				}
				else if(sign.equals("下一题目")&&k==upline){
					k=1;
					ans.setText("练习已完成");
				}
				if(sign.equals("重新训练")) {
					et.getAnswer(1);
					txt1.setText(et.choose[0]);
					box1.setText(et.choose[1]);
					box2.setText(et.choose[2]);
					box3.setText(et.choose[3]);
					box4.setText(et.choose[4]);
					validate();
					repaint();
				}
				if(sign.equals("确定"))
				{
					int note = 0;
					if(box1.isSelected())
					{
						note++;
					}
					else if(box2.isSelected())
					{
						note++;
					}
					else if(box3.isSelected())
					{
						note++;
					}
					else if(box4.isSelected())
					{
						note++;
					}
					
					if(note==1)
					{
						if(str.equals(et.choose[5]))
						{
							txt2.setText("1分");
						}
						else
						{
							txt2.setText("0分");
						}
					}
			}
		}
	

				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					if(box1.isSelected())str=box1.getText();
					if(box2.isSelected())str=box2.getText();
					if(box3.isSelected())str=box3.getText();
					if(box4.isSelected())str=box4.getText();
				}
			

}
