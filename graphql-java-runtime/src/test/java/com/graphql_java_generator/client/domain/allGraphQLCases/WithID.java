package com.graphql_java_generator.client.domain.allGraphQLCases;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInterfaceType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;

import java.util.Date;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "__typename", visible = true)
		@JsonSubTypes({ @Type(value = AllFieldCases.class, name = "AllFieldCases"), @Type(value = Human.class, name = "Human"), @Type(value = Droid.class, name = "Droid") })
@GraphQLInterfaceType("WithID")
public interface WithID  {

	@GraphQLScalar(graphQLTypeName = "ID", javaClass = String.class)
	public void setId(String id);

	@GraphQLScalar(graphQLTypeName = "ID", javaClass = String.class)
	public String getId();

	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	public void set__typename(String __typename);

	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	public String get__typename();
}
