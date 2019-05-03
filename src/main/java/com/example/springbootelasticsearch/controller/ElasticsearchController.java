package com.example.springbootelasticsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootelasticsearch.service.ElasticsearchService;

@Controller
public class ElasticsearchController {

    @Autowired
    ElasticsearchService elasticsearchService;

    @RequestMapping("/user")
    public 	List<String> users(Model model) {
        model.addAttribute("users", elasticsearchService.search());

        List<String> list = new ArrayList<String>();
		list.add("太宰");
		list.add("夏目");
		return list;
    }

}