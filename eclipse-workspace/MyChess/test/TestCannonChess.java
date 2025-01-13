import org.chess.CannonChess;
import junit.framework.TestCase;
public class TestCannonChess extends TestCase {
	
	CannonChess chess = new CannonChess();
	//炮水平向右移动(过程无棋子)
	public void testCheck1(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮水平向右移动(过程有一个棋子)
	public void testCheck31(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 1, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮水平向右移动(过程有一个棋子)
	public void testCheck32(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 1, 6 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	
	//炮水平向右移动(过程有两个棋子)
	public void testCheck33(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 1, 1, 6 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 6, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	
	//炮水平向左移动(过程无棋子)
	public void testCheck41(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 0, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮水平向左移动(过程一个棋子)
	public void testCheck42(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,1, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 0, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮水平向左移动(过程一个棋子)
	public void testCheck43(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 6 ,0 ,1, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 0, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮水平向左移动(过程两个棋子)
	public void testCheck44(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 6 ,1,1, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 2,3,2, 0, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮竖直向上移动(过程0个棋子)
	public void testCheck51(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,0,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮竖直向上移动(过程1个棋子)
	public void testCheck52(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  1, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,0,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮竖直向上移动(过程1个棋子)
	public void testCheck53(){
		int[][] map = {
				{ 0 ,0 ,0, 1, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  1, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,0,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮竖直向上移动(过程2个棋子)
	public void testCheck54(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 2, 0, 0, 0 },
				{ 0 ,0,0,  1, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,0,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮竖直向上移动(过程2个棋子)
	public void testCheck55(){
		int[][] map = {
				{ 0 ,0 ,0, 1, 0, 0, 0 },
				{ 0 ,0 ,0, 2, 0, 0, 0 },
				{ 0 ,0,0,  1, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,0,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮竖直向下移动(过程0个棋子)
	public void testCheck61(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  0, 0, 0, 0 },
				{ 0 ,0 ,0, 1006, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,6,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮竖直向下移动(过程1个棋子)
	public void testCheck62(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  0, 0, 0, 0 },
				{ 0 ,0 ,0,1006, 0, 0, 0 },
				{ 0 ,0 ,0, 1, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,6,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//炮竖直向下移动(过程1个棋子)
	public void testCheck63(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  0, 0, 0, 0 },
				{ 0 ,0 ,0,1006, 0, 0, 0 },
				{ 0 ,0 ,0, 1, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 2, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,6,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	
	//炮竖直向下移动(过程2个棋子)
	public void testCheck64(){
		int[][] map = {
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0,0,  0, 0, 0, 0 },
				{ 0 ,0 ,0,1006, 0, 0, 0 },
				{ 0 ,0 ,0, 1, 0, 0, 0 },
				{ 0 ,0 ,0, 1, 0, 0, 0 },
				{ 0 ,0 ,0, 2, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		boolean b = chess.check(map, 3,3,6,3 , true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
}
