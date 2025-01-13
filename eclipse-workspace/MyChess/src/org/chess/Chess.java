package org.chess;
import java.awt.Image;
/*
 * 棋子父类、
 * 所有棋子继承该类
 * @author 姜权罡
 * */
public abstract class Chess {
	/**
	 * 检查落子是否合法
	 * @param map 地图
	 * @param now_r 当前棋子的行号
	 * @param now_c 当前棋子的列号
	 * @param to_r  想去地方的行号
	 * @param to_c  想去地方的列号
	 * @param isBlack 如果黑方 传true 否则传false
	 * @return 如果可以去，返回true, 否则返回false
	 */
	public abstract boolean check(int[][] map,int now_r,int now_c ,int to_r, int to_c,boolean isBlack);
	
	public abstract int getType();
	
	public abstract String getName();
	
	public abstract Image getImage(boolean isBlack);
}
