package com.benq.customer.store;

import java.util.List;

import com.benq.customer.domain.CustomerVO;

public interface CustomerStore {
	/**
	 * 고객 등록 메소드
	 * @param customer
	 * @return int
	 */
	public int insertCustomer(CustomerVO customer);
	
	/**
	 * 
	 * @param customer
	 * @return int
	 */
	public int modifyCustomer(CustomerVO customer);

	
	/**
	 * 고객 정보 삭제 메소드
	 * @param customerId
	 * @return int
	 */
	public int removeCustomer(String customerId);
	
	
	/**
	 * 고객정보 전체조회 메소드
	 * @return
	 */
	public List<CustomerVO>	selectList();
	
	/**
	 * 고객정보 조회 by Id
	 * @param custmerId
	 * @return customerVO
	 */
	public CustomerVO selectOnebyId(String custmerId);
}