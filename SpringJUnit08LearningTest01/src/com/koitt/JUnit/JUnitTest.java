package com.koitt.JUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/*
 * 학습 테스트란 무엇인가 :
 * 자신이 만들지 않은 프레임워크나 다른 개발팀에서 만들어서 제공한 라이브러리 등에
 * 대해서 테스트하는 것
 */

/*
 * 학습 테스트의 장점
 * 1. 다양한 조건에 따른 기능을 손쉽게 확인해 볼 수 있다
 * 2. 학습 테스트 코드를 개발 중에 참고할 수 있다
 * 3. 프레임워크나 제품을 업그레이드할 때 호환성 검증을 도와준다
 * 4. 테스트 작성에 대한 좋은 훈련이 된다
 * 5. 새로운 기술을 공부하는 과정이 즐거워진다..?
 */
public class JUnitTest {
	static JUnitTest testObject;
	
	@Test public void test1() {
		/*
		 * 현재 생성된 JUnitTest 객체 this와
		 * 이전에 생성한 JUnit
		 */
		assertThat(this, is(not(sameInstance(testObject))));
		
		testObject = this;
	}
	
	@Test public void test2() {
		assertThat(this, is(not(sameInstance(testObject))));
		
		testObject = this;
	}
	
	@Test public void test3() {
		assertThat(this, is(not(sameInstance(testObject))));
		
		testObject = this;
	}
}
