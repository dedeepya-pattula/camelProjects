package com.camel.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camel.sql.Employee;

@Service
public class EmployeeServiceImpl extends RouteBuilder {

	@Autowired
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String KAFKA_ENDPOINT = "kafka:%s?brokers=localhost:9092";

	@Override
	public void configure() throws Exception {

		// Insert Route
		//from("direct:insert")

		from("direct:post").toF(KAFKA_ENDPOINT, "emp-topic");

		fromF(KAFKA_ENDPOINT, "emp-topic").process(new insert())
		.to("jdbc:dataSource")
		.end()
		.to("direct:update")
		.to("direct:delete");

		//for get details
		from("direct:select").setBody(constant("select * from employee")).to("jdbc:dataSource");
		
		from("direct:update").setBody(constant("update employee set empName='harsha' where empName='deepu'"))
		.to("jdbc:datasource");
		
		
		from("direct:delete").setBody(constant("delete from employee where empName='sai'"))
		.to("jdbc:datasource");

	}

}