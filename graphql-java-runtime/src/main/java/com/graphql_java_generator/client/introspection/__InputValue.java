package com.graphql_java_generator.client.introspection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */

public class __InputValue  {

	@JsonProperty("name")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String name;


	@JsonProperty("description")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String description;


	@JsonProperty("type")
	@GraphQLNonScalar(graphQLTypeName = "__Type", javaClass = __Type.class)
	__Type type;


	@JsonProperty("defaultValue")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String defaultValue;



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setType(__Type type) {
		this.type = type;
	}

	public __Type getType() {
		return type;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

    public String toString() {
        return "__InputValue {"
				+ "name: " + name
				+ ", "
				+ "description: " + description
				+ ", "
				+ "type: " + type
				+ ", "
				+ "defaultValue: " + defaultValue
        		+ "}";
    }
}