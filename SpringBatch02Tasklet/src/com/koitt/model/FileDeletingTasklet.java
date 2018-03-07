package com.koitt.model;

import java.io.File;
import java.rmi.UnexpectedException;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class FileDeletingTasklet implements Tasklet{

	private Resource directory;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		File dir = directory.getFile(); // 파일 객체가 나옴
		File[] files = dir.listFiles(); // 해당 디렉토리의 파일목록을 리턴받음
		for (int i = 0; i < files.length; i++){ // 목록을 하나씩 검사, 총 3바퀴
			boolean isDeleted = files[i].delete(); // 첫번째 파일에 딜리트 메소드를 호출하면 파일이 삭제됨
			if (!isDeleted) {
				throw new UnexpectedJobExecutionException(
						files[i].getPath() + " 파일을 삭제하지 못했습니다.");
			} else {
				System.out.println(files[i].getPath() + " 파일이 삭제되었습니다.");
			}
		}
		
		return RepeatStatus.FINISHED;
	}

	public Resource getDirectory() {
		return directory;
	}
	
	public void setDirectory(Resource directory) {
		this.directory = directory;
	}
}
