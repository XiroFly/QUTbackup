package dao;

import org.springframework.stereotype.Service;

@Service
public class TestDIDaoImpl implements TestDIDao{
	@Override
	public void sayHello() {
		System.out.println("TestDIDao say: Hello, Study hard!");
	}
}
