import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.chess.musicStuff;
/*2020-第一组-中国象棋项目分工
 * 姜权罡（组长）：炮、马、架构、图形化界面、视频讲解、报告（结构和代码和总结）、
 * 			PPT代码和总结反思部分、所有工作的审核。
 * 
 * 庞义俊：车、音乐、图片搜集、绘制结构图。
 * 董玟彤：象、PPT。
 * 李若彤：将、士、PPT。
 * 曹佳榕：卒、PPT、报告（项目介绍）
 * 
 * 2020/12/22 所有工作全部完成！
 * */
public class ChessGame {
	public static void main(String[] args) {
		JFrame f =new JFrame("中国象棋：观棋不语真君子，棋死无悔大丈夫");
		ImageIcon icon = new ImageIcon("image\\红将.gif");
		f.setIconImage(icon.getImage());
		
		f.setSize(730,750);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout());//学习一下BorderLayout()布局管理器，把按钮放进去。
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Canvas c=  new Canvas();
		f.add(c);
		
		JButton newStartGame = new JButton("新游戏"); 
		JButton startMusic = new JButton("播放音乐");
		JButton ExitGame = new JButton("退出游戏");
		
		//为新游戏按钮  添加事件
		newStartGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.initMap();//新游戏
				c.repaint();//新游戏后，出棋先后顺序互换
				c.select_c = -1;
				c.select_r = -1;
				c.isBlack=!c.isBlack;
				//System.out.println("点击\n");
			}
		});
		
		//为退出按钮  添加事件
		ExitGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int j=JOptionPane.showConfirmDialog(null, "真的要退出吗？","退出",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(j==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		
		//为音乐播放按钮  添加事件
		startMusic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String filepath = "music\\music.wav";
				musicStuff musicObject = new musicStuff();
				musicObject.playMusic(filepath);//音乐播放
			}
			
		});
		//f.setIconImage(new ImageIcon("红将.gif").getImage());
		f.add(newStartGame,BorderLayout.WEST);
		f.add(startMusic,BorderLayout.EAST);
		f.add(ExitGame,BorderLayout.SOUTH);
		f.setVisible(true);
	}
}