package Javabean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DatabaseJavabean {
   private final Map<String,String> dataBase=new HashMap<String, String>(){
        {
            put("1",".NET程序设计");
            put("2","Java程序设计");
            put("3","JSP程序设计");
            put("4","Android程序设计");
            put("5","软件工程");
        }
    };

   private final ArrayList<String>  dispalyingDatas=new ArrayList<String>();
   public DatabaseJavabean(){
    }

    public void setDispalyingDatas(String index) {
        for(String i:dispalyingDatas )if(i.equals(index))return;
        this.dispalyingDatas.add(index);
    }
    public boolean isExistence(String index){
        for(String i:dispalyingDatas )if(i.equals(index))return true;
        return false;
    }
    public void deleteDispalyingDatas(String index){
       this.dispalyingDatas.remove(index);
    }

    public ArrayList<String> getDispalyingDatas() {
        return dispalyingDatas;
    }
    public String showDispalyingData (String index){
        return this.dataBase.get(index);
    }

    public Map<String, String> getDataBase() {
        return dataBase;
    }
}
