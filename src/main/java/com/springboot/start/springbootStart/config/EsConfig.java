package com.springboot.start.springbootStart.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
public class EsConfig {

	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${spring.data.elasticsearch.cluster-name}")
	private String EsClusterName;

	@Bean
	public Client client() throws Exception {

		Settings esSettings = Settings.builder().put("cluster.name", EsClusterName).build();

		TransportClient client=new PreBuiltTransportClient(esSettings);
		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
		return client;
		
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
