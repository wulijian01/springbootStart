package com.springboot.start.springbootStart.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.springboot.start.springbootStart.es.UserIndex;

@Repository
public interface UserEsRepository extends ElasticsearchRepository<UserIndex, Long>{

	
}
