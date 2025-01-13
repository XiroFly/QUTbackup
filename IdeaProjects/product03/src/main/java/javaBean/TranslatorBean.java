package javaBean;

import java.util.HashMap;
import java.util.Map;

public class TranslatorBean {
    public TranslatorBean(){
        data.put("姓名","name");
        data.put("性别","sex");
        data.put("年龄","age");
        data.put("看书","reading");
        data.put("跳舞","dancing");
        data.put("唱歌","singing");
        data.put("游泳","swimming");
        data.put("足球","playing football");
        data.put("爱好","hobby");
    }
    private String chineseWord=new String("default");
   private final Map <String,String> data=new HashMap<String, String>();

    public void setChineseWord(String chineseWord) {
        this.chineseWord = new String(chineseWord) ;
    }

    public String getEnglishWord() {
        if(data.get (chineseWord)==null)return chineseWord+"的英文";
        return data.get (chineseWord);
    }
}

