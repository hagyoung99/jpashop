package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

		Hello a = new Hello();
		a.setData("1");
		System.out.println(a.getData());


		SpringApplication.run(JpashopApplication.class, args);
	}

}
