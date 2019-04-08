package com.xiaochen.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaochen.crm.common.Page;
import com.xiaochen.crm.mapper.CustomerDao;
import com.xiaochen.crm.pojo.Customer;
import com.xiaochen.crm.pojo.QueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	//通过四个条件，查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page=new Page<Customer>();
		page.setSize(5);
		vo.setSize(5);
		if(null!=vo) {
			//当前页
			if(null!=vo.getPage()) {
				page.setPage(vo.getPage());
				//每页的第一个
				vo.setStartRow((vo.getPage()-1)*vo.getSize()) ;
			}
			if(null!=vo.getCustName()&&!"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName());
			}
			if(null!=vo.getCustSource()&&!"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource());
			}
			if(null!=vo.getCustIndustry()&&!"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry());
			}
			if(null!=vo.getCustLevel()&&!"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel());
			}
		}
		page.setTotal(customerDao.customerCount(vo));
		page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		return page;
		
	}
	//到修改页面
	@Override
	public Customer selectCustomerById(Integer id) {
		
		return customerDao.selectCustomerById(id);
	}
	//修改
	@Override
	public void updateCustomerByCustome(Customer customer) {
		customerDao.updateCustomerByCustome(customer);
	}
	@Override
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
	}
}
