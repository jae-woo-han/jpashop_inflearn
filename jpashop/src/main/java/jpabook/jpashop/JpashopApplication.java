package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}
	
	//hibernate를 jackson이 변환 할 수 있게 해주는 모듈
	//엔티티를 직접 api로 노출하는 건 안하는 게 좋기 때문에 쓸 일 없을 것
	@Bean
	Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}

}
