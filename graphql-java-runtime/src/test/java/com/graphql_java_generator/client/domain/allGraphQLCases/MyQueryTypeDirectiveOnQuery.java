package com.graphql_java_generator.client.domain.allGraphQLCases;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class MyQueryTypeDirectiveOnQuery {

	public static final String NAME = "directiveOnQuery";

	@JsonDeserialize(contentAs = String.class)
	@JsonProperty("directiveOnQuery")
	List<String> directiveOnQuery;

	public void setDirectiveOnQuery(List<String> directiveOnQuery) {
		this.directiveOnQuery = directiveOnQuery;
	}

	public List<String> getDirectiveOnQuery() {
		return directiveOnQuery;
	}
	
    public String toString() {
        return "MyQueryTypeDirectiveOnQuery {directiveOnQuery: " + directiveOnQuery + "}";
    }
}
