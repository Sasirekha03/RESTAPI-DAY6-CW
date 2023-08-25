package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Child;

import com.example.demo.service.ChildService;

@RestController
public class ApiController {
	
		
		@Autowired
		ChildService cs;
		
		
		@PostMapping("/")
		public boolean addndetails(@RequestBody List<Child> c)
		{
			cs.savedetails(c);
			return true;
		}
		
		@GetMapping("show")
		public List<Child> show()
		{
			return cs.showinfo();
		}
		
		
		
		//sorting
		@GetMapping("sort/{name}")
		public List<Child> getsortinfo(@PathVariable String name)
		{
			return cs.sortinfo(name);
		}
		
		
		@GetMapping("paging/{pageno}/{pagesize}")
		public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
		{
			return cs.getbypage(pageno, pagesize);
		}


	

}
