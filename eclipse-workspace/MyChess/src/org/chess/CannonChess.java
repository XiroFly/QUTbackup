package org.chess;
import java.awt.Image;

import javax.swing.JOptionPane;
/*
 * 
 * @author 姜权罡
 * */
public class CannonChess extends Chess {
	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		// TODO Auto-generated method stub
		int cc = Math.abs(now_c - to_c);
		int rc = Math.abs(now_r - to_r);
		//count为 0 说明炮与目标之间没有棋子
		//count为 1 说明炮与目标之间有 1个 棋子
		//count为 2 说明炮与目标之间有 2个 棋子
		boolean succ = (cc==0 &&rc!=0 )||(cc!=0 &&rc==0 );//如果不是单条线，直接失败
		if(!succ) return false;
		
		int count=0;
		int from,to;
		//目标点没有棋子，且目标点和初始点之间无棋子，成功。
		//目标点有棋子，且为敌方棋子，且目标点和初始点之间有一个棋子，成功。
		if(rc==0){//横着走
			if(now_c<to_c){//向右走
				from = now_c+1;
				to=to_c;
			}else{//向左走
				from = to_c+1;
				to = now_c;
			}
			for(int i=from;i<to;i++){
				if(map[now_r][i]!=0){
					count++;
				}
			}
			System.out.println("棋子个数：\n"+count);
			if(map[to_r][to_c]==0&&count==0)
			{
				return true;
			}
			
			if(map[to_r][to_c]==0&&count==1)
			{
				return false;
			}
			
			//黑方，对面为红方;  红方，对面为黑方。
			if(map[to_r][to_c]!=0&&((isBlack==true&&map[to_r][to_c]<1000)||(isBlack==false&&map[to_r][to_c]>1000))&&count==1){ 
				
				//将军
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
			else{
				return false;
			}
		}else{//竖着走
			if(now_r<to_r){//向下走
				from =  now_r+1;
				to = to_r;
			}else{//向上走
				from = to_r+1; 
				to = now_r;
				
			}
			
			for(int i=from;i<to;i++){
				if(map[i][now_c]!=0){
					count++;
				}
			}
			System.out.println("棋子个数：\n"+count);
			
			if(map[to_r][to_c]==0&&count==0)
			{
				return true;
			}
			if(map[to_r][to_c]==0&&count==1)
			{
				return false;
			}
			//黑方，对面为红方;  红方，对面为黑方。
			if(map[to_r][to_c]!=0&&((isBlack==true&&map[to_r][to_c]<1000)||(isBlack==false&&map[to_r][to_c]>1000))&&count==1){
				//将军
				if(isBlack==true&&map[to_r][to_c]=='G'){
					JOptionPane.showMessageDialog(null, "黑方胜利！");
					return true;
				}
				if(isBlack==false&&map[to_r][to_c]==1000+'G'){
					JOptionPane.showMessageDialog(null, "红方胜利！");
					return true;
				}
				//return true;
			}else{
				return false;
			}
			
		}
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "炮";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 'P';
	}

	@Override
	public Image getImage(boolean isBlack) {
		// TODO Auto-generated method stub
		return ImageTool.loadImage(isBlack?"黑炮.gif":"红炮.gif");
	}
}
