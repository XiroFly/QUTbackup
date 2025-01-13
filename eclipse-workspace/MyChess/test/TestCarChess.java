import junit.framework.TestCase;
import org.chess.CarChess;
public class TestCarChess extends TestCase {
	CarChess chess = new CarChess();
	
	//车水平向右移动(过程无棋子)
	public void testCheck1(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 6, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//车水平向左移动(过程无棋子)
	public void testCheck2(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 6, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//车水平向上移动(过程无棋子)
	public void testCheck3(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 6, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,0,3, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//车水平向下移动(过程无棋子)
	public void testCheck4(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 6, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,4, 3, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//车水平向右移动(过程有1个棋子)(错误)
	public void testCheck22(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 6, 1, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//车水平左移动(过程有2个棋子)  (错误)
	public void testCheck24(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,1 ,1, 6, 1, 1, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2,0, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//车斜着移动 (错误)
	public void testCheck25(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 6, 1, 1, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,0, 2, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
}