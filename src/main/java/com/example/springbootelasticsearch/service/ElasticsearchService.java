package com.example.springbootelasticsearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootelasticsearch.domain.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ElasticsearchService {

	@Autowired
    private RestHighLevelClient client;
	
    public List<Test> search() {
    	List<Test> result = new ArrayList<>();
    	
    	SearchRequest searchRequest = new SearchRequest("library"); 
    	SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
    	searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
    	searchRequest.source(searchSourceBuilder); 

        try {
        	SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        	ObjectMapper mapper = new ObjectMapper();
        	for (SearchHit hit : searchResponse.getHits()) {
        		Test test = mapper.readValue(hit.getSourceAsString(), Test.class);
        		result.add(test);
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }       
    	return result;
    }
}