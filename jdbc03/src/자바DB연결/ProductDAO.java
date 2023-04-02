package 자바DB연결;

import 화면DB연결.ProductVO;

public class ProductDAO {
	//CRUD 기능 메서드 만들어주기
	public void insert(ProductVO bag) {
		//1. 가방이 전달되면 저장
		//2. 필요할 때 가방에서 꺼내기
		System.out.println(bag.getId());
		System.out.println(bag.getName());
		System.out.println(bag.getContent());
	}
	
}
