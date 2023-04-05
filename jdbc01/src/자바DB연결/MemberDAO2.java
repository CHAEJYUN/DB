package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class MemberDAO2 {

	public int delete(String id) {
		
		int result = 0;
		
		try {
			//1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정성공");

			//2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공");

			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이라 String에 넣으면 걍 String인줄 앎
			//그래서 SQL부품을 만들고 사용해야 함 => PreparedStatement
			String sql = "delete from hr.member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			result = ps.executeUpdate(); // insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if(result >= 1) {
				System.out.println("회원탈퇴 성공");
			}
			//System.out.println(result);
		} catch (Exception e) {
//			result = 0;
//			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public int update(String id, String tel) {
		
		int result = 0;
		
		try {
			//1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			//2. 오라클 11g에 연결(java -- oracle)
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
			String sql = "update hr.member set tel = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, id);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			result = ps.executeUpdate(); //insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if(result >= 1) {
				System.out.println("회원수정 성공");
			}
			//System.out.println(result);
		} catch (Exception e) {
//			result = 0;
//			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public int insert(String id, String pw, String name, String tel) {
		
		int result = 0;
		
		try {
			//1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			//2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. 오라클 연결 성공");

			//ipaddress ==> InetAddress
			//String url = "http://wwww.naver.com";
			//URL u = new URL(url);
			//자바는 부품조립식이라 String에 넣으면 걍 String인줄 앎
			//그래서 SQL부품을 만들고 사용해야 함 => PreparedStatement
			//public void insert(String id, String pw, String name, String tel)
			String sql = "insert into hr.member values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			//R빼고 인덱스는 0부터 시작
			//유일하게 db는 인덱스가 1부터 시작
			ps.setString(1, id); // ps.setInt(1, no);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
			// ==> insert into hr.member values ('a', 'a', 'a', 'a');
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			result = ps.executeUpdate(); // insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if(result == 1) {
				System.out.println("회원가입 성공");
			}
			// System.out.println(result);
		} catch (Exception e) {
//			result = 0;
//			e.printStackTrace();
		}
		System.out.println(result);
		//return은 항상 마지막
		return result;
	}
	
}
