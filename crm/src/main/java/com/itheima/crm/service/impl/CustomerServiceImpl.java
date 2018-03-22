package com.itheima.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerRepository;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.service.CustomerService;

/**
 * ClassName:CustomerServiceImpl <br/>
 * Function: <br/>
 * Date: 2018年3月19日 下午3:42:00 <br/>
 */

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@Override
	public List<Customer> findByUnAssociated() {

		return customerRepository.findByFixedAreaIdIsNull();

	}

	@Override
	public List<Customer> findByAssociated(String fixedAreaId) {

		return customerRepository.findByFixedAreaId(fixedAreaId);
	}

	@Override
	public void bindCustomer2FixedArea(String fixedAreaId, Long[] customerIds) {

		if (StringUtils.isNotEmpty(fixedAreaId)) {
			customerRepository.unbindByFixedAreaId(fixedAreaId);

			if (customerIds != null && customerIds.length > 0) {
				for (Long id : customerIds) {
					customerRepository.bindFixedAreaIdById(fixedAreaId, id);
				}
			}
		}
	}
}
