package org.chess;
import java.awt.Image;

import javax.swing.JOptionPane;
/*
 * 马 H
 * @author 姜权罡
 * */
public class HorseChess extends Chess {
	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		// TODO Auto-generated method stub
		int cc=Math.abs(now_c - to_c);
		int rc=Math.abs(now_r - to_r);
		
		boolean succ = (cc ==2&&rc==1)||(cc ==1&&rc==2);
		
		if(!succ) return false;//如果不是日，直接失败!
		
		int r;//r为马脚的行坐标
		int c;//c为马脚的列坐标
		if(cc==1){//走日
			r=(to_r+now_r)/2;
			c=now_c;
		}
		else{//走横着的 日
			r=now_r;
			c=(to_c+now_c)/2;
		}
		
		if(isBlack==true&&map[to_r][to_c]=='G'){
			JOptionPane.showMessageDialog(null, "黑方胜利！");
			return true;
		}
		if(isBlack==false&&map[to_r][to_c]==1000+'G'){
			JOptionPane.showMessageDialog(null, "红方胜利！");
			return true;
		}
		
		return map[r][c]==0;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "马";
	}
	
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		
			return 'H';
	}

	@Override
	public Image getImage(boolean isBlack) {
		// TODO Auto-generated method stub
		return ImageTool.loadImage(isBlack?"黑马.gif":"红马.gif");
	}

}
