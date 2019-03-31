package colorchess;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 生成棋盘
 * @author asus
 *
 */
public class Mode extends Variable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private URL url2; 
	private AudioClip click;
	JPanel p = new JPanel();
	@SuppressWarnings("deprecation")
	public Mode(){
		//载入音效
		File f2 = new File("src/colorchess/correct.wav");
		  try {
		   url2= f2.toURL();
		} catch (MalformedURLException e) { 
		e.printStackTrace();
		}
        click= Applet.newAudioClip(url2);
		//根据难度制作相应个数的按钮
		JButton C[][]=new JButton[4][m];
		for (i=0;i<=3;i++) {
			if(i==0) 
				//设置黑白按钮
			    for(j=0;j<=1;j++) {
				C[i][j]= new JButton();
				C[i][j].setBackground(new Color(255-255*j,255-255*j,255-255*j));
				p.add(C[i][j]);
				C[i][j].setBounds(25, 20+j*350, 420, 70);
				C[i][j].addActionListener(new ActionListener() {
		        	 @Override
			         public void actionPerformed(ActionEvent e) {
		        		 click.play();
			             if(e.getActionCommand().equals("C[i][j]"))
			             {r = 255-255*j; g =255-255*j; b = 255-255*j;}
			            }
			        });
			}
			else
				for(j=0;j<=m-1;j++) {
				C[i][j]= new JButton();
				//根据位置设置按钮颜色
				if(i==1) {
				C[i][j].setBackground(new Color(255-50*j,0,0));
				p.add(C[i][j]);
				//设置按钮形状位置
				C[i][j].setBounds(25, 90+j*280/m, 140, 280/m);
				//设置点击事件监听返回rgb值
				C[i][j].addActionListener(new ActionListener() {
		        	 @Override
			         public void actionPerformed(ActionEvent e) {
		        		 click.play();
			             if(e.getActionCommand().equals("C[i][j]"))
			             {r = 255-50*j; g =0; b = 0;}
			            }
			        });
			     }
				if(i==2) {
					C[i][j].setBackground(new Color(0,255-50*j,0));
					p.add(C[i][j]);
					C[i][j].setBounds(165, 90+j*280/m, 140, 280/m);
					C[i][j].addActionListener(new ActionListener() {
			        	 @Override
				         public void actionPerformed(ActionEvent e) {
			        		 click.play();
				             if(e.getActionCommand().equals("C[i][j]"))
				             {r = 0; g =255-50*j; b = 0;}
				            }
				        });
				     }
				if(i==3) {
					C[i][j].setBackground(new Color(0,0,255-50*j));
					p.add(C[i][j]);
					C[i][j].setBounds(305, 90+j*280/m, 140, 280/m);
					C[i][j].addActionListener(new ActionListener() {
			        	 @Override
				         public void actionPerformed(ActionEvent e) {
			        		 click.play();
				             if(e.getActionCommand().equals("C[i][j]"))
				             {r = 0; g =0; b = 255-50*j;}
			            }
			        });
			     }
			}
		}
	}
}