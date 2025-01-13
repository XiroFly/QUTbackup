import java.util.Locale;
import java.util.ResourceBundle;
public class TestI18N {
	public static void main(String[] args) {
		//取得系统默认的国家语言环境
		Locale lc = Locale.getDefault();
		//根据国家语言环境加载资源文件
		ResourceBundle rb = ResourceBundle.getBundle("messageResource", lc);
		//打印出从资源文件中取得的信息
		System.out.println(rb.getString("hello"));
	}
}
