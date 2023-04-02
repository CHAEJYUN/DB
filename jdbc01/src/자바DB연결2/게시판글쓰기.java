package 자바DB연결2;

import java.util.Scanner;

public class 게시판글쓰기 {

	public static void main(String[] args) {
		//입력으로 실행
		Scanner sc = new Scanner(System.in);
		System.out.println("no/title/content/writer 순으로 입력하세요");
		int no = sc.nextInt();
		String title = sc.next();
		String content = sc.next();
		String writer = sc.next();
		BbsDAO dao = new BbsDAO();
		dao.insert(no, title, content, writer);
	}

}
