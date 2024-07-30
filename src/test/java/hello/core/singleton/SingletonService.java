package hello.core.singleton;

public class SingletonService {
	// 자바가 실행될 때 static영역에서 객체를 내부적으로 생성해서 인스턴스를 하나 만듦
	private static final SingletonService instance = new SingletonService();

	// public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
	public static SingletonService getInstance() {
		return instance;
	}

	// 생성자를 private로 선언해서 외부에서 new 키워드로 객체 생성을 못 하게 함
	private SingletonService() {
	}

	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}

}
