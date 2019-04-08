package com.xiaochen.crm.mapper;

import java.util.List;

import com.xiaochen.crm.pojo.BaseDict;
import com.xiaochen.crm.pojo.Customer;
import com.xiaochen.crm.pojo.QueryVo;

public interface CustomerDao {
	//查询总条数
	public Integer customerCount(QueryVo vo);
	//查询结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//根据id查询
	public Customer selectCustomerById(Integer id);
	//修改
	public void updateCustomerByCustome(Customer customer);
	public void deleteCustomerById(Integer id);
}
