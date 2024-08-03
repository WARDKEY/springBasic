package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import hello.core.member.Member;

public class AutowiredTest {

	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}

	static class TestBean {
		@Autowired(required = false)
		public void setNoBean1(Member noBean1){
			System.out.println("noBean1 = " + noBean1);
		}

		@Autowired
		public void setNotBean2(@Nullable Member notBean2){
			System.out.println("notBean2 = " + notBean2);
		}

		@Autowired
		public void setNotBean3(Optional<Member> notBean3){
			System.out.println("notBean3 = " + notBean3);
		}
	}
}
