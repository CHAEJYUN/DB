package 자바DB연결2;

import java.util.Scanner;

import javax.swing.JOptionPane;

import 화면DB연결2.BbsVO;

public class 게시판1개검색 {
	
	public static void main(String[] args) {
		//입력으로 실행
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 id를 입력하세요");
		
		int no = sc.nextInt();

		BbsDAO dao = new BbsDAO();
		BbsVO bag = dao.one(no);
		String total = bag.getNo() + ", " +
					   bag.getTitle() + ", " +
				       bag.getContent() + ", " +
					   bag.getWriter();
		JOptionPane.showMessageDialog(null, total);
	}

}
