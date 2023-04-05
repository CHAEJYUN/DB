package 자바DB연결2;

import java.util.Scanner;

public class 게시판글수정하기 {

	public static void main(String[] args) {
		//입력으로 실행
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 no/content를 입력하세요");
		int no = sc.nextInt();
		String content = sc.next();
		BbsDAO dao = new BbsDAO();
		dao.update(no, content);
	} 

}
