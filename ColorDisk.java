package colorchess;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorDisk extends Variable{
    /**
	 * ���׶ȴ��ڵ�����
	 */
	private static final long serialVersionUID = 1L;
	int t;
	JFrame jf1=new JFrame("�Ѷ�ѡ��");
	public ColorDisk(){
		//���ô�������
	    jf1.setLayout(null);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
	    jf1.setResizable(false);
	    //��ȡ��Ļ��С
	    int sw=Toolkit.getDefaultToolkit().getScreenSize().width;
	    int sh=Toolkit.getDefaultToolkit().getScreenSize().height;
	    //���ô����С
	    int ww=320;
	    int wh=135;
	    //ʹ�������
	    int wx=(sw-ww)/2;
	    int wy=(sh-wh)/2;
	    jf1.setBounds(wx, wy, ww, wh);
	    //�������׶�
	    JButton mode[]= new JButton [3];
    	mode[0]=new JButton("��");
    	mode[1]=new JButton("��ͨ");
    	mode[2]=new JButton("����");
	    for(t=0;t <= 2;t++) {
	    	//��ť��������
	    	mode[t].setFont(new Font("΢���ź�",Font.BOLD,14));
	    	mode[t].setBounds(20+t*90,25,80,50);
	    	jf1.add(mode[t]);
	    	//��Ӱ�ť������ȡ���׶�
	    	
			mode[t].addActionListener(new ActionListener() {
	        	 @Override
		         public void actionPerformed(ActionEvent e) {
		             if(e.getActionCommand().equals("��")) {m = 2;n=4;}
		             else if(e.getActionCommand().equals("��ͨ")) {m = 3;n=6;}
		             else {m = 4;n=10;}
	            	 jf1.dispose();
	            	 @SuppressWarnings("unused")
	            	 WindowMenu win = WindowMenu.instance;
	        	 }
	        });
    	}
	}
}

