package annotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component()//相当于@Component("annotationUser")或@Component(value = "annotationUser")，annotationUser为Bean的id，默认为首字母小写的类名
public class AnnotationUser {
	@Value("chenheng")
	private String uname;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "uname=" + uname;
	}
}
