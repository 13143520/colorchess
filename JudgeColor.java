package colorchess;

/**
 * 判断改格子是否可以上色
 * @author asus
 *
 */
public class JudgeColor extends Variable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean judgecolor(){
		if(new Judge().judge(line+1 ,list) && new Judge().judge(line-1 ,list) && new Judge().judge(line ,list+1) && new Judge().judge(line ,list-1)){
			if(new JudgeItself().judge()) {
				return true;
			}
		}
		return false;
	}
}