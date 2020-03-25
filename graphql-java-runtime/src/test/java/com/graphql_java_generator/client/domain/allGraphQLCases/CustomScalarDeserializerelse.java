package com.graphql_java_generator.client.domain.allGraphQLCases;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.graphql_java_generator.customscalars.CustomScalarRegistryImpl;
import com.graphql_java_generator.client.response.AbstractCustomScalarDeserializer;
import com.graphql_java_generator.customscalars.GraphQLScalarTypeDate;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

import graphql.schema.GraphQLScalarType;

import java.util.Date;

/**
 * This class is a standard Deserializer for Jackson. It uses the {@link GraphQLScalarType} that is implemented by the project for this scalar
 */
public class CustomScalarDeserializerelse  extends AbstractCustomScalarDeserializer<java.lang.String> {

	private static final long serialVersionUID = 1L;

	protected CustomScalarDeserializerelse() {
		super(java.lang.String.class,
				com.graphql_java_generator.customscalars.GraphQLScalarTypeString.String
				);
	}
}
