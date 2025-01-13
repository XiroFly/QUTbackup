package org.chess;
import java.awt.Image;

import javax.swing.JOptionPane;
/*
 * 黑车1
 * 红车11
 * @author 庞义俊（姜权罡最后修改成功）
 * */
public class CarChess extends Chess {
	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		// TODO Auto-generated method stub
		int cc = Math.abs(now_c - to_c);
		int rc = Math.abs(now_r - to_r);
		//车类比炮写，车比炮简单
		boolean succ = (cc==0 &&rc!=0 )||(cc!=0 &&rc==0 );//如果不是单条线，直接失败
		if(!succ) return false;
		
		int from,to;
		if(rc == 0){//横着走
			if(now_c < to_c){//向右走
				from = now_c+1 ;
				to = to_c;
			}else{ // d 0 0 x
				//from = to_c;
				//to = now_c-1;
				from = now_c-1;
				to = to_c;
			}
			
			for(int i=from;i<to;i++){
				if(map[now_r][i] != 0 )return false; //中间有棋子，失败！！
			}
		}else{ //竖着走
			//TODO
			if(now_r<to_r){//向上走
				from = to_r;
				to=now_r-1;
			}else{//向下走
				from = now_r+1;
				to=to_r;
			}
			for(int i=from;i<to;i++){
				if(map[i][now_c] != 0 )return false; //中间有棋子，失败！！
			}
			
		}
		
		if(isBlack==true&&map[to_r][to_c]=='G'){
			JOptionPane.showMessageDialog(null, "黑方胜利！");
			return true;
		}
		if(isBlack==false&&map[to_r][to_c]==1000+'G'){
			JOptionPane.showMessageDialog(null, "红方胜利！");
			return true;
		}
		
		return true;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "车";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 'C';
	}

	@Override
	public Image getImage(boolean isBlack) {
		// TODO Auto-generated method stub
		return ImageTool.loadImage(isBlack?"黑车.gif":"红车.gif");
	}

}
