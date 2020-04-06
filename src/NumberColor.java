import java.awt.Color;

public class NumberColor {
	MyColor MC[] = new MyColor[12];	
	class MyColor{
		int n;
		Color c;
	}
	public NumberColor() {
		for(int i=0;i<12;i++)
			MC[i] = new MyColor();
		MC[0].n = 0;
		MC[1].n = 2;
		MC[2].n = 4;
		MC[3].n = 8;
		MC[4].n = 16;
		MC[5].n = 32;
		MC[6].n = 64;
		MC[7].n = 128;
		MC[8].n = 256;
		MC[9].n = 512;
		MC[10].n = 1024;
		MC[11].n = 2048;
		MC[0].c = new Color( 255, 255, 255 );
		MC[1].c = new Color( 0, 0, 0 );
		MC[2].c = new Color( 0, 128, 0 );
		MC[3].c = new Color( 255, 255, 0 );
		MC[4].c = new Color( 9, 82, 217 );
		MC[5].c = new Color( 131, 77, 0 ); 
		MC[6].c = new Color( 128, 0, 128 );
		MC[7].c = new Color( 0, 255, 0 );
		MC[8].c = new Color( 16, 181, 181 );
		MC[9].c = new Color( 255, 0, 82 );
		MC[10].c = new Color( 62, 21, 148 );
		MC[11].c = new Color( 255, 0, 0 );
	}
	Color getColor(int num){
		int i;
		switch(num){
		case 0: i = 0; break;
		case 2: i = 1; break;
		case 4: i = 2; break;
		case 8: i = 3; break;
		case 16: i = 4; break;
		case 32: i = 5; break;
		case 64: i = 6; break;
		case 128: i = 7; break;
		case 256: i = 8; break;
		case 512: i = 9; break;
		case 1024: i = 10; break;
		case 2048: i = 11; break;
		default :i=0;
		}
		return MC[i].c;
	}
}
