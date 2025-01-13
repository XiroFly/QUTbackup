package pojo;
import static constant.MyConstants.MaxInt;
/**
* 
*/
public class Stack {
   /**
    * 用于存储课程的数组
    */
   public Course[] stackArray;
   /**
    * 栈顶指针
    */
   public int top;

   public Stack() {
       top = -1;
       stackArray = new Course[MaxInt];
   }
   public Stack(int n){
       top = -1;
       stackArray = new Course[n];
   }
   public void push(Course course){
       if (top == stackArray.length-1){
           Course[] p = new Course[top*2+2];
           for (int i = 0; i <= top; i++) {
               p[i] = stackArray[i];
           }
           stackArray = p;
       }
       top++;
       stackArray[top] = course;
   }

   public Course pop(){
       if (top == -1){
           System.out.println("栈已空，无法再删除元素！");
           return null;
       }
       top--;
       return stackArray[top+1];
   }
}