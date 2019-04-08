package com.xiaochen.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaochen.crm.common.Page;
import com.xiaochen.crm.pojo.BaseDict;
import com.xiaochen.crm.pojo.Customer;
import com.xiaochen.crm.pojo.QueryVo;
import com.xiaochen.crm.service.BaseDictService;
import com.xiaochen.crm.service.CustomerService;

/**
 * 客户管理
 * @author 26631
 *
 */
@Controller
public class CustomerController {
	@Autowired 
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	//入口
	@RequestMapping(value="/customer/list.action")
	public String list(QueryVo vo,Model model) {
		List<BaseDict> industryType = baseDictService.selectBaseDictByCode("001");
		List<BaseDict> fromType = baseDictService.selectBaseDictByCode("002");
		List<BaseDict> levelType = baseDictService.selectBaseDictByCode("006");
		model.addAttribute("industryType",industryType);
		model.addAttribute("fromType",fromType);
		model.addAttribute("levelType",levelType);
		//根据四个查询条件进行查询
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "/customer";
	}
	//到修改页面
	@RequestMapping("/customer/edit.action")
	public @ResponseBody
	Customer Edit(Integer id) {
		return customerService.selectCustomerById(id);
	}
	//修改
	@RequestMapping("/customer/update.action")
	public @ResponseBody
	String update(Customer customer) {
		customerService.updateCustomerByCustome(customer);
		return "OK";
	}
	//删除
	@RequestMapping("/customer/delete.action")
	public @ResponseBody
	String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
		}
}
