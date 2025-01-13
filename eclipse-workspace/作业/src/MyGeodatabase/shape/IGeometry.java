package MyGeodatabase.shape;

public interface IGeometry {
     void move (double x,double y );
     void zoom(double m);
     String getCoordinateString();
}
