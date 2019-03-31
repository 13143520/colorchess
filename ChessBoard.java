package colorchess;

import java.awt.*;
import javax.swing.*;

/**
 * Ë¢ÐÂÆåÅÌ
 * @author asus
 *
 */
public class ChessBoard extends JPanel{
	private static final long serialVersionUID = 1L;
	GridLayout grid;
	JPanel chessboard;
	Method listener;
	JButton[][] perpiece;
  
	public ChessBoard(){
		init();
		setVisible(true);
	}
	
	void init(){
		int n;
		n=Variable.n;
		chessboard=new JPanel();
		grid = new GridLayout(n,n);
		chessboard.setLayout(grid);
		perpiece=new JButton[n][n];
		for(int line=0;line<n;line++){
			for (int list=0;list<n;list++){
				JButton button = new JButton();
				button.setText("(" + line + "," + list + ")");
				perpiece[line][list]=button;
					if((line+list)%2==0) 
						perpiece[line][list].setBackground(new Color(210,210,210));
					else
						perpiece[line][list].setBackground(new Color(230,230,230));
					perpiece[line][list].setPreferredSize(new Dimension(800/n,800/n));
					listener=new Method();
					perpiece[line][list].addActionListener(listener) ;	
					chessboard.add(perpiece[line][list]);
					
			}
		}
		add(chessboard);
	}
}





