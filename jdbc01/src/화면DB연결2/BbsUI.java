package 화면DB연결2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결2.BbsDAO;

public class BbsUI {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setTitle("나의 게시판");
		f.setSize(500, 810);
		
		JLabel l1 = new JLabel("   나의 게시판   ");
		JLabel lll = new JLabel("-----------------------");		
		JLabel l2 = new JLabel("게시판 ID");
		JLabel l3 = new JLabel("게시판 제목");
		JLabel l4 = new JLabel("게시판 내용");
		JLabel l5 = new JLabel("게시판 작성자");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		
		JButton b1 = new JButton("게시물 작성 완료");
		JButton b2 = new JButton("게시물 삭제 완료");
		JButton b3 = new JButton("게시물 검색 완료");

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.err.println("게시물 검색 처리");
				String no = t1.getText();
				int no2 = Integer.parseInt(no);

				BbsDAO dao = new BbsDAO();
				BbsVO bag = dao.one(no2); // MemberVO
				if (bag != null) {
					t2.setText(bag.getTitle());
					t3.setText(bag.getContent());
					t4.setText(bag.getWriter());
					t2.setBackground(Color.pink);
					t3.setBackground(Color.pink);
					t4.setBackground(Color.pink);
				} else {
					JOptionPane.showMessageDialog(f, "검색결과 없음");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
			}
		});

		//물흐르듯이 붙여주는 부품이 필요
		FlowLayout flow = new FlowLayout();
		
		//폰트를 설정하기 위해 font부품 필요 
		Font font0 = new Font("돋움", Font.BOLD, 50);
		Font font = new Font("돋움", Font.BOLD, 40);
		
		//////////// 필요한 부품(객체)를 ram에 가져다 놓고, 준비 끝 ///////
		f.setLayout(flow);
		
		f.add(l1); f.add(lll);
		f.add(l2); f.add(t1);
		f.add(l3); f.add(t2);
		f.add(l4); f.add(t3);
		f.add(l5); f.add(t4);
		f.add(b1); f.add(b2);f.add(b3);
		
		l1.setFont(font0);
		lll.setFont(font0);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		
		t1.setForeground(Color.blue);
		t2.setForeground(Color.blue);
		t3.setForeground(Color.blue);
		t4.setForeground(Color.blue);

		b1.setBackground(Color.yellow); //배경색
		b1.setForeground(Color.red);  //글자색
		b2.setBackground(Color.yellow);
		b2.setForeground(Color.red);
		b3.setBackground(Color.yellow);
		b3.setForeground(Color.red);
		
		b1.setBorderPainted(false);
		
		f.getContentPane().setBackground(Color.green);
		
		//맨 끝으로
		f.setVisible(true);
	}

}
