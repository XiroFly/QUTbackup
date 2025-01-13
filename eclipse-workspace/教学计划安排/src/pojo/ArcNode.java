package pojo;
public class ArcNode implements Cloneable{
   public int adjVex;
   public ArcNode nextArc;

   @Override
   public Object clone(){
       ArcNode arcNode = null;
       try {
           arcNode = (ArcNode) super.clone();
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
       }
       arcNode.nextArc = (ArcNode) nextArc.clone();
       return arcNode;
   }

   public ArcNode() {
       adjVex = 0;
       nextArc = null;
   }
}