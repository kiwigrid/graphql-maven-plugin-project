package com.graphql_java_generator.client.domain.allGraphQLCases;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class MyQueryTypeABreak {

	public static final String NAME = "aBreak";

	@JsonProperty("aBreak")
	_break aBreak;

	public void setABreak(_break aBreak) {
		this.aBreak = aBreak;
	}

	public _break getABreak() {
		return aBreak;
	}
	
    public String toString() {
        return "MyQueryTypeABreak {aBreak: " + aBreak + "}";
    }
}
