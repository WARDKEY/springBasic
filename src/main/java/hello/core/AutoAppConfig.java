package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

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
