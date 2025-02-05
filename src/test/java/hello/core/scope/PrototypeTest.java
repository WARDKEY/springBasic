package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class PrototypeTest {

	@Test
	void  prototypeBeanFind() {

		// 스프링 컨테이너를 생성하는 역할을 하는데 이 안에 들어간 클래스는 컴포넌트 스캔을 통해 빈으로 등록된다.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
			PrototypeBean.class);
		System.out.println("find prototypeBean1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		System.out.println("find prototypeBean2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

		System.out.println("prototypeBean1 = " + prototypeBean1);
		System.out.println("prototypeBean2 = " + prototypeBean2);

		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		prototypeBean1.destroy();
		prototypeBean2.destroy();
		ac.close();
	}

	@Scope("prototype")
	static class PrototypeBean {
		@PostConstruct
		public void init() {
			System.out.println("prototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("prototypeBean.destroy");
		}
	}
}
