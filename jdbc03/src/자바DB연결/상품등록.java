package 자바DB연결;

import java.util.Scanner;

import 화면DB연결.ProductVO;

public class 상품등록 {

	public static void main(String[] args) {
		//입력으로 실행
		Scanner sc = new Scanner(System.in);
		System.out.println("id/name/content를 입력하세요");
		
		String id = sc.next();
		String name = sc.next();
		String content = sc.next();
		
		//1. 가방을 만들어주자
		ProductVO bag = new ProductVO();
		
		//2. 가방에 데이터를 넣어주자 ==> set
		bag.setId(id);
		bag.setName(name);
		bag.setContent(content);
		
		//3. 가방을 전달하자
		ProductDAO dao = new ProductDAO();
		dao.insert(bag);
	}

}
