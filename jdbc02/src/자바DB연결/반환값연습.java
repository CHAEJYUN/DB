package 자바DB연결;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

import oracle.jdbc.proxy.annotation.GetCreator;

public class 반환값연습 {
	// 부품은 기능을 처리하기 위해서 만든 부품
	// 휴대폰의 기능 ==> 함수(메서드)
	public void add2() { //void => 반환값 없음
		System.out.println("더하기 기능을 수행합니다.");
	}
	
	public int add(int x, int y) {
		return x + y;
	}
	
	// 자바는 입력값이 다르면 메서드 이름을 동일하게 사용할 수 있음
	public double add(double x, int y) {
		return x + y; // 자바에서 하나만 double이라도 결과는 double
	}
	
	public String add(String x, String y) {
		return x + y; //'+'연산자인 경우 하나만 String이라도 결과는 String
	}
	
	public String add(int x, String y) {
		return x + y;
	}
	
	public int[] add() {
		int[] x = {1, 2, 3};
		return x; //x 앞에 있는 타입을 써줌
	}
	
	public Date getDate() {
		Date date = new Date();
		return date;
	}
	
	public Random getRandom() {
		Random r = new Random();
		return r;
	}
	
	public int getRandom2() {
		Random r = new Random();
		return r.nextInt();
	}
	
	public int GetHour() {
		Date date = new Date();
		return date.getHours();
	}
	
	public ArrayList getlist() {
		ArrayList list = new ArrayList();
		list.add("감자");
		list.add("고구마");
		return list;
	}
	
	public HashSet getSet() {
		HashSet bag = new HashSet();
		bag.add("휴지");
		bag.add("펜");
		return bag;
	}
	
//	public Connection getConnection(String url, String user, String password) {
//		//연결처리
//		Connection con = 연결처리하는 커넥션;
//		return con;
//	}
	
}
