package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
		business.setSomeDataService(new SomeDataServiceOneValueStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
		}
}
