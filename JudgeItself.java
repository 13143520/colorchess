package colorchess;

import java.awt.Color;

import javax.swing.JButton;

/**
 * 获取该格子色值
 * @author asus
 *
 */
public class JudgeItself extends Variable{
	/**
	 * 
	 */
	
	boolean judge() {
		if(times%2 == 0 && r==0&&g==0&&b==0&&blacknum1==0) {
			return false;
		} else if(times%2 ==1 &&r==0&&g==0&&b==0&&blacknum2==0){
			return false;
		} else if (r==0&&g==0&&b==0){
			if(pn[line][list]==3){
				return true;
			}
		} else if(pn[line][list] >= 2) {
			return false;
		} 
		
		int newred =oldcolor.getRed();
		int newgreen = oldcolor.getGreen();
		int newblue = oldcolor.getBlue();
		
		
		if(newred==255 && newgreen==255 && newblue==255) {
			return false;
		} else if(newred==230 && newgreen==230 && newblue==230) {
			return true;
		} else if(newred==210 && newgreen==210 && newblue==210) {
			return true;
		} else if(newred > 0) {
			if(r > 0) {
				return false;
			}
		} else if(newgreen > 0) {
			if(g > 0) {
				return false; 
			}
		} else if(newblue > 0) {
			if(b > 0) {
				return false;
			}
		}
		return true;
	}
}
