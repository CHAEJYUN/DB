package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import 화면DB연결.MemberVO;

public class MemberDAO3 {
	
public MemberVO one(String id) {
		
		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블
		//기본형은 정수, 실수, 문자, 논리만 값으로 초기화
		//나머지 데이터(참조형)은 주소가 들어가 있음
		//참조형 변수를 초기화 할 때는 null을 사용(주소가 없다라는 의미)
		MemberVO bag = null;
		
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
			String sql = "select * from hr.member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			rs = ps.executeQuery(); //select문 전송시 
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if(rs.next()) { //검색결과 여부는 rs.next()
				//true이면 있고, false면 없다는 의미
				System.out.println("검색결과 있음");
				String id2 = rs.getString(1); //id
				String pw = rs.getString(2); //pw
				String name = rs.getString(3); //name
				String tel = rs.getString(4); //tel
				System.out.println(	id2 + " " 
									+ pw + " " 
									+ name + " " 
									+ tel);
				//검색결과를 검색화면 UI부분을 주어야 함
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
			} else {
				System.out.println("검색결과 없음");
			}
			//System.out.println(result);
		} catch (Exception e) {
//			result = 0;
			e.printStackTrace();
		}
		//return id, pw, name, tel은 X
		//return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함
		//검색결과가 있을 때는 bag에 데이터가 들어있음
		//검색결과가 없을 때는 bag에 null이 들어가 있음
		return bag;
	}

	public int delete(MemberVO bag) {
		
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
			String sql = "delete from hr.member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
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

	public int update(MemberVO bag) {
		
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
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
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
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	
	public int insert(MemberVO bag) {
		
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
			// 유일하게 db는 인덱스가 1부터 시작
			ps.setString(1, bag.getId()); // ps.setInt(1, no);
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			//==> insert into hr.member values ('a', 'a', 'a', 'a');
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			result = ps.executeUpdate(); // insert, updqte, delete문만! sql 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if(result == 1) {
				System.out.println("회원가입 성공");
			}
			//System.out.println(result);
		} catch (Exception e) {
//			result = 0;
//			e.printStackTrace();
		}
		System.out.println(result);
		//return은 항상 마지막
		return result;
	}
	
}
