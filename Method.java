package colorchess;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 监听棋盘
 * @author asus
 *
 */
public class Method extends Variable implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private URL urlerror,urlcorrect; 
	private  AudioClip error,correct;
	@SuppressWarnings("deprecation")

	public void actionPerformed(ActionEvent e) {
		if(times%2==0 && point==0){
		} else if (!(times%2==0 && point==0)){
		} else {
			return;
		}
			
		boolean judge;
		JButton button=(JButton)e.getSource();
		String name=button.getText(); //取出按钮的名字
		line = Integer.parseInt(String.valueOf(name.charAt(1)));//获得line数值
		list = Integer.parseInt(String.valueOf(name.charAt(3)));//获得list数值
		WindowMenu.instance.label5.setText("点击了"+name);
		oldcolor = button.getBackground();
		//判断是否可以上色并处理
		JudgeColor jc = new JudgeColor();
		judge = jc.judgecolor();
		if(judge==true) { 
			//给空格上色
			if(r==0 && g==0 && b==0) {
				if(times%2 == 0) {
					blacknum1--;
				} else {
					blacknum2--;
				}
				if(pn[line][list]==0) {
					button.setBackground(new Color(r,g,b));
					perpiece[line][list] = button;
					if(times%2 == 0) {
						point1 = point1 -1;
					} else {
						point2 = point2 -1;
					}
					ps1[line][list] = 0;
					ps2[line][list] = 0;
				} else {
					button.setBackground(new Color(0,0,0));
					perpiece[line][list] = button;
					if(times%2 == 0) {
						point1 = point1 -1;
					} else {
						point2 = point2 -1;
					}
					point1 = point1 - ps1[line][list];
					point2 = point2 - ps2[line][list];
				}
			} else if(pn[line][list]==1) {
				button.setBackground(new Color(r+oldcolor.getRed(),g+oldcolor.getGreen(),b+oldcolor.getBlue()));
				perpiece[line][list] = button;
				if(times%2 == 0) {
					if(r==255&&g==255&&b==255) {
						ps1[line][list] += 0;
					}else {
						point1 += (305-(r+g+b))/50;
						ps1[line][list] += (305-(r+g+b))/50;
					}
					
				} else {
					if(r==255&&g==255&&b==255) {
						ps2[line][list] += 0;
					}else {
						point2 += (305-(r+g+b))/50;
						ps2[line][list] += (305-(r+g+b))/50;
					}
					
				}
				
			} else {
				button.setBackground(new Color(r,g,b));
				perpiece[line][list] = button;
				if(times%2 == 0) {
					if(r==255&&g==255&&b==255) {
						point1 += 0;
						ps1[line][list] = 0;
						ps2[line][list] = 0;
					}else {
						point1 += (305-(r+g+b))/50;
						ps1[line][list] = (305-(r+g+b))/50;
						ps2[line][list] = 0;
					}

				} else {
					if(r==255&&g==255&&b==255) {
						point2 += 0;
						ps1[line][list] = 0;
						ps2[line][list] = 0;
					} else {
					point2 += (305-(r+g+b))/50;
					ps1[line][list] = 0;
					ps2[line][list] = (305-(r+g+b))/50;
					}
				}
			}

			pn[line][list]+= 1;
			
			//载入correct音效
			File f1 = new File("src/colorchess/correct.wav");
			try {
				urlcorrect= f1.toURL();
			} 
			catch (MalformedURLException m1) { 
				m1.printStackTrace();
			}
			correct= Applet.newAudioClip(urlcorrect);
			//播放correct音效
			correct.play();
		}
		else {
			//载入error音效
			File f1 = new File("src/colorchess/error.wav");
			try {
				urlerror= f1.toURL();
			} 
			catch (MalformedURLException m2) { 
				m2.printStackTrace();
			}
			error= Applet.newAudioClip(urlerror);
			//播放error音效
			error.play();
		}

		
	}
}