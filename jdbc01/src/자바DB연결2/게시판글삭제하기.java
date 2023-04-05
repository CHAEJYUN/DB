package 자바DB연결2;

import java.util.Scanner;

public class 게시판글삭제하기 {

	public static void main(String[] args) {
		//입력으로 실행
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 no를 입력하세요");
		int no = sc.nextInt();
		BbsDAO dao = new BbsDAO();
		dao.delete(no);
	}

}
