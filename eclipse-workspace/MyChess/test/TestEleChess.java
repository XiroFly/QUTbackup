import org.chess.ElephantChess;
import junit.framework.TestCase;
public class TestEleChess  extends TestCase{
	
	ElephantChess chess = new ElephantChess();
	public void testCheck1(){
		int[][] map = {
				{ 0,0, 0, 3, 0, 0, 0 },
				{ 0 ,0, 0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		
		boolean b = chess.check(map, 1,1,3, 3, true);//黑方还是红方， true为黑方
		assertEquals(b, true);
	}
	//象眼添上的情况
	public void testCheck2(){
		int[][] map = {
				{ 0,0, 0, 3, 0, 0, 0 },
				{ 0 ,0, 0, 0, 0, 0, 0 },
				{ 0 ,0 ,1, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		
		boolean b = chess.check(map, 1,1,3, 3, true);//黑方还是红方
		assertEquals(b, false);
	}
	
	//不走田子
	public void testCheck3(){
		int[][] map = {
				{ 0,0, 0, 3, 0, 0, 0 },
				{ 0 ,0, 0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		
		boolean b = chess.check(map, 1,1,2, 3, true);//黑方还是红方
		assertEquals(b, false);
	}
	
	//不走田子
	public void testCheck4(){
		int[][] map = {
				{ 0,0, 0, 3, 0, 0, 0 },
				{ 0 ,0, 0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
		};
		
		boolean b = chess.check(map, 1,1,3, 2, true);//黑方还是红方
		assertEquals(b, false);
	}
	
	//黑象过河（错误）
	public void testCheck11(){
		int[][] map = {//2
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },//2
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,3, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
				
		};
		boolean b = chess.check(map, 4,2,6,0, true);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
	//红象过河（错误）
	public void testCheck12(){
		int[][] map = {//2
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },//2
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 },
				{ 0 ,0 ,0, 0, 0, 0, 0 }
				
		};
		boolean b = chess.check(map, 5,2,3,0, false);//黑方还是红方， true为黑方
		assertEquals(b, false);
	}
	
}
