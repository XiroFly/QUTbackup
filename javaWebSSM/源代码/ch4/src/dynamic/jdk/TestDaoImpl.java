package dynamic.jdk;
import org.springframework.stereotype.Repository;
@Repository("testDao")
public class TestDaoImpl implements TestDao{
	@Override
	public void save() {
		//int n = 100/0;
		System.out.println("±£´æ");
	}
	@Override
	public void modify() {
		System.out.println("ÐÞ¸Ä");
	}
	@Override
	public void delete() {
		System.out.println("É¾³ý");
	}
}
