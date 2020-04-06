import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainGame {
	Maps Ms = new Maps();
	DrawGUI GUI = new DrawGUI();
	
	int score = 10;
	int count = 0;
	char cheatkey[] = {'q','u','d','f','i','d','W','k','d'};
	char insertkey[] = new char[9];

	public static void main(String[] args) {
		new MainGame();
	}
	/**생성자*/
	public MainGame() {
		GUI.setFrame();
		keyEvent();
		addNum();
		addNum();
		
		OnButton On = new OnButton();
		GUI.E.b_replay.addActionListener(On);
		GUI.endGUI();
	}
	/**숫자 생성*/
	void addNum(){
		Random rand = new Random();
		int x,y;
		int num = rand.nextInt(5);
		int add_num;
		
		/*확률*/
		switch(num){
		case 0:
			add_num = 4;
			break;
		default:
			add_num = 2;
			break;
		}
		
		/*랜덤 블록*/
		do{
			x = rand.nextInt(4);
			y = rand.nextInt(4);
			System.out.println("x:"+x+", y:"+y+" number:"+add_num);
			
		}while(Ms.M[x][y].onN());
		
		Ms.M[x][y].setNumber(add_num);
		GUI.setBlock(y, x, add_num);
	}
	/**KeyEvent*/
	void keyEvent(){
		OnKeyListener on_key = new OnKeyListener();
		GUI.frame.addKeyListener(on_key);
		GUI.E.b_replay.addKeyListener(on_key);
	}
	/**게임 조작 리스너*/
	class OnKeyListener implements KeyListener{
		int key;
		boolean check = true;
		public OnKeyListener() {
		}
		/*누름*/
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				System.out.println("위");
				check = Ms.upKey();
				if(!check){
					updateBlock();
					showConsol();
					addNum();
					score();
				}
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("아래");
				check = Ms.downKey();
				if(!check){
					updateBlock();
					showConsol();
					addNum();
					score();
				}
					
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("왼쪽");
				check = Ms.leftKey();
				if(!check){
					updateBlock();
					showConsol();
					addNum();
					score();
				}
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("오른쪽");
				check = Ms.rightKey();
				if(!check){
					updateBlock();
					showConsol();
					addNum();
					score();
				}
				break;
			}
			gameClear();
		}
		/*눌렀다 땠을때*/
		public void keyTyped(KeyEvent e) {
			key = e.getKeyChar();
			System.out.println("key 누름 : "+key);
			insertkey[count++] = e.getKeyChar();
			
			for(int i=0;i<count;i++)
				if(insertkey[i] != cheatkey[i])
					count = 0;
				else if(count == 9 && insertkey[i] == cheatkey[i]){
					score = 100;
				}
			if(count >=9)
				count = count%9;
		}
		/*땔대*/
		public void keyReleased(KeyEvent e) {
			
		}
	}
	/**동쪽버튼 리스너*/
	class OnButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			replay();
		}
	}
	/**다시시작*/
	void replay() {
		Ms.clearAll();
		addNum();
		addNum();
		
		updateBlock();
		
		GUI.setZero();
		
		score = 10;
		Ms.score = 0;
		GUI.setScore(0);
	
	}
	/**GUI업데이트*/
	void updateBlock(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				GUI.updateBlock(i, j, Ms.M[i][j].getNumber());
			}
		}
	}
	/**consol창 출력*/
	void showConsol(){
		for(int j=0;j<4;j++){
			for(int i=0;i<4;i++){
				System.out.print(Ms.M[i][j].getNumber()+" ");
			}
			System.out.println();
		}
	}
	/**score*/
	void score(){
		Ms.updateScore(score);
		GUI.updateScore(Ms.getScore());
	}
	/**게임over*/
	void gameOver(){
		
	}
	/**게임clear*/
	void gameClear(){
		boolean clear = Ms.gameClear();
		if(clear){
			GUI.gameClear(Ms.getScore(),score);
			replay();
		}
	}
	/***/
}
