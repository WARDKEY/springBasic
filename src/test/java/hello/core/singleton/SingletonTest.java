package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// 1.조회: 호출할 때마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();

		// 2.조회: 호출할 때마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();

		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);

		// memberService1 != memberService2
		assertThat(memberService1).isNotSameAs(memberService2);
		// 호출을 할 때마다 새로운 객체를 생성하는 것을 알 수 있다.
	}

	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();

		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);

		// 같은 객체 인스턴스임을 알 수 있다.
		// memberService1 == memberService2
		assertThat(singletonService1).isSameAs(singletonService2);
		// same == 주소 값 비교
		// equal == 참조 값 비교

		singletonService1.logic();
	}

	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer() {
		// AppConfig appConfig = new AppConfig();

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


		MemberService memberService1 = ac.getBean("memberService", MemberService.class);

		MemberService memberService2 = ac.getBean("memberService", MemberService.class);

		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);

		// memberService1 != memberService2
		assertThat(memberService1).isSameAs(memberService2);
		// 호출을 할 때마다 새로운 객체를 생성하는 것을 알 수 있다.
	}

}
