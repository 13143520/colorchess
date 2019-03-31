package colorchess;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorDisk extends Variable{
    /**
	 * 难易度窗口的设置
	 */
	private static final long serialVersionUID = 1L;
	int t;
	JFrame jf1=new JFrame("难度选择");
	public ColorDisk(){
		//设置窗体属性
	    jf1.setLayout(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
	    jf1.setResizable(false);
	    //获取屏幕大小
	    int sw=Toolkit.getDefaultToolkit().getScreenSize().width;
	    int sh=Toolkit.getDefaultToolkit().getScreenSize().height;
	    //设置窗体大小
	    int ww=320;
	    int wh=135;
	    //使窗体居中
	    int wx=(sw-ww)/2;
	    int wy=(sh-wh)/2;
	    jf1.setBounds(wx, wy, ww, wh);
	    //设置难易度
	    JButton mode[]= new JButton [3];
    	mode[0]=new JButton("简单");
    	mode[1]=new JButton("普通");
    	mode[2]=new JButton("困难");
	    for(t=0;t <= 2;t++) {
	    	//按钮属性设置
	    	mode[t].setFont(new Font("微软雅黑",Font.BOLD,14));
	    	mode[t].setBounds(20+t*90,25,80,50);
	    	jf1.add(mode[t]);
	    	//添加按钮监听获取难易度
	    	
			mode[t].addActionListener(new ActionListener() {
	        	 @Override
		         public void actionPerformed(ActionEvent e) {
		             if(e.getActionCommand().equals("简单")) {m = 2;n=4;}
		             else if(e.getActionCommand().equals("普通")) {m = 3;n=6;}
		             else {m = 4;n=10;}
	            	 jf1.dispose();
	            	 @SuppressWarnings("unused")
	            	 WindowMenu win = WindowMenu.instance;
	        	 }
	        });
    	}
	}
}

