package test;
import MyGeodatabase.shape.*;
public class Testclass{
	public static void main(String[] args) {
	String []str=new String[3];
	str[0]="有真伤";
	str[1]="有护盾";
	str[2]="有霸体";
	String []st=new String[2];
	st[0]="技能施法范围";
    st[1]="命中目标";
	Point p=new Point(24,26,str);
	System.out.println(p.getCoordinateString());
    p.move(-1,-1);
    System.out.println(p.getCoordinateString());
    p.setValue(2,st[0]);
    System.out.println(p.getValue(2));
	try {
	Circle c=new Circle(p,-1,st);
	}
    catch (ShuruException e) {
    	e.surucw();
    }
	try {
	Circle c=new Circle(p,1,st);
	c.zoom(2.5);
	c.move(5,5);
	System.out.println(c.getCoordinateString());
	System.out.println(c.getValue(1));
	}
	catch (ShuruException e) {
    	e.surucw();
    }
	}
}
		