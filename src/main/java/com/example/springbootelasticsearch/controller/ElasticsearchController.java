package com.example.springbootelasticsearch.controller;

import com.example.springbootelasticsearch.domain.Population;
import com.example.springbootelasticsearch.domain.Test;
import com.example.springbootelasticsearch.service.ElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ElasticsearchController {

  @Autowired ElasticsearchService elasticsearchService;

  @RequestMapping("/")
  @ResponseBody
  public List<Test> users() {

    return elasticsearchService.search();
  }

  @RequestMapping("/population")
  @ResponseBody
  public List<Population> population() {

    return elasticsearchService.population();
  }
}
