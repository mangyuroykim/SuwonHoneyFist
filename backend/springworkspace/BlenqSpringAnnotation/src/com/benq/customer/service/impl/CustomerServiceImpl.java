package com.benq.customer.service.impl;

import java.util.List;

import com.benq.customer.domain.CustomerVO;
import com.benq.customer.service.CustomerService;
import com.benq.customer.store.CustomerStore;

public class CustomerServiceImpl implements CustomerService{

		private CustomerStore cStore;
		
		public CustomerServiceImpl() {}
		
		
		
	// 2. 생성자를 이용한 의존성 주입
	public CustomerServiceImpl(CustomerStore cStore) {
		this.cStore = cStore;
	}
	// 1. setter를 이용한 의존성 주입
			public void setStore(CustomerStore cStore) {
				this.cStore = cStore;
			}
	@Override
	public int insertCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerVO> selectList() {
		List<CustomerVO> cList = cStore.selectList();
		return cList;
	}

	@Override
	public CustomerVO selectOnebyId(String custmerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
