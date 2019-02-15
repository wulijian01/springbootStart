package com.springboot.start.springbootStart;

import java.util.Optional;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.start.springbootStart.es.UserIndex;
import com.springboot.start.springbootStart.repository.UserEsRepository;

@RunWith(value = SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
public class EsTest {
	
	@Autowired
	private UserEsRepository userEsRepository;
	
	@Test
	public void test11() {
		
		FilterFunctionBuilder[] functions = {
		        new FunctionScoreQueryBuilder.FilterFunctionBuilder(
		        		QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("nickName", "test")),                 
		        		ScoreFunctionBuilders.weightFactorFunction(1000)),                    
		        new FunctionScoreQueryBuilder.FilterFunctionBuilder(
		        		QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("des", "test")),
		        		ScoreFunctionBuilders.weightFactorFunction(1000))      
		};
		QueryBuilder qb = QueryBuilders.functionScoreQuery(functions);

		SearchQuery searchQuery = new NativeSearchQueryBuilder()

				.withQuery(qb).build();

		Optional<UserIndex> findById = userEsRepository.findById(41L);

		UserIndex user = findById.get();
		
		System.out.println(user.getNickName());
	}

}
