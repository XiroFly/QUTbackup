package org.chess;
import java.awt.Image;
/*
 * 士4
 * 仕44
 * @author 曹佳榕（姜权罡最后修改成功）
 * */
public class ChapChess extends Chess {
	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		// TODO Auto-generated method stub
		int cc = Math.abs(now_c - to_c);
		int rc = Math.abs(now_r - to_r);
		//要分黑士 和红仕！！(to_r>=7&&to_r<=9&&to_c>=3&&to_c<=5)
		//黑士(to_r>=0&&to_r<=2&&to_c>=3&&to_c<=5)
		
		boolean succ;
		if(isBlack==true){//黑士
			//如果不是一条斜线，直接失败,还要保证目标位置没有棋子
			//succ = cc==1 && rc==1 &&(to_r>=0&&to_r<=2&&to_c>=3&&to_c<=5)&&(map[to_r][to_c]==0); 
			succ = cc==1 && rc==1 && (to_r>=0&&to_r<=2&&to_c>=3&&to_c<=5); 
		}
		else{//红仕
			//如果不是一条斜线，直接失败
			//succ = cc==1 && rc==1 &&(to_r>=7&&to_r<=9&&to_c>=3&&to_c<=5)&&(map[to_r][to_c]==0); 
			succ = cc==1 && rc==1 &&(to_r>=7&&to_r<=9&&to_c>=3&&to_c<=5); 
		}
		if(!succ) return false; 
		else{
			return true;
		}
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "士";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 'S';
	}

	@Override
	public Image getImage(boolean isBlack) {
		// TODO Auto-generated method stub
		return ImageTool.loadImage(isBlack?"黑士.gif":"红士.gif");
	}

}
