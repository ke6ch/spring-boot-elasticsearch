package com.example.springbootelasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {
	
	@Value("${elasticsearch.host}")
	private String host;
	
    @Value("${elasticsearch.port01}") 
    private int port01;

    @Value("${elasticsearch.port02}") 
    private int port02;

    @Value("${elasticsearch.port03}") 
    private int port03;

    
	@Bean
	public RestHighLevelClient client() {
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost(host, port01),
						new HttpHost(host, port02),
						new HttpHost(host, port03)));
        return client;
	}
	
}