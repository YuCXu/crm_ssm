package com.xyc.crm.mapper;

import java.util.List;

import com.xyc.crm.pojo.Customer;
import com.xyc.crm.pojo.QueryVo;

public interface CustomerMapper {
	
	/**
	 * 根据queryVo分页查询数据
	 * @param queryVO
	 * @return
	 */
	public List<Customer> queryCustomerByQueryVo(QueryVo queryVO);
	/**
	 * 根据queryVo查询数据条数
	 * @param queryVo
	 * @return
	 */
	public Integer queryCountByQueryVo(QueryVo queryVo);
	
	/**
	 * 根据id查找用户
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
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteCustomerById(Long id);
}
