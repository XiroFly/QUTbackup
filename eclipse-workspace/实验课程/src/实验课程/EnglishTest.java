package ÊµÑé¿Î³Ì;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EnglishTest {
		String line;
		String []choose;
		BufferedReader br;File fl;FileReader fr;
		public void getAnswer(int i) {
			int j=1;
			fl=new File("D:\\English.txt");
			try {
				fr=new FileReader(fl);
			    br=new BufferedReader(fr);
			try {
				line=br.readLine();
			     
			     while(j<=i) {
				choose=line.split("#");
					line=br.readLine();
					j++;
					}
			     br.close();
			     }
				 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

