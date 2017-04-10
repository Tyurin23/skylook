package com.github.tyurin23.skylook.storage;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 19.02.17.
 */
@Configuration

public class ElasticConfig {

	@Bean
	public ElasticsearchTemplate elasticsearchTemplate() {
		return new ElasticsearchTemplate(NodeBuilder.nodeBuilder().local(true).node().client());
	}
}
