package com.xyc.crm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyc.crm.pojo.BaseDict;
import com.xyc.crm.pojo.Customer;
import com.xyc.crm.pojo.QueryVo;
import com.xyc.crm.service.BaseDictService;
import com.xyc.crm.service.CustomerService;
import com.xyc.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Resource
	private BaseDictService baseDictService;
	@Resource
	private CustomerService customerService;
	
	//客户来源
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	//客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	//客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	/**
	 * 显示用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String queryCustomerList(Model model,QueryVo queryVo) {
		//客户来源
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
		//所属行业
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
		//客户级别
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);
		// 把前端页面需要显示的数据放到模型中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		//解决get乱码
		if(org.apache.commons.lang3.StringUtils.isNotBlank(queryVo.getCustName())) {
			try {
				queryVo.setCustName(new String
						(queryVo.getCustName().getBytes("ISO-8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		//分页查询数据
		Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
		//把分页查询的结果放到模型中
		model.addAttribute("page", page);
		//数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		return "customer";
	}
	
	@RequestMapping("edit")
	//回显
	public @ResponseBody
	Customer queryCustomerById(Long id) {
		Customer customer = customerService.queryCustomerById(id);
		return customer;
	}
	
	@RequestMapping("update")
	public @ResponseBody
	String updateCustomerById(Customer customer) {
		//修改
		customerService.updateCustomerById(customer);
		return "OK";
	}
	
	@RequestMapping("delete")
	public @ResponseBody
	String deleteCustomerById(Long id) {
		//删除
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
