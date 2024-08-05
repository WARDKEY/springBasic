package hello.core.lifecycle;

public class NetworkClient  {

	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 서비스 시작시 호출
	public void connect(){
		System.out.println("connect: "+ url);
	}

	public void call(String message) {
		System.out.println("call: " + url + " message = " + message);
	}

	// 서비스 종료시 호출
	public void disconnect() {
		System.out.println("close " + url);
	}

	// 빈이 생성되고 의존관계 주입이 완료된 후 호출
	public void init() throws Exception {
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메시지");
	}

	// 빈이 소멸하기 직전에 호출
	public void close() throws Exception {
		System.out.println("NetworkClient.close");
		disconnect();
	}
}
