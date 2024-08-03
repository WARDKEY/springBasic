package hello.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
@ComponentScan (

	// member만 컴포넌트 스캔의 대상이 됨
	basePackages = "hello.core.member",

	basePackageClasses = AutoAppConfig.class,
	// AppConfig.class 를 제외하기 위해 설정
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

	// @Bean(name = "memoryMemberRepository")
	// MemberRepository memberRepository() {
	// 	return new MemoryMemberRepository();
	// }
}
