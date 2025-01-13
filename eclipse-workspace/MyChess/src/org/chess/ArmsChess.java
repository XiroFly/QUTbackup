package org.chess;
import java.awt.Image;

import javax.swing.JOptionPane;
/**
 * 兵 A
 * @author 曹佳榕 董玟彤（姜权罡最后修改成功）
 */
public class ArmsChess extends Chess{
	@Override
	public boolean check(int[][] map, int now_r, int now_c, int to_r, int to_c,boolean isBlack) {
		// TODO Auto-generated method stub
		int cc = to_c - now_c;
		int rc = to_r - now_r;
		if(isBlack==true){//黑卒
			if(now_r<=4){//黑卒未过河
				boolean succ =  cc  == 0 && rc == 1;//黑卒未过河，向下前进一格
				
				if(!succ) return false;//如果不是向下前进一格，直接失败
				else{
					return true;
				}
			}
			else{//黑卒过河
				cc = Math.abs(to_c - now_c);
				boolean succ =  (cc  == 1&&rc==0) || (rc == 1&&cc==0);//黑卒过河，向下前进一格
				
				if(!succ) return false;//如果不是向下/向左/向右前进一格，直接失败
				else{
					if(map[to_r][to_c]=='G'){
						JOptionPane.showMessageDialog(null, "黑方胜利！");
					}
					return true;
				}
				//return map[to_r][to_c]==0;
			}
		}
		else{//红卒
			if(now_r>=5){//红卒未过河
				boolean succ =  cc  == 0 && rc == -1;//红卒未过河，向上前进一格
				
				if(!succ) return false;//如果不是向上前进一格，直接失败
				
				else{
					return true;
				}
			}
			else{//红卒过河
				cc = Math.abs(to_c - now_c);
				boolean succ =  (cc  == 1&&rc==0) || (rc == -1&&cc==0);//红卒过河，向上前进一格
				
				if(!succ) return false;//如果不是向上/向左/向右前进一格，直接失败
				else{
					if(map[to_r][to_c]==1000+'G'){
						JOptionPane.showMessageDialog(null, "红方胜利！");
					}
					return true;
				}
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "卒";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 'A';
	}
	
	@Override
	public Image getImage(boolean isBlack) {
		// TODO Auto-generated method stub
		return ImageTool.loadImage(isBlack?"黑卒.gif":"红卒.gif");
	}
}