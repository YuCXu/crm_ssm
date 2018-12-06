package com.xyc.crm.service;

import com.xyc.crm.pojo.Customer;
import com.xyc.crm.pojo.QueryVo;
import com.xyc.crm.utils.Page;

public interface CustomerService {
	
	/**
	 * 根据条件分页查询客户
	 * @param queryVo
	 * @return
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	public Customer queryCustomerById(Long id);
	/**
	 * 根据id更新用户
	 * @param customer
	 */
	public void updateCustomerById(Customer customer);
	/**
	 * 根据id删除客户
	 * @param id
	 */
	public void deleteCustomerById(Long id);
}
