package model;

public class LoginLogic {
	//入力されたパスワードが正しいかどうか判定するメソッド
	public boolean execute(User user) {
	    if (user.getPass().equals("1234")) {//パスワードは全員1234
	      return true;
	    }
	    return false;
	}
}
