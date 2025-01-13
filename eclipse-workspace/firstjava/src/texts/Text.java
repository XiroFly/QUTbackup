package texts;
import java.io.*;
public class Text {
	public static void main(String[] args) {
	}
}
 class Student{
	 String name;
	 String stdnum;
	 Student(String s,String r){
		 name=s;
		 stdnum=r;
	 }
	 Student (){
		 name="baipengfei";
		 stdnum="202111050676";
	 }
public void save2File(Student[] stu, String path) {
		 File f=new File(path);
		 try {
			 FileWriter in=new FileWriter(f);
			 BufferedWriter bw=new BufferedWriter(in);
			 for(int i=0;i<stu.length;i++) {
				 bw.write(stu[i].toString());
				 bw.newLine();
			 }
			 
			 bw.close();
		 }
		 catch(IOException e){
			 System.out.println(e.toString());
		 }
	 }
	 public String toString() {
		 char[]b=new char[100];
		 "name:".getChars(0, 4, b, 0);
		 name.getChars(0, name.length()-1, b, 5);
		 " stdnum:".getChars(0,7 , b, 5+name.length());
		 stdnum.getChars(0, stdnum.length()-1, b, 13+name.length());
		String a=new String(b,0,13+name.length()+stdnum.length());
		 return a;
	 }
 }
 

	