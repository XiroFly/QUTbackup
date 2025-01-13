package jichu.one;
import java.lang.Math;
/*实验名称：《实验二 类与对象的应用》
实验时间：2022.4.7
实验地点： 
实验目的及要求：理解面向对象的封装概念，掌握类和对象的创建与使用。
实验内容：
创建一个工程，包含一个Point类、一个Circle类、一个Line类（线段），一个PolyLine类（折线），要求：
1.	Point类包含属性：x坐标、y坐标，包含方法：点的平移、点的坐标输出、计算到另一个点的距离
2.	Circle类包含属性：圆心、半径、π，包含方法：圆的平移（调用点的平移方法）、圆的放大缩小
（即圆心不变、半径放大缩小）、计算圆的周长、计算圆的面积、计算两个圆之间的距离
（调用Point类中计算点距离的方法）
3.	Line类包含属性：起点、终点，包含方法：线段的平移（调用点的平移方法）、
计算线段长度（调用Point类中计算点距离的方法）
4.	PolyLine类包含一个Line数组（折线是由一些首尾相连的线段组合而成），
还包含计算折线总长度的方法（调用Line中计算线段长度的方法）、折线平移的方法（调用线段的平移方法）
然后，创建一个主类来使用上述4个类，验证这个4个类的正确性。
*/
public class Test {
	public static void main(String[] args) {
	Point p=new Point (4,5);
	p.printf();
	p.tRanslation(4,5);
	
	Point.distance(8,9,p.x,p.y);
	Circle o=new Circle(4,3.14,1,2);
	Circle o1=new Circle(5,3.14,8,9);
		o.tRanslation(2, 1);
		o.scale(0.5);//r应为2
		o.girthAndarea();
		Circle.distance(o, o1);
		Line l=new Line(1,12,5,6);
		l.translation(1, 2);
		l.length();
		Point p1=new Point( 7,8);
		Point p2=new Point(3,7);
		Point p3=new Point (9,9);
		Polyline pl=new Polyline(p,p1,p2,p3);
		pl.Polylength();
		pl.Polytrainslation(4, -4);
		System.out.println("平移后p："+p.x+p.y);
		System.out.println("平移后p1："+p1.x+p1.y);
		System.out.println("平移后p2："+p2.x+p2.y);
		System.out.println("平移后p3："+p3.x+p3.y);
	}
}
	
   class Point {
	 int x, y;
	Point(){
	}
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	void tRanslation(int changeX,int changeY ) {
		x=x+changeX;
		y=y+changeY;
		System.out.println("平移后点坐标："+x+" "+y);
	}
	void printf() {
		System.out.println("坐标为:"+x+" "+y);
	}
	static double distance(int x,int y ,int x1,int y1) {
		double d;
		d=Math.pow((x-x1)*(x-x1)+(y-y1)*(y-y1), 1/2);
		System.out.println("长度或距离为："+d);
		return d;
	}
	
}
 class Circle{
	double r;
	double pai;
	Point o;
	Circle(double r,double pai,int x,int y ){
		this.r=r;
		this.pai=pai;
		o=new Point(x,y);
	}
	
	void tRanslation(int changeX,int changeY){
		o.tRanslation(changeX, changeY);
		
	}
	void scale(double change) {
		r=r*change;
	}
	void girthAndarea() {
		System.out.println("周长："+2*pai*r);
		System.out.println("面积："+pai*r*r);
	}
	static void distance(Circle x,Circle y) {
		double d= Point.distance(y.o.x, y.o.y,x.o.x,x.o.y);
		if(d<=0) {
			System.out.println("两圆相交");
			return ;
		}
		System.out.println("两圆距离："+d);
	}
	
}
class Line{
	Point start;
	Point end;
	Line(){}
	Line(int x1,int y1,int x2,int y2){
		start=new Point(x1,y1);
		end=new Point(x2,y2);
	}
	void translation(int changeX,int changeY) {
	start.tRanslation(changeX, changeY);
	end.tRanslation(changeX, changeY);
}
	double length() {
		double d=Point.distance(end.x,end.y,start.x,start.y );
		return d;
	}
}
class Polyline{
	Line sum[];
	Polyline(Point ...p) {
		sum=new Line[p.length-1];
		for(int i=0;i<sum.length;i++) {
			sum[i]=new Line(0,0,0,0);
			sum[i].start=p[i];
			sum[i].end=p[i+1];
			
	}
		}
	void Polylength() {
		double length=0;
		for(int i=0;i<sum.length;i++) {
			length+=sum[i].length();
		}
		System.out.println("折线长度："+length);
	}
	void Polytrainslation(int  changeX,int changeY) {
		for(int i=0;i<sum.length;i++) {
			sum[i].translation(changeX, changeY);
			
		}
	}
}