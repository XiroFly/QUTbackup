package pojo;
import java.util.Scanner;
/**
* AOV图（课程）
*/
public class Graph implements Cloneable{
   /**
    * 顶点表
    */
   public Vnode[] adjList;
   /**
    * 边数
    */
   private int e;
   /**
    * 顶点数
    */
   private int n;
   public Graph(int number,int edge) {
       adjList = new Vnode[number];
       n = number;
       e = edge;
   }
   @Override
   public Object clone() {
       Graph graph = null;
       try {
           graph = (Graph) super.clone();
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
       }
       graph.adjList = (Vnode[])adjList.clone();
       return graph;
   }

   public void setN(int n) {
       this.n = n;
   }

   /**
    * 查找顶点位置
    */
   public int locateVex(Course c){
       for (int i = 0; i < n; i++) {
           if (adjList[i].getData().getId().equals(c.getId())) {
               return i;
           }
       }
       return -1;
   }

   /**
    * 建立有向图的邻接表
    */
   public void creatAdj(){
       Scanner scanner = new Scanner(System.in);
       for (int i = 0; i < n; i++) {
           //录入顶点信息
           System.out.println("请输入课程编号");
           String id = scanner.next();
           System.out.println("请输入课程名字");
           String name = scanner.next();
           Course c = new Course();
           c.setId(id);
           c.setName(name);
           adjList[i] = new Vnode();
           adjList[i].setIn(0);
           adjList[i].setData(c);
           adjList[i].setFirstArc(null);
       }
       System.out.println("输入依赖信息：");
       for (int i = 0; i < e; i++) {
           System.out.println("请输入第"+(i+1)+"条边的两个端点,端点间使用空格间隔即可");
           String str1 =  scanner.next();
           String str2 =  scanner.next();
           Course c1 = new Course();
           Course c2 = new Course();
           c1.setId(str1);
           c2.setId(str2);
           int a = locateVex(c1);
           int b = locateVex(c2);
           if (a >= 0 && b >= 0){
               ArcNode s = new ArcNode();
               s.adjVex = b;
               s.nextArc = adjList[a].getFirstArc();
               adjList[a].setFirstArc(s);
               adjList[b].setIn(adjList[b].getIn()+1);
           }
       }
   }
}
