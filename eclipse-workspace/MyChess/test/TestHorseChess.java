import org.chess.HorseChess;

import junit.framework.TestCase;
public class TestHorseChess extends TestCase {
	public void testAA(){
		System.out.println("ttt");
	}
	HorseChess chess = new HorseChess();
	//走 日
	public void testHorse1(){
		int[][] map = {
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,2, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2, 0, 1, true);//黑方还是红方
		assertEquals(b, true);
	}
	
	//憋马脚
	public void testHorse2(){
		int[][] map = {
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 1, 0, 0},
				{ 0 ,0 ,2, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2, 0, 1, true);//黑方还是红方
		assertEquals(b, false);
	}
	
	//不憋马脚
	public void testHorse3(){
		int[][] map = {
				{ 0 ,0, 0, 0, 0},
				{ 0 ,1, 0, 0, 0},
				{ 0 ,0 ,2, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2, 0, 1, true);//黑方还是红方
		assertEquals(b, true);
	}
	
	//蹩马脚
	public void testHorse4(){
		int[][] map = {
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 1, 0, 0},
				{ 0 ,1 ,2, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2, 3, 0, true);//黑方还是红方
		assertEquals(b, false);
	}
	
}
