package colorchess;

import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ��ƽ��沼��
 * @author asus
 *
 */
public class WindowMenu extends Variable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��ȡ��Ļ��С
	static int pw=Toolkit.getDefaultToolkit().getScreenSize().width;
    static int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
    //ʹ�������
    static int winx=100;
    static int winy=100;
	public static WindowMenu instance = new WindowMenu("����ɫ����",winx,winy,pw-2*winx,ph-2*winy);
	public static int count;
	JPanel p1,p2,p3,p4,p5,p6;
	JLabel label1,label2,label3,label4,label5,label6;
	JButton button1,button2;
	JMenuBar menubar;
	JMenu menu1,menu2,menu3,menu4;
	JMenuItem item1,item2,item3,item4;
	ChessBoard board;
	private URL url1,url2; 
	private AudioClip ac,click;
	
	@SuppressWarnings("unused")
	private URL urlerror,urlcorrect; 
	@SuppressWarnings("unused")
	private  AudioClip error,correct;

	@SuppressWarnings("deprecation")
	public WindowMenu(String s ,int x ,int y ,int w ,int h) {
		//���ô�������
		setBounds(x,y,w,h);
		init();
		setVisible(true);
		setTitle(s);
		//����BGM
		File f1 = new File("src/colorchess/bgm.wav");
		  try {
		   url1= f1.toURL();
		} catch (MalformedURLException e) { 
		e.printStackTrace();
		}
        ac= Applet.newAudioClip(url1);
        //ѭ������
	    ac.loop();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@SuppressWarnings("deprecation")
	public void init() {
	//������Ұ�ť
		p1=new JPanel();
		p1.setBounds(0,0,900,900);
		p1.setBackground(new Color(200,200,200));
		p1.setLayout(null);
		board=new ChessBoard();
		board.setBounds(50,10,800,800);
		p1.add(board);
		button1=new JButton("���һ");
		button1.setFont(new Font("����",Font.BOLD, 20));
		button2=new JButton("��Ҷ�");
		button2.setFont(new Font("����",Font.BOLD, 20));
		button1.setBounds(150,820,100,50);
		button2.setBounds(650,820,100,50);
		p1.add(button1);
		p1.add(button2);
		add(p1);
	//��ʾ����������������
		p2=new JPanel();
		p2.setBounds(900,0,700,100);
		p2.setLayout(null);
		p2.setBackground(new Color(210,210,210));
		label1=new JLabel("��ǰ�������Ϊ��");
		label1.setBounds(5,25,350,50);
		label1.setFont(new Font("����",Font.BOLD, 25));
		label2=new JLabel("�ܲ���������0");
		label2.setBounds(355,25,350,50);
		label2.setFont(new Font("����",Font.BOLD, 25));
		add(p2);
		p2.add(label1);
		p2.add(label2);
	//���һ������
		p3=new JPanel();
		p3.setBounds(900,100,350,100);
		p3.setBackground(new Color(220,220,220));
		p3.setLayout(null);
		label3=new JLabel("���һ����Ϊ��");
		label3.setBounds(5,25,350,50);
		label3.setFont(new Font("����",Font.BOLD, 25));
		add(p3);
		p3.add(label3);
	//��Ҷ�������
		p4=new JPanel();
		p4.setBounds(1250,100,350,100);
		p4.setBackground(new Color(230,230,230));
		p4.setLayout(null);
		label4=new JLabel("��Ҷ�����Ϊ��");
		label4.setBounds(5,25,350,50);
		label4.setFont(new Font("����",Font.BOLD, 25));
		add(p4);
		p4.add(label4);
	//�¼���ʾ��
		p5=new JPanel();
		p5.setBounds(900,200,700,100);
		p5.setBackground(new Color(240,240,240));
		p5.setLayout(null);
		label5=new JLabel("��������ʾ��ǰ�¼�");
		label5.setBounds(5,25,350,50);
		label5.setFont(new Font("����",Font.BOLD, 25));
		add(p5);
		p5.add(label5);
	//ɫ������
		p6=new JPanel();
		p6.setBounds(900,300,700,600);
		p6.setBackground(new Color(250,250,250));
		p6.setLayout(null);
		add(p6);
		//����corret��Ч
				File f2 = new File("src/colorchess/correct.wav");
				try {
					url2= f2.toURL();
				} catch (MalformedURLException e) { 
					e.printStackTrace();
				}
				click= Applet.newAudioClip(url2);
				//�����Ѷ�������Ӧ�����İ�ť
				JButton C[][]=new JButton[4][m];
				for (i=0;i<=3;i++) {
					if(i==0) 
						//���úڰװ�ť
					    for(j=0;j<=1;j++) {
					    	if(j==0) {
					    		C[i][j]= new JButton("0��");
					    		C[i][j].setFont(new Font("����",Font.BOLD, 25));
						    	C[i][j].setForeground(Color.black);
						    }
					    	if(j==1) {
					    		C[i][j]= new JButton("-1��");
					    		C[i][j].setFont(new Font("����",Font.BOLD, 25));
						    	C[i][j].setForeground(Color.white);
					    	}
					    	C[i][j].setBackground(new Color(255-255*j,255-255*j,255-255*j));
					    	p6.add(C[i][j]);
					    	C[i][j].setBounds(1030, 370+j*350, 420, 70);
					    	C[i][j].addActionListener(new ActionListener() {
					    		@Override
					    		public void actionPerformed(ActionEvent e) {
					    			click.play();
					    			JButton GREEN=(JButton)e.getSource();
									bgc=GREEN.getBackground();
									r=bgc.getRed();
									g=bgc.getGreen();
									b=bgc.getBlue();
									WindowMenu.instance.label5.setText("r="+r+" g="+g+" b="+b);
					    			//if(e.getActionCommand().equals("C[i][j]"))
					    			//{r = 255-255*j; g =255-255*j; b = 255-255*j;}
					    		}
					        });
					    }
					else
						for(j=0;j<=m-1;j++) {
							int jj=j+1;
							C[i][j]= new JButton(+jj+"��");
							C[i][j].setFont(new Font("����",Font.BOLD, 25));
					    	C[i][j].setForeground(Color.white);
							//����λ�����ð�ť��ɫ
							if(i==1) {
								C[i][j].setBackground(new Color(255-50*j,0,0));
								p6.add(C[i][j]);
								//���ð�ť��״λ��
								C[i][j].setBounds(1030, 440+j*280/m, 140, 280/m);
								//���õ���¼���������rgbֵ
								C[i][j].addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										click.play();
										JButton RED=(JButton)e.getSource();
										bgc=RED.getBackground();
										r=bgc.getRed();
										g=bgc.getGreen();
										b=bgc.getBlue();
										WindowMenu.instance.label5.setText("r="+r+" g="+g+" b="+b);
										//if(e.getActionCommand().equals("C[i][j]"))
										//{r = 255-50*j; g =0; b = 0;}
										
									}
								});
							}
							if(i==2) {
								C[i][j].setBackground(new Color(0,255-50*j,0));
								p6.add(C[i][j]);
								C[i][j].setBounds(1170, 440+j*280/m, 140, 280/m);
								C[i][j].addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										click.play();
										JButton GREEN=(JButton)e.getSource();
										bgc=GREEN.getBackground();
										r=bgc.getRed();
										g=bgc.getGreen();
										b=bgc.getBlue();
										WindowMenu.instance.label5.setText("r="+r+" g="+g+" b="+b);
										//if(e.getActionCommand().equals("C[i][j]"))
										//{r = 0; g =255-50*j; b = 0;}
									}
						        });
						     }
							if(i==3) {
								C[i][j].setBackground(new Color(0,0,255-50*j));
								p6.add(C[i][j]);
								C[i][j].setBounds(1310, 440+j*280/m, 140, 280/m);
								C[i][j].addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										click.play();
										JButton BLUE=(JButton)e.getSource();
										bgc=BLUE.getBackground();
										r=bgc.getRed();
										g=bgc.getGreen();
										b=bgc.getBlue();
										WindowMenu.instance.label5.setText("r="+r+" g="+g+" b="+b);
										//if(e.getActionCommand().equals("C[i][j]"))
										//{r = 0; g =0; b = 255-50*j;}
						            }
						        });
						     }
						}
				}
		
		menubar=new JMenuBar();
		menu1=new JMenu("��Ϸ�Ѷ�");
		menu2=new JMenu("����˵��");
		menu3=new JMenu("��Ϸ����");
		menu4=new JMenu("������Ա");
		item1=new JMenuItem("��");
		item2=new JMenuItem("��ͨ");
		item3=new JMenuItem("����");
		item4=new JMenuItem("������Ա��  1.���⣺Ф����     2.�����ߣ�Ф�����������Ρ�лӦ껡���ΰ�h��֣ʫԨ");
		
		
		label1.setText("�����һ�Ȳ���");

		//������Ч
		File f1 = new File("src/colorchess/error.wav");
		try {
			urlerror= f1.toURL();
		} catch (MalformedURLException m2) { 
			m2.printStackTrace();
		}
		error= Applet.newAudioClip(urlerror);
		//����error��Ч
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(times%2==0) {
					WindowMenu.instance.label1.setText("��ǰ�������Ϊ�����һ");
					times++;
				} else {
					WindowMenu.instance.label1.setText("�벻Ҫ�ظ�����");
				} 
				WindowMenu.instance.label3.setText("���һ����Ϊ��"+point2);
				WindowMenu.instance.label4.setText("��Ҷ�����Ϊ��"+point1);
				WindowMenu.instance.label2.setText("�ܲ���������"+times);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(times%2==1) {
					WindowMenu.instance.label1.setText("��ǰ�������Ϊ����Ҷ�");
					times++;
				} else {
					WindowMenu.instance.label1.setText("�벻Ҫ�ظ�����");
				}
				WindowMenu.instance.label3.setText("���һ����Ϊ��"+point2);
				WindowMenu.instance.label4.setText("��Ҷ�����Ϊ��"+point1);
				WindowMenu.instance.label2.setText("�ܲ���������"+times);
			}
		});
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu4.add(item4);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		setJMenuBar(menubar);
		
		perpiece = new ChessBoard().perpiece;
		pn = new int[n][n];
		ps1 = new int[n][n];
		ps2 = new int[n][n];
		
	}
}