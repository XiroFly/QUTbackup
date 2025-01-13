import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.xml.bind.Marshaller.Listener;

import org.chess.Chess;
import org.chess.ImageTool;
import org.chess.RangeChecker;

import sun.tools.jar.resources.jar;

import com.sun.org.apache.bcel.internal.generic.NEW;
public class Canvas extends JPanel {
	public static final int row=10;//棋盘行数
	public static final int line=9;//棋盘列数
	int[][] map = new int[row][line];
	JLabel Icon;
	Image chessimage = null;
	Font  font;
	public static final int BLACK = 1000;
	public static final int WHITE = 0;
	
	boolean isBlack = false; //当前是谁下子
	int select_c = -1;
	int select_r = -1;
	
	public Canvas(){//棋盘为10行9列，默认就好，不用改
		//chessimage = new ImageIcon("黑车.gif").getImage();
		font = new Font("宋体",Font.BOLD,30);
		initMap();
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				//super.mouseClicked(e);
				//System.out.println(e.getButton());
				if(e.getButton()==MouseEvent.BUTTON1){
					int x = e.getX();
					int y = e.getY();
					//System.out.println(e.getX()+","+e.getY()+"["+x+","+y+"]");
					int r = (y - 25) /58;
					int c = (x - 25) /58;
					//System.out.println("r = "+r+", c = "+c);
					//选子
					if(select_c == -1&&map[r][c]!=0){
						if(RangeChecker.selectInRange(map,r,c,isBlack)){//isBlack 是 红方
							select_c = c;
							select_r = r;
							repaint();
						}
						else{
							showFail("请选择己方棋子");
						}
						return ;// 选子阶段结束
					}
					
					boolean valid  = RangeChecker.inRange(map, select_r,select_c,r, c, isBlack);
					if(!valid){
						showFail("下子失败");
					}
					
					Chess chess = manager.getTheChess(map[select_r][select_c]);
					valid = chess.check(map, select_r, select_c, r, c, isBlack);
					if(!valid||(map[select_r][select_c]<1000&&map[r][c]<1000&&map[r][c]!=0)||(map[select_r][select_c]>1000&&map[r][c]>1000&&map[r][c]!=0)){
						showFail("下子失败,规则不允许");
						select_c = -1;
						select_r = -1;
						repaint();
						return ;
					}
					
					map[r][c] = map[select_r][select_c ];
					map[select_r][select_c ] = 0; 
					select_c = -1;
					select_r = -1;
					
					isBlack = !isBlack;//对方来下
					repaint();
				}
			}
		});
	}
	protected void showFail(String msg) {
		System.out.println(msg);
	}
	ChessManager manager = new ChessManager();
	private Image mainGif;
	public void initMap(){
		int c=0;
		int i,k;
		map=new int [][]{{1000+'C',1000+'H',1000+'E',1000+'S',1000+'G',1000+'S',1000+'E',1000+'H',1000+'C'}, {0,0,0,0,0,0,0,0,0,},
				{0,1000+'P',0,0,0,0,0,1000+'P',0},{1000+'A',0,1000+'A',0,1000+'A',0,1000+'A',0,1000+'A'},
				{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
				{'A',0,'A',0,'A',0,'A',0,'A'},{0,'P',0,0,0,0,0,'P',0},
				{0,0,0,0,0,0,0,0,0},{'C','H','E','S','G','S','E','H','C'}};
		//System.out.println(map[9][4]);
		mainGif = ImageTool.loadImage("main.gif");
		manager.loadAllImage();
	}
	
	//内部类
	public static class MyPoint{
		public int r;
		public int c;
		public MyPoint(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	int pw = 60;
	@Override
	public void paint(Graphics g){
		super.paint(g);
		//System.out.println("paint called ----------------");
		g.setFont(font);
		int w = this.getWidth();
		int h = this.getHeight();
		//System.out.println("宽"+w+"  高"+h);
		g.drawImage(mainGif, 0, 0,null);
		
		for(int r = 0;r<map.length;r++){
			for(int c = 0;c<map[r].length;c++){
				safelyDraw(g, manager.getImage(map[r][c]), 25+58*c, r*58+25);
			}
		}
		g.drawRect(25+58*select_c, 25+58*select_r, 58, 58);
		g.drawString(isBlack?"黑方下棋":"红方下棋", 220 , 650);
		
	}
	
	public void safelyDraw(Graphics g,Image img,int x,int y){
		try {
			if(img == null){
				//System.err.println("img = null ,skip drawing "+x+" , "+y);
			}
			g.drawImage(img, x, y,null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}