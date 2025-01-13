package MyGeodatabase.shape;
import MyGeodatabase.Property.Row; 
public class Point extends Row implements IGeometry {
	double x,y;
   public Point(double x,double y,String strs []){
	   super(strs);
	   this.x=x;
	   this.y=y;
   }
   public void move(double x,double y ) {
	   this.x+=x;
	   this.y+=y;
   };
    public void zoom(double m) {
	   this.x=m*this.x;
	   this.y=m*this.y;
   };
   public String getCoordinateString() {
	   String str="×ø±êÎª£º"+x+""+" "+y+"";
	   return str ;
   };
   
}
