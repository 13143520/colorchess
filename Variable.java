package colorchess;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

/**
 * ʹ��������
 * @author asus
 *
 */
public class Variable extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//line ��	list ��	rgb ��ɫ
	static int line,list,n=6,r,g,b;
	static boolean up,down,left,right,itself;
	static int red[][] = new int[n][n];
	static int green[][] = new int[n][n];
	static int blue[][] = new int[n][n];
	//m ���̿��	j ɫ��
	static int m,i,j;
	static int times = 0;
	static Color bgc, oldcolor;
	static JButton[][] perpiece;
	static int[][] ps1;
	static int[][] ps2;
	static int[][] pn;
	static int blacknum1=3, blacknum2=3;
	static int point1 = 0;
	static int point2 = 0;
	static int point=0;
}