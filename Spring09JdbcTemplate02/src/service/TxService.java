package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TxDao;
import model.Job;

@Service	// Service 클래스를 빈 객체로 만들고 싶을때는 @Service 애노테이션 사용
@Transactional	// 특별한 경우엔 아래와 같이 Annotation을 붙이고 보통은 이렇게 클래스 자체에 Annotation을 붙여준다
public class TxService {

	@Autowired
	private TxDao dao;
	
	@Transactional	// 해당 메소드에 트랜젝션 처리를 하겠다는것, 오류가 났을때 입력한 값은 반영하지 않고 정상적으로 실행했을때의 값으로 자동으로 입력해줌
	public void save(Job job) {
		dao.update(job);	//업데이트와 인설트가 실행됬을때에만 정상적으로 save 메소드가 실행되는것
		//job.setJobId(job.getJobId() + "_");	// 첫번째 실행 시 활성화
		job.setJobId(job.getJobId());		// 두번째 실행 시 활성화
		dao.insert(job);
	}
}
