package pojo;

/**
* ¿Î³ÌÐÅÏ¢
* 
*/
public class Course implements Cloneable{
   private String id;
   private String name;

   public Course() {
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
       Course course = null;
       try {
           course = (Course)super.clone();
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
       }
       return course;
   }

   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
}