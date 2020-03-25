package com.graphql_java_generator.client.domain.forum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class QueryTypeTopics {

	public static final String NAME = "topics";

	@JsonDeserialize(contentAs = Topic.class)
	@JsonProperty("topics")
	List<Topic> topics;

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Topic> getTopics() {
		return topics;
	}
	
    public String toString() {
        return "QueryTypeTopics {topics: " + topics + "}";
    }
}
