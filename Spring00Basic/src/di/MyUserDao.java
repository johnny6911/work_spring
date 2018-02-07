package di;

import java.util.Hashtable;
import java.util.Map;

// My회사에서 UserDao 인터페이스를 전달해서 My회사에서 각 메소드를 구현한 것
public class MyUserDao implements UserDao{

	Map<Integer, User> table = new Hashtable<Integer, User>();
	
	@Override
	public void insert(User user) {
		table.put(user.getId(), user);
	}

	@Override
	public User select(int id) { //해당 id값으로 해당 유저를 불러옴
		return table.get(id);
	}

}
