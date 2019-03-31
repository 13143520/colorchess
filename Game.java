package colorchess;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends Variable{
    /**
	 * 难易度窗口的设置
	 */
	private static final long serialVersionUID = 1L;
	int t;
	JFrame jf1=new JFrame("游戏规则");
	public Game(){
		//设置窗体属性
	    jf1.setLayout(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
	    jf1.setResizable(false);
	    //获取屏幕大小
	    int sw=Toolkit.getDefaultToolkit().getScreenSize().width;
	    int sh=Toolkit.getDefaultToolkit().getScreenSize().height;
	    //设置窗体大小
	    int ww=300;
	    int wh=500;
	    //使窗体居中
	    int wx=(sw-ww)/2;
	    int wy=(sh-wh)/2;
	    jf1.setBounds(wx, wy, ww, wh);
	    //设置难易度
	    final JLabel label = new JLabel("路径:");
        label.setBounds(60, 20, 50, 25);
        label.setVisible(true);
        jf1.add(label);
        
	}
}

