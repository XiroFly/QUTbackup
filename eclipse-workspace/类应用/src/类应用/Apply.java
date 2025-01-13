package 类应用;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Apply {
  public static void main(String arg[]) {
	  String input ="数学87分，物理76分，英语96";
	  Scanner scanner=new Scanner(input);
	  scanner.useDelimiter("[^1-9]+");
	  double sum=0;
	  while(scanner.hasNext()) {
		  double k= scanner.nextDouble();
		  sum=sum+k;
	  }
	  System.out.println("总成绩："+sum+"平均值："+sum/3);
	 Scanner in =new Scanner (System.in);
	  int year=in.nextInt();
	  int month=in.nextInt();
	 
	 LocalDate dl=LocalDate.of(year,month,1);
	 System.out.println(year+"年"+month+"月日历：");
	 int [] [] array=new int[6][7];
	 for(int i=0;i<6;i++)
		 for(int j=0;j<7;j++)
			
		if(j+1==dl.getDayOfWeek().getValue())
	  	{
			array[i][j]=dl.getDayOfMonth();
            dl=dl.plusDays(1);	  
            if(dl.getMonthValue()!=month) {
            	break;
            }
 	  	}
	 System.out.println("一     二     三     四     五     六     七");
	 for(int i=0;i<6;System.out.println(""),i++) {
		 for(int j=0;j<7;j++)
			 if(array[i][j]==0) {
				System.out.print("   ");
			 }
			 else System.out.printf("%3d",array[i][j]);
  }
	year= in.nextInt();month=in.nextInt();int day=in.nextInt();
	LocalDate Ld=LocalDate.of(year, month,day);
	year= in.nextInt();month=in.nextInt(); day=in.nextInt();
	LocalDate Lds=LocalDate.of(year, month,day);
	System.out.print(Ld.until(Lds,ChronoUnit.DAYS)+"天");
	
	 }
  
}
