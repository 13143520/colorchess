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
	 * ���׶ȴ��ڵ�����
	 */
	private static final long serialVersionUID = 1L;
	int t;
	JFrame jf1=new JFrame("��Ϸ����");
	public Game(){
		//���ô�������
	    jf1.setLayout(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
	    jf1.setResizable(false);
	    //��ȡ��Ļ��С
	    int sw=Toolkit.getDefaultToolkit().getScreenSize().width;
	    int sh=Toolkit.getDefaultToolkit().getScreenSize().height;
	    //���ô����С
	    int ww=300;
	    int wh=500;
	    //ʹ�������
	    int wx=(sw-ww)/2;
	    int wy=(sh-wh)/2;
	    jf1.setBounds(wx, wy, ww, wh);
	    //�������׶�
	    final JLabel label = new JLabel("·��:");
        label.setBounds(60, 20, 50, 25);
        label.setVisible(true);
        jf1.add(label);
        
	}
}

