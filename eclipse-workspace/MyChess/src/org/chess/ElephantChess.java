package org.chess;
import java.awt.Image;
/**
 * 象3
 * 相33
 * @author 董玟彤（姜权罡最后修改成功）
 */
public class ElephantChess  extends Chess{
	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		int cc = Math.abs(now_c - to_c);
		int rc = Math.abs(now_r - to_r);
		
		boolean succ =  cc  == 2 && rc == 2;
		
		if(!succ ) return false; //如果不是田，直接失败！
		 
		int c = (now_c+to_c)/2;
		int r = (now_r+to_r)/2;
		if(isBlack==true){//黑象
			return map[r][c] == 0&&to_r<=4;//象不能过河
			//该点二维数组为0说明，象眼为空，可以走棋。不考虑目标点有没有棋子！
		}
		else{//红象
			return map[r][c] == 0&&to_r>=5;//象不能过河
		}
	}
	
	@Override
	public String getName() {
		return "象";
	}

	@Override
	public int getType() {
		return 'E';
	}

	@Override
	public Image getImage(boolean isBlack) {
		return ImageTool.loadImage(isBlack?"黑象.gif":"红象.gif");
	}
}
