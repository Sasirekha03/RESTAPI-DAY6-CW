package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {
	
	@Autowired
	ChildRepo cr;
	
	public Child saveinfo(Child c) 
	{
		return cr.save(c);
	}
	
	public List<Child> showinfo()
	{
		return cr.findAll();
	}
	public List<Child> savedetails(List<Child> c)
	{
		return (List<Child>)cr.saveAll(c);
	}
	public List<Child> sortinfo(String s)
	{
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	public List<Child> getbypage(int pgno,int pgsize)
	{
		Page<Child> p =cr.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	} 

	
	
	

}
