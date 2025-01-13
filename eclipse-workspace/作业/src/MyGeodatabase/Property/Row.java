package MyGeodatabase.Property;

public class Row {
	public String fields[];
	public Row(String fields[]){
		this.fields= fields;
		
	}
  public  String getValue(int i) {
	   return fields[i];
   }
   public void setValue(int i,String m) {
	   fields[i]=m;
   }
}
