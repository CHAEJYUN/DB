package 자바DB연결;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class 반환값받아오기 {

	public static void main(String[] args) {
//		전화기 tel = 전화기();
//		tel.인터넷하다();
//		tel.전화통화하다();
		반환값연습 re = new 반환값연습(); //메서드 12개
		re.add2();
		
		int result1 = re.add(200,100);
		System.out.println(result1);
		
//		String data = JOptionPane.showInputDialog("입력"); //"aaa"
//		String data2 = JOptionPane.showMessageDialog(null, "출력값"); //void
		
		double result2 = re.add(22.1,10);
		System.out.println(result2);
		
		String result3 = re.add("나는", "천재");
		System.out.println(result3);
		
		String result4 = re.add(1, "번 천재");
		System.out.println(result4);
		
		int[] result5 = re.add(); //{1,2,3}
		result5[0] = 100;
		System.out.println(result5[0]);
		System.out.println(result5[1]);
		System.out.println(result5[2]);
		
		Date result6 = re.getDate();
		//실행했을 때의 년월일시분초요일
		System.out.println(result6.getMinutes());
		System.out.println(result6.getSeconds());
		//요일 0 : 일요일부터
		System.out.println(result6.getDay());
		//==> 리턴이 없는 값은 프린트 불가
		//==> result6.getMinutes()는 리턴이 있어서 프린트 가능
		
		int result7 = re.GetHour();
		System.out.println(result7 + "시 입니다.");
		
		int result8 = re.getRandom2();
		System.out.println("랜덤 정수는 " + result8);
		
		ArrayList result9 = re.getlist();
		System.out.println(result9.get(0) + " " + result9.get(1));
		result9.set(0, "양파"); //0번 인덱스의 값 양파로
		System.out.println(result9);
		
		HashSet result10 = re.getSet();
		System.out.println(result10);
	}

}
