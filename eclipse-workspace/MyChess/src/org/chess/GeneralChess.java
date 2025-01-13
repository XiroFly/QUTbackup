package org.chess;
import java.awt.Image;

import javax.swing.JOptionPane;
/*
 * 将5
 * 帅55
 * @author 庞义俊（姜权罡最后修改成功）
 * */
public class GeneralChess extends Chess {

	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		// TODO Auto-generated method stub
		int cc = Math.abs(now_c - to_c);
		int rc = Math.abs(now_r - to_r);
		
		boolean succ;
		int count=0;
		int min_r= now_r<to_r?now_r:to_r;
		int max_r=now_r>to_r?now_r:to_r;
		for(int i=min_r+ 1;i<max_r;i++){//如果双方 将军之间有棋子的话，不可走棋
			if(cc==0&&map[i][now_c]!=0){
				count=1;
				return false;
			}
		}
		
		if(isBlack==true){//黑将
			//如果是一条斜线，直接失败
			//目标为红将，且之间没有棋子，移动
			if(map[to_r][to_c]=='G'&&count==0){
				
				JOptionPane.showMessageDialog(null, "黑方胜利");
				return true;
			}
			succ = ((cc==1 && rc==0)||(cc==0 && rc==1)) &&(to_r>=0&&to_r<=2&&to_c>=3&&to_c<=5); 
		}
		else{//红帅
			//如果是一条斜线，直接失败
			//目标为黑将，且之间没有棋子，移动
			if(map[to_r][to_c]==1000+'G'&&count==0){
				JOptionPane.showMessageDialog(null, "红方胜利");
				return true;
			}
			succ = ((cc==1 && rc==0)||(cc==0 && rc==1)) &&(to_r>=7&&to_r<=9&&to_c>=3&&to_c<=5); 
		}
		if(!succ) return false; 
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "将";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 'G';
	}

	@Override
	public Image getImage(boolean isBlack) {
		// TODO Auto-generated method stub
		return ImageTool.loadImage(isBlack?"黑将.gif":"红将.gif");
	}

}
