package com.graphql_java_generator.client.domain.forum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class QueryTypeNbBoards {

	public static final String NAME = "nbBoards";

	@JsonProperty("nbBoards")
	Integer nbBoards;

	public void setNbBoards(Integer nbBoards) {
		this.nbBoards = nbBoards;
	}

	public Integer getNbBoards() {
		return nbBoards;
	}
	
    public String toString() {
        return "QueryTypeNbBoards {nbBoards: " + nbBoards + "}";
    }
}
