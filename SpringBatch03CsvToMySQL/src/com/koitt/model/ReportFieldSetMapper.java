package com.koitt.model;

import java.net.BindException;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class ReportFieldSetMapper implements FieldSetMapper<Report>{
	
	private SimpleDateFormat dataFormat;
	
	public ReportFieldSetMapper() {
		dataFormat = new SimpleDateFormat("MM/dd/yy");
	}
	
	@Override
	public Report mapFieldSet(FieldSet fieldSet){
		
		Report item = new Report();
		
		// MM/dd/YYYY 형식을 Date 클래스 타입으로 변경하여 저장
		String date = fieldSet.readString(0);
		try {
			item.setDate(dataFormat.parse(date));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		item.setImpressions(fieldSet.readInt(1));
		item.setClicks(fieldSet.readInt(2));
		item.setEarning(fieldSet.readDouble(3));
		
		return item;
	}

}
