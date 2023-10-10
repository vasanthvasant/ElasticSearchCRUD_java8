package com.elasticSearch.crud.configuration;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.apache.http.HttpHost;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
@Configuration
public class StudentConfiguration {
	@Bean
    public RestClient getRestClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost("162.55.210.42", 9200)).build();
       
        return restClient;
    }
	



    @Bean
    public ElasticsearchRestTemplate elasticsearchTemplate() {
            return new ElasticsearchRestTemplate(new RestHighLevelClient(RestClient.builder(
                new HttpHost("162.55.210.42", 9200))));
    }
    

}
