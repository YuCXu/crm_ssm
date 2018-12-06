package com.xyc.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyc.crm.mapper.CustomerMapper;
import com.xyc.crm.pojo.Customer;
import com.xyc.crm.pojo.QueryVo;
import com.xyc.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		//设置查询条件，从哪一条数据开始查
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
		
		Page<Customer> page = new Page<Customer>();
		//封装当页面
		page.setPage(queryVo.getPage());
		//封装每页显示的数据条数
		page.setSize(queryVo.getSize());
		//封装总页数
		Integer total = customerMapper.queryCountByQueryVo(queryVo);
		page.setTotal(total);
		//封装每页显示的信息数
		List<Customer> list = customerMapper.queryCustomerByQueryVo(queryVo);
		page.setRows(list);
		
		return page;
	}

	@Override
	//根据id查询客户
	public Customer queryCustomerById(Long id) {
		Customer customer = customerMapper.queryCustomerById(id);
		return customer;
	}

	@Override
	//根据id更新客户
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

	@Override
	//根据id删除客户
	public void deleteCustomerById(Long id) {
		customerMapper.deleteCustomerById(id);
	}

}
