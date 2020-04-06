

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawGUI{
	JFrame frame;
	Container main_Pane;
	NumberColor NC = new NumberColor();
	/**Position 선언*/
	North N;
	Center C;
	East E;
	
	/**FrameSize*/
	Toolkit tk = Toolkit.getDefaultToolkit(); //구현된 Toolkit객체를 얻는다
	Dimension screenSize = tk.getScreenSize(); //화면의 크기를 구한다.
	int mainFrame_x = 650,mainFrame_y=410;
	ClearDialog clear_dialog;
	/**방위*/
	class Position {
		JPanel main;
		/*생성자*/
		public Position() {
			this.main = new JPanel();
		}
		void drawPanel(JPanel panel){} //그리기
		void setFont(){}
	}
	/**북쪽*/
	class North extends Position{
		/*Panel 선언*/
		JPanel p_title;
		JPanel p_score1;
		JPanel p_score2;
		/*Layout 선언*/
		FlowLayout l_main;
		FlowLayout l_title;
		FlowLayout l_score1;
		FlowLayout l_score2;
		/*Label 선언*/
		JLabel title;
		JLabel score1;
		JLabel score2;
		
		/*생성자*/
		public North() {
			super();
			/*panel 생성*/
			this.p_title = new JPanel();
			this.p_score1 = new JPanel();
			this.p_score2 = new JPanel();
			/*layout 생성*/
			this.l_main = new FlowLayout();
			this.l_title = new FlowLayout();
			this.l_score1 = new FlowLayout();
			this.l_score2 = new FlowLayout();
			/*Label 생성*/
			this.title = new JLabel("이공사팔");
			this.score1 = new JLabel("SCORE　:　");
			this.score2 = new JLabel("0");
			/*layout 설정*/
			this.main.setLayout(this.l_main);
			this.p_title.setLayout(this.l_title);
			this.p_score1.setLayout(this.l_score1);
			this.p_score2.setLayout(this.l_score2);
			
			/*panel 배치*/
			this.main.add(this.p_title);
				this.p_title.add(this.title);
			this.main.add(this.p_score1);
				this.p_score1.add(this.score1);
			this.main.add(this.p_score2);
				this.p_score2.add(this.score2);
				
			setFont();
		}
		void setScore(int score){
			this.score2.setText(""+score);
		}
		void setFont(){
			Font f_title = new Font("맑은 고딕",Font.BOLD,50);
			Font f_score = new Font("맑은 고딕",Font.BOLD,20);
			/*panel 색 설정*/
//			this.p_title.setBackground(new Color(100,100,100));
//			this.p_score1.setBackground(new Color(120,120,120));
//			this.p_score2.setBackground(new Color(200,200,200));
			/*label 글자색 설정*/
			this.title.setForeground(Color.WHITE);
			this.score1.setForeground(Color.WHITE);
			this.score2.setForeground(Color.WHITE);
			/*label 폰트 설정*/
			this.title.setFont(f_title);
			this.score1.setFont(f_score);
			this.score2.setFont(f_score);
		}
	}
	/**중앙*/
	class Center extends Position{
		/*panel 선언*/
		JPanel p_block[][] = new JPanel[4][4];
		/*Layout 선언*/
		GridLayout l_main;
		FlowLayout l_block[][] = new FlowLayout[4][4];
		/*label 선언*/
		JLabel num[][] = new JLabel[4][4];
		
		
		public Center() {
			/* panel 생성 */
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					p_block[i][j] = new JPanel();
			/*Layout 선언*/
			this.l_main = new GridLayout(4, 4);
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					this.l_block[i][j] = new FlowLayout();
			/*label 선언*/
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					this.num[i][j] = new JLabel("0");
				
			/*Layout 설정*/
			this.main.setLayout(this.l_main);
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					this.p_block[i][j].setLayout(this.l_block[i][j]);
			/*panel 배치*/
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++){
						this.main.add(this.p_block[i][j]);
							this.p_block[i][j].add(this.num[i][j]);
				}
			setFont();
			
		}
		void setFont(){
			/*panel 배경색 설정*/
			int r=200,g=200,b=200;
			int x=3;
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++){
					p_block[i][j].setBackground(new Color(r,g,b));
					r += x;
					g += x;
					b += x;
				}
			/*lable 폰트 설정*/
			Font f_num = new Font("맑은 고딕",Font.BOLD,40);
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					num[i][j].setFont(f_num);
			
			/*정렬*/
//			for (int i = 0; i < 4; i++)
//				for (int j = 0; j < 4; j++)
//					num[i][j].setVerticalAlignment(0);
		}
	}
	/**동쪽*/
	class East extends Position{
		JPanel p_btn;
		JButton b_replay;
		FlowLayout l_main;
		FlowLayout l_btn;
		public East() {
			
			p_btn = new JPanel();
			b_replay = new JButton("다시시작.");
			l_btn = new FlowLayout();
			l_main = new FlowLayout();
			
			main.setLayout(l_main);
			p_btn.setLayout(l_btn);
			
			main.add(p_btn);
			p_btn.add(b_replay);
			
			b_replay.setFocusable(false);
		}
		
		
	}
	
	/**생성자 GUI 생성/선언*/
	public DrawGUI() {
		/*Fosition 생성*/
		N = new North();
		C = new Center();
		E = new East();
		/*GUI생성*/
		frame = new JFrame("WORK CHART Program"); // 타이틀 바에 표시되는 문자열
		frame.setLocation(screenSize.width/2 - mainFrame_x/2
				, screenSize.height/2 - mainFrame_y/2);// 윈도우의 위치 지정 x좌표, y좌표
		frame.setPreferredSize(new Dimension(mainFrame_x, mainFrame_y));// 윈도우의 크기 넓이,높이

		main_Pane = frame.getContentPane();// contentPane 을 호출
		
		setNumberColor();
	}
	/**Main Frame 배치*/
	void setFrame(){
		main_Pane.add(N.main,BorderLayout.NORTH);
		main_Pane.add(C.main,BorderLayout.CENTER);
		main_Pane.add(E.main,BorderLayout.EAST);
		clear_dialog = new ClearDialog();
	}
	/**GUI 종료*/
	void endGUI(){
		setNumberColor();
		setZero();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x버튼 이벤트
		frame.pack();// 프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true);// 이 프레임을 디스플레이 하는 메소드
	}
	/**set block*/
	void setBlock(int x,int y,int number){
		C.num[x][y].setText(number+"");
		setZero();
	}
	/**block 최신화*/
	void updateBlock(int i, int j, int number){
		C.num[j][i].setText(number+"");
		setNumberColor();
		setZero();
		frame.setVisible(true);
	}
	/**숫자별 색 설정*/
	void setNumberColor(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				C.num[i][j].setForeground(NC.getColor(Integer.parseInt(C.num[i][j].getText())));
			}
		}
	}
	/**0 색 제거*/
	void setZero(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if((C.num[i][j].getText()).equals("0"))
					C.num[i][j].setVisible(false);
				else
					C.num[i][j].setVisible(true);
			}
		}
	}
	/**게임 깸*/
	void gameClear(int score,int dividing){
		
		System.out.println("끝나라!"+score);
		clear_dialog.setScore(score, dividing);
		clear_dialog.showDialog();
	}
	class ClearDialog{
		Dialog dialog;
		
		JPanel p_dialog_north;
		JPanel p_dialog_south;
		
		JPanel p_final_score1;
		JPanel p_final_score2;
		
		BorderLayout l_dialog;
		FlowLayout l_final_score1;
		FlowLayout l_final_score2;
		
		JLabel final_score1;
		JLabel final_score2;
		JButton b_ok;
		public ClearDialog() {
			/*다이얼로그 생성*/
			dialog = new JDialog(frame,"GAME CLEAR",true);
			dialog.setSize(600,220);//크기 
			dialog.setLocation(screenSize.width/2-300,screenSize.height/2-110);
			dialog.setMinimumSize(new Dimension(600,220));
			
			/*panel생성*/
			p_final_score1 = new JPanel();
			p_final_score2 = new JPanel();
			p_dialog_north = new JPanel();
			p_dialog_south = new JPanel();
			/*layout생성*/
			l_dialog = new BorderLayout();
			l_final_score1 = new FlowLayout();
			l_final_score2 = new FlowLayout();
			/*layout셋팅*/
			dialog.setLayout(l_dialog);
			p_final_score1.setLayout(l_final_score1);
			p_final_score2.setLayout(l_final_score2);
			/*Label생성*/
			final_score1 = new JLabel("총 움직인 횟수　:　");
			final_score2 = new JLabel("0　번");
			/*button생성*/
			b_ok = new JButton("확인");
			/*panel배치*/
			dialog.add(p_dialog_north,BorderLayout.NORTH);
				p_dialog_north.add(p_final_score1);
					p_final_score1.add(final_score1);
				p_dialog_north.add(p_final_score2);
					p_final_score2.add(final_score2);
			dialog.add(p_dialog_south,BorderLayout.SOUTH);
				p_dialog_south.add(b_ok);
				
			/*button listener*/
			b_ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dialog.setVisible(false);
				}
			});
			/*폰트*/
			Font f_dialog = new Font("맑은 고딕",Font.BOLD,40);
			final_score1.setFont(f_dialog);
			final_score2.setFont(f_dialog);
		}
		void setScore(int score,int dividing){
			final_score2.setText((score/dividing)+"　번");
		}
		void showDialog(){
			dialog.setVisible(true);
		}
	}
	
	/**updateScore*/
	void updateScore(int score){
		N.score2.setText(score+"");
		frame.setVisible(true);
	}
	void setScore(int score){
		N.score2.setText(score+"");
		frame.setVisible(true);
	}

}
