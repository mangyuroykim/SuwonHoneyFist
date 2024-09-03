package com.benq.customer.store;

import java.util.List;

import com.benq.customer.domain.CustomerVO;

public interface CustomerStore {
	/**
	 * �� ��� �޼ҵ�
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
	 * �� ���� ���� �޼ҵ�
	 * @param customerId
	 * @return int
	 */
	public int removeCustomer(String customerId);
	
	
	/**
	 * ������ ��ü��ȸ �޼ҵ�
	 * @return
	 */
	public List<CustomerVO>	selectList();
	
	/**
	 * ������ ��ȸ by Id
	 * @param custmerId
	 * @return customerVO
	 */
	public CustomerVO selectOnebyId(String custmerId);
}