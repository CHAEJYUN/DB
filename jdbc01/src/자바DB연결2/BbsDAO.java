package 자바DB연결2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 화면DB연결2.BbsVO;

public class BbsDAO {

public BbsVO one(int no) {
		
		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블
		//기본형은 정수, 실수, 문자, 논리만 값으로 초기화
		//나머지 데이터(참조형)은 주소가 들어가 있음
		//참조형 변수를 초기화 할 때는 null을 사용(주소가 없다라는 의미)
		BbsVO bag = null;
		
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공");

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// 자바는 부품조립식이라 String에 넣으면 걍 String인줄 앎
			// 그래서 SQL부품을 만들고 사용해야 함 => PreparedStatement
			String sql = "select * from hr.bbs where NO = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (rs.next()) {
				System.out.println("검색결과 있음");
				int no2 = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				System.out.println(	no2 + " " 
									+ title + " " 
									+ content + " " 
									+ writer);
				//검색결과를 검색화면 UI부분을 주어야 함
				bag = new BbsVO();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
			} else {
				System.out.println("검색결과 없음");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
	
	public void delete(int no) {
		
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공");

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// 자바는 부품조립식이라 String에 넣으면 걍 String인줄 앎
			// 그래서 SQL부품을 만들고 사용해야 함 => PreparedStatement
			String sql = "delete from hr.bbs where NO = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			ps.executeUpdate(); // insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(int no, String content) {
		
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공");
			
			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이라 String에 넣으면 걍 String인줄 앎
			//그래서 SQL부품을 만들고 사용해야 함 => PreparedStatement
			String sql = "update hr.bbs set content = ? where NO = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(2, no);
			ps.setString(1, content);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			ps.executeUpdate(); //insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(int no, String title, String content, String writer) {

		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공");

			// ipaddress ==> InetAddress
			// String url = "http://wwww.naver.com";
			// URL u = new URL(url);
			// 자바는 부품조립식이라 String에 넣으면 걍 String인줄 앎
			// 그래서 SQL부품을 만들고 사용해야 함 => PreparedStatement
			// public void insert(String id, String pw, String name, String tel)
			String sql = "insert into hr.bbs values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			// R빼고 인덱스는 0부터 시작
			// 유일하게 db는 인덱스가 1부터 시작
			ps.setInt(1, no); // ps.setInt(1, no);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, writer);
			// ==> insert into hr.member values ('a', 'a', 'a', 'a');
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			ps.executeUpdate(); // insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
