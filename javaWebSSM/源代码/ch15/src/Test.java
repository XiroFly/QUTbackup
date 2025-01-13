import java.util.Locale;
public class Test {
	public static void main(String[] args) {
		// 返回Java所支持的语言和国家的数组
		Locale locales[] = Locale.getAvailableLocales();
		// 遍历数组元素，依次获取所支持的国家和语言
		for (int i = 0; i < locales.length; i++) {
			// 打印出所支持的国家和语言
			System.out.println(locales[i].getDisplayCountry() + "="
					+ locales[i].getCountry() + " "
					+ locales[i].getDisplayLanguage() + "="
					+ locales[i].getLanguage());
		}
	}
}
