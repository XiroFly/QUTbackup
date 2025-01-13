package org.chess;
import java.awt.Canvas;
import javax.swing.JOptionPane;
public class RangeChecker  {
	// 1  r和c 是不是合法的
	// 2 目标位置是否已经有其它棋子，如果有敌方棋子可以走，有己方不可走
	public static boolean inRange(int[][] map,int p_r,int p_c,int r,int c,boolean isBlack){
		if(r<0 || r>9 || c< 0 || c>9) return false;
		if(map[r][c]==0){//目标位置没有棋子,走棋
			
			return false;
		}else{//目标位置有棋子   判断是否为友方！友方不可走，敌对方可走。
			if(map[r][c]<1000&&map[p_r][p_c]>1000){//红方，之前的是黑方。 结果是敌方   可以走棋
				return true;
			}else if(map[r][c]>1000&&map[p_r][p_c]<1000){//黑方，之前的是红方，结果是敌方   不可走棋
				return true;
			}else{
				return false;
			}
		}
	}

	public static boolean selectInRange(int[][] map, int r, int c,boolean isBlack) {
		//下表在范围内，且当前点由自己放的棋子可以， 否则不可以。
		if(r<0 || r>9 || c< 0 || c>9) return false;
		if(map[r][c] == 0) return true;
		return (isBlack==true && map[r][c]>1000) ||  (isBlack==false && map[r][c]<1000);
	}
}
