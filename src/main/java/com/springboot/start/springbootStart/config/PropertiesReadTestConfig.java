package com.springboot.start.springbootStart.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@PropertySource(value="test-read-properties.properties")
@ConfigurationProperties(prefix="spring.th")
@Getter
@Setter
public class PropertiesReadTestConfig {
	
	private Integer id;
	
	private Map<String, Object> testMap;
	
	private List<String> host;

}
