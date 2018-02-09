package bean;

import org.springframework.stereotype.Component;

@Component("engDao")	// bean 이름을 "endDao"라 정의한 것과 같다
public class EngMessageDaoImpl implements MessageDao{

	@Override
	public String getMessage() {
		return "Hello. Nice to meet ya";
	}

}
