package colorchess;


import java.awt.Color;

import javax.swing.JButton;

/**
 * 获取格子色值，并进行判断是否与准备加入的值兼容
 * @author asus
 *
 */
public class Judge extends Variable{
	/**
	 * 
	 */
	
	boolean judge(int newLine, int newList) {
		if(newLine<0 || newList<0 || newList>=n || newLine >= n) {
			return true;
		} 
		Color newcolor = perpiece[newLine][newList].getBackground();
		int newred =newcolor.getRed();
		int newgreen = newcolor.getGreen();
		int newblue = newcolor.getBlue();
		if(r==0 && g==0 && b==0) {
			return true;
		} else if(newred==0 && newgreen==0 && newblue==0) {
			return true;
		} else if(newred==255 && newgreen==255 && newblue==255) {
			return false;
		} else if(newred==230 && newgreen==230 && newblue==230) {
			return true;
		} else if(newred==210 && newgreen==210 && newblue==210) {
			return true;
		} else if(newred > 0) {
			if(r > 0) {
				return false;
			} else if(!(r>=newred || g>=newred || b>=newred)) {
				return false;
			}
		} else if(newgreen > 0) {
			if(g > 0) {
				return false;
			} else if(!(r>=newgreen || g>=newgreen || b>=newgreen)) {
				return false;
			}
		} else if(newblue > 0) {
			if(b > 0) {
				return false;
			} else if(!(r>=newblue || g>=newblue || b>=newblue)) {
				return false;
			}
		}
		return true;
	}
}
