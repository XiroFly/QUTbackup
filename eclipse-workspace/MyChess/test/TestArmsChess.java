import org.chess.ArmsChess;
import junit.framework.TestCase;

public class TestArmsChess extends TestCase {
	ArmsChess chess = new ArmsChess();
	
	//未过河,黑卒向下1格
	public void testCheck1(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,7, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2,3, 2, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, true);
	}
	
	//未过河,黑卒向上1格（错误）
	public void testCheck2(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,7, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2,1, 2, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//未过河，黑卒向左1格（错误）
	public void testCheck3(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,7, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2,2, 1, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//未过河，黑卒向下2格（错误）
	public void testCheck4(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,7, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0}
		};
		boolean b = chess.check(map, 2,2,4, 2, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//过河，黑卒向上1格（错误）
	public void testCheck5(){
		int[][] map={
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,7, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
		};
		boolean b = chess.check(map, 5,2,4, 2, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//过河，黑卒向左1格（正确）
	public void testCheck6(){
		int[][] map={
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,7, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
		};
		boolean b = chess.check(map, 5,2,5, 1, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, true);
	}
	
	//过河，黑卒向右1格（正确）
	public void testCheck7(){
		int[][] map={
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,7, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
		};
		boolean b = chess.check(map, 5,2,5, 3, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, true);
	}
	//过河，黑卒向下2格（错误）
	public void testCheck8(){
		int[][] map={
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0, 0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,7, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
				{ 0 ,0 ,0, 0, 0,0},
		};
		boolean b = chess.check(map, 5,2,7, 2, true);//黑方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//未过河,红卒向上1格
	public void testCheck21(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 6,1,5,1, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, true);
	}
	
	//未过河,红卒向左1格(错误)
	public void testCheck22(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 6,1,6,0, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//未过河,红卒向下1格(错误)
	public void testCheck23(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 6,1,7,1, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//过河,红卒向上1格
	public void testCheck24(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 4,1,3,1, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, true);
	}
	
	//过河,红卒向左1格
	public void testCheck25(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 4,1,4,0, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, true);
	}
	
	//过河,红卒向下1格(错误)
	public void testCheck26(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 4,1,5,1, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	//过河,红卒向上2格(错误)
	public void testCheck27(){
		int[][] map={
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0, 0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,7 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
				{ 0 ,0 ,0, 0, 0},
		};
		boolean b = chess.check(map, 4,1,2,1, false);//红方（布尔类型判断黑方还是红方）
		assertEquals(b, false);
	}
	
	

}
