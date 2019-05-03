package com.example.springbootelasticsearch.service;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchService {

    public String search() {

    	RestHighLevelClient client = new RestHighLevelClient(
    	        RestClient.builder(
    	                new HttpHost("localhost", 9200, "http"),
    	                new HttpHost("localhost", 9201, "http"),
    	                new HttpHost("localhost", 9202, "http")));
    	
    	SearchRequest searchRequest = new SearchRequest(); 
    	SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
    	searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
    	searchRequest.source(searchSourceBuilder); 

        try {
        	SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        	RestStatus status = searchResponse.status();
        	SearchHits searchHits = searchResponse.getHits();
        	
        	System.out.println(status);
        	System.out.println(searchHits);
        	System.out.println("AAA");

            for (SearchHit hit : searchHits) {
            	System.out.println(hit.getSourceAsString());
            }
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    	return "AVC";
    }
}