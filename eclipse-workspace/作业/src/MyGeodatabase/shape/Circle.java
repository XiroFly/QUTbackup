package MyGeodatabase.shape;
import MyGeodatabase.Property.*;
public class Circle extends Row implements IGeometry  {
	Point p;
	double r;
  public Circle(Point p,double r,String str [])throws ShuruException{
	   super(str);
	   this.p=p;
	   if(r>0)
	   this.r=r;
	   else throw new ShuruException();
   }
  public void move (double x,double y ) {
	  this.p.x+=x;
	  this.p.y+=y;
  }
  public  void zoom(double m) {
	  this.r=this.r*m;
  }
  public String getCoordinateString() {
	  String str="Ô²ÐÄ×ø±êÎª£º"+p.x+""+" "+p.y+"";
	  return str;
  }
}
