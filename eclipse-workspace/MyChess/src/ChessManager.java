import java.awt.Image;
import java.util.HashMap;
import org.chess.ArmsChess;
import org.chess.CannonChess;
import org.chess.CarChess;
import org.chess.ChapChess;
import org.chess.Chess;
import org.chess.ElephantChess;
import org.chess.GeneralChess;
import org.chess.HorseChess;
import org.chess.ImageTool;

public class ChessManager {
	HashMap<Integer,Chess> chesses = new HashMap<Integer,Chess>();
	public  ChessManager(){
		ArmsChess a = new ArmsChess();
		chesses.put(a.getType(), a);
		
		CannonChess b =new CannonChess();
		chesses.put(b.getType(),b);
		
		CarChess c = new CarChess();
		chesses.put(c.getType(), c);
		
		ChapChess d = new ChapChess();
		chesses.put(d.getType(), d);
		
		ElephantChess e = new ElephantChess();
		chesses.put(e.getType(), e);
		
		GeneralChess f = new GeneralChess();
		chesses.put(f.getType(), f);
		
		HorseChess g = new HorseChess();
		chesses.put(g.getType(), g);
		//其它其子类也在这里注册
		
	}
	
	public Chess getTheChess(int type){
		if(type > 1000) type -= 1000;
		return chesses.get(type);
	}
	HashMap<String, Image> img_map=new HashMap<String, Image>();
	public void loadAllImage() {
		for(Chess c : chesses.values()){
			Image img_black = c.getImage(true);
			Image img_red = c.getImage(false);
			
			img_map.put(c.getType()+"_黑", img_black);
			img_map.put(c.getType()+"_红", img_red);
		}
	}
	
	public Image getImage(int type){
		int color = type /1000;
		type = type % 1000;
		
		return img_map.get(type+(color==1?"_黑":"_红"));
	}
}
