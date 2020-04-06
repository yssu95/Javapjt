
public class Maps {
	/**변수**/
	int score = 0;
	
	Map M[][] = new Map[4][4];	//맵 선언
	public Maps() {
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				M[i][j] = new Map(i,j);	//맵 생성
			}
		}
	}
	/**Map**/
	class Map{
		private int x;
		private int y;
		
		private int number;
		public Map(int x,int y) {
			this.number = 0;
			this.x = x;
			this.y = y;
		}
		//맵 클리어
		void clearMap(){
			number = 0;
		}
		//숫자 변경
		void setNumber(int n){
			number = n;
		}
		int getNumber(){
			return number;
		}
		boolean onN(){
			if(number == 0)
			return false;
			else return true;
		}
		
	}
	/**방향키**/
	boolean upKey() {/*위로*/
		boolean check = true;
		
		/**
		 * 수 더하기 로직
		 * CASE1. Main 값이 첫번째 블록일 경우
		 * CASE2. Main 이전 블록의 값이 있는 경우
		 * CASE3. Main 이전 블록의 값이 없지만 0번째 블록 인 경우 -> 계속
		 * CASE4. Main 이전 블록이 없고 0번째도 아닌 경우 -> 계속**/
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(M[i][j].onN()){//해당 죄표에 값이 있으면
					for (int n = j + 1; n < 4; n++) {
						if (M[i][n].onN()) { // 다음 좌표 값이 0이 아니고
							if (M[i][j].getNumber() == M[i][n].getNumber()) { // 숫자가 같으면
								if (j != 0) {// Main 값이 첫번째 블록이 아닌경우 참
									for (int m = j; m >= 0; m--) {// Main값부터 0까지 하나씩 줄어든다
										if (m != 0) { // 가리키는 값이 첫번째 블록이 아닐 경우
											if (M[i][m - 1].onN()) {// CASE2.Main 이전 블록의 값이 있는경우
												check = false;
												M[i][m].setNumber(M[i][j].getNumber() + M[i][n].getNumber());
												if(m!=j)
													M[i][j].clearMap();
												M[i][n].clearMap();
												break;
											}
										} else {// CASE1. 가리키는 값이 첫번째 블록일 경우
												// <-CASE3,CASE4가 결국엔 이리로 온다
											check = false;
											M[i][m].setNumber(M[i][j].getNumber() + M[i][n].getNumber());
											if(m!=j)
												M[i][j].clearMap();
											M[i][n].clearMap();
											break;
										}
									}
								} else {// CASE1. Main 값이 첫번째 블록일 경우
									check = false;
									M[i][j].setNumber(M[i][j].getNumber() + M[i][n].getNumber());
									M[i][n].clearMap();
								}break;
							}else break;
						}
					}
				}
			}
		}
		/**
		 * 위로 당기기 로직**/
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				/*해당 블록에 숫자가 없으면*/
				if(!M[i][j].onN()){
					for(int n=j;n<4;n++){
						if(M[i][n].onN()){
							check = false;
							M[i][j].setNumber(M[i][n].getNumber());
							M[i][n].clearMap();
							break;
						}
					}
				}
			}
		}
		return check;
	}
	boolean downKey() {/*아래로*/
		boolean check = true;
		/**
		 * 수 더하기 로직
		 * CASE1. Main 값이 첫번째 블록일 경우
		 * CASE2. Main 이전 블록의 값이 있는 경우
		 * CASE3. Main 이전 블록의 값이 없지만 0번째 블록 인 경우 -> 계속
		 * CASE4. Main 이전 블록이 없고 0번째도 아닌 경우 -> 계속**/
		for(int i=0;i<4;i++){
			for(int j=3;j>=0;j--){
				if(M[i][j].onN()){//해당 죄표에 값이 있으면
					for (int n = j - 1; n >= 0; n--) {
						if (M[i][n].onN()) { // 다음 좌표 값이 0이 아니고
							if (M[i][j].getNumber() == M[i][n].getNumber()) { // 숫자가 같으면
								if (j != 3) {// Main 값이 첫번째 블록이 아닌경우 참
									for (int m = j; m < 4; m++) {// Main값부터 0까지 하나씩 줄어든다
										if (m != 3) { // 가리키는 값이 첫번째 블록이 아닐 경우
											if (M[i][m + 1].onN()) {// CASE2.Main 이전 블록의 값이 있는경우
												check = false;
												M[i][m].setNumber(M[i][j].getNumber() + M[i][n].getNumber());
												if(m!=j)
													M[i][j].clearMap();
												M[i][n].clearMap();
												break;
											}
										} else {// CASE1. 가리키는 값이 첫번째 블록일 경우
												// <-CASE3,CASE4가 결국엔 이리로 온다
											check = false;
											M[i][m].setNumber(M[i][j].getNumber() + M[i][n].getNumber());
											if(m!=j)
												M[i][j].clearMap();
											M[i][n].clearMap();
											break;
										}
									}
								} else {// CASE1. Main 값이 첫번째 블록일 경우
									check = false;
									M[i][j].setNumber(M[i][j].getNumber() + M[i][n].getNumber());
									M[i][n].clearMap();
								}break;
							}else break;
						}
					}
				}
			}
		}
		/**
		 * 아래로 당기기 로직**/
		for(int i=0;i<4;i++){
			for(int j=3;j>=0;j--){
				/*해당 블록에 숫자가 없으면*/
				if(!M[i][j].onN()){
					for(int n=j;n>=0;n--){
						if(M[i][n].onN()){
							check = false;
							M[i][j].setNumber(M[i][n].getNumber());
							M[i][n].clearMap();
							break;
						}
					}
				}
			}
		}
		return check;
	}
	boolean leftKey() {/*옆으로*/
		boolean check = true;
		/**
		 * 수 더하기 로직
		 * CASE1. Main 값이 첫번째 블록일 경우
		 * CASE2. Main 이전 블록의 값이 있는 경우
		 * CASE3. Main 이전 블록의 값이 없지만 0번째 블록 인 경우 -> 계속
		 * CASE4. Main 이전 블록이 없고 0번째도 아닌 경우 -> 계속**/
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(M[i][j].onN()){//해당 죄표에 값이 있으면
					for (int n = i + 1; n < 4; n++) {
						if (M[n][j].onN()) { // 다음 좌표 값이 0이 아니고
							if (M[i][j].getNumber() == M[n][j].getNumber()) { // 숫자가 같으면
								if (i != 0) {// Main 값이 첫번째 블록이 아닌경우 참
									for (int m = i; m >= 0; m--) {// Main값부터 0까지 하나씩 줄어든다
										if (m != 0) { // 가리키는 값이 첫번째 블록이 아닐 경우
											if (M[m-1][j].onN()) {// CASE2.Main 이전 블록의 값이 있는경우
												check = false;
												M[m][j].setNumber(M[i][j].getNumber() + M[n][j].getNumber());
												if(m!=i)
													M[i][j].clearMap();
												M[n][j].clearMap();
												break;
											}
										} else {// CASE1. 가리키는 값이 첫번째 블록일 경우
												// <-CASE3,CASE4가 결국엔 이리로 온다
											check = false;
											M[m][j].setNumber(M[i][j].getNumber() + M[n][j].getNumber());
											if(m!=i)
												M[i][j].clearMap();
											M[n][j].clearMap();
											break;
										}
									}
								} else {// CASE1. Main 값이 첫번째 블록일 경우
									check = false;
									M[i][j].setNumber(M[i][j].getNumber() + M[n][j].getNumber());
									M[n][j].clearMap();
								}break;
							}else break;
						}
					}
				}
			}
		}
		/**
		 * 좌측 당기기 로직**/
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				/*해당 블록에 숫자가 없으면*/
				if(!M[i][j].onN()){
					for(int n=i;n<4;n++){
						if(M[n][j].onN()){
							check = false;
							M[i][j].setNumber(M[n][j].getNumber());
							M[n][j].clearMap();
							break;
						}
					}
				}
			}
		}
		return check;
	}
	boolean rightKey() {/*그 옆의 반대로*/
		boolean check = true;
		/**
		 * 수 더하기 로직
		 * CASE1. Main 값이 첫번째 블록일 경우
		 * CASE2. Main 이전 블록의 값이 있는 경우
		 * CASE3. Main 이전 블록의 값이 없지만 0번째 블록 인 경우 -> 계속
		 * CASE4. Main 이전 블록이 없고 0번째도 아닌 경우 -> 계속**/
		for(int i=3;i>=0;i--){
			for(int j=0;j<4;j++){
				if(M[i][j].onN()){//해당 죄표에 값이 있으면
					for (int n = i - 1; n >= 0; n--) {
						if (M[n][j].onN()) { // 다음 좌표 값이 0이 아니고
							if (M[i][j].getNumber() == M[n][j].getNumber()) { // 숫자가 같으면
								if (i != 3) {// Main 값이 첫번째 블록이 아닌경우 참
									for (int m = i; m < 4; m++) {// Main값부터 0까지 하나씩 줄어든다
										if (m != 3) { // 가리키는 값이 첫번째 블록이 아닐 경우
											if (M[m+1][j].onN()) {// CASE2.Main 이전 블록의 값이 있는경우
												check = false;
												M[m][j].setNumber(M[i][j].getNumber() + M[n][j].getNumber());
												if(m!=i)
													M[i][j].clearMap();
												M[n][j].clearMap();
												break;
											}
										} else {// CASE1. 가리키는 값이 첫번째 블록일 경우
												// <-CASE3,CASE4가 결국엔 이리로 온다
											check = false;
											M[m][j].setNumber(M[i][j].getNumber() + M[n][j].getNumber());
											if(m!=i)
												M[i][j].clearMap();
											M[n][j].clearMap();
											break;
										}
									}
								} else {// CASE1. Main 값이 첫번째 블록일 경우
									check = false;
									M[i][j].setNumber(M[i][j].getNumber() + M[n][j].getNumber());
									M[n][j].clearMap();
								}break;
							}else break;
						}
					}
				}
			}
		}
		/**
		 * 우측 당기기 로직**/
		for(int i=3;i>=0;i--){
			for(int j=0;j<4;j++){
				/*해당 블록에 숫자가 없으면*/
				if(!M[i][j].onN()){
					for(int n=i;n>=0;n--){
						if(M[n][j].onN()){
							check = false;
							M[i][j].setNumber(M[n][j].getNumber());
							M[n][j].clearMap();
							break;
						}
					}
				}
			}
		}
		return check;
	}
	
	
	/**Score I/O**/
	void setScore(int score){
		this.score += score;
	}
	int getScore(){
		return score;
	}
	/**게임clear*/
	boolean gameClear(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(M[i][j].getNumber() == 2048)
					return true;
			}
		}
		return false;
	}
	/**score*/
	void updateScore(int score){
		setScore(score);
	}
	void clearAll(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				M[i][j].setNumber(0);
			}
		}
	}
}
