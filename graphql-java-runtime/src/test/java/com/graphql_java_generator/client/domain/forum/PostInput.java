package com.graphql_java_generator.client.domain.forum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;

import java.util.Date;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("PostInput")
public class PostInput  {

	@JsonProperty("topicId")
	@GraphQLScalar(graphQLTypeName = "ID", javaClass = String.class)
	String topicId;


	@JsonProperty("input")
	@GraphQLNonScalar(graphQLTypeName = "TopicPostInput", javaClass = TopicPostInput.class)
	TopicPostInput input;


	@JsonProperty("from")
	@JsonDeserialize(using = CustomScalarDeserializerDate.class)
	@GraphQLScalar(graphQLTypeName = "Date", javaClass = Date.class)
	Date from;


	@JsonProperty("in")
	@JsonDeserialize(contentAs = Date.class, using = CustomScalarDeserializerDate.class)
	@GraphQLScalar(graphQLTypeName = "Date", javaClass = Date.class)
	List<Date> in;



	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setInput(TopicPostInput input) {
		this.input = input;
	}

	public TopicPostInput getInput() {
		return input;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getFrom() {
		return from;
	}

	public void setIn(List<Date> in) {
		this.in = in;
	}

	public List<Date> getIn() {
		return in;
	}

    public String toString() {
        return "PostInput {"
				+ "topicId: " + topicId
				+ ", "
				+ "input: " + input
				+ ", "
				+ "from: " + from
				+ ", "
				+ "in: " + in
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		TopicId("topicId"),
		Input("input"),
		From("from"),
		In("in");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
			return new Builder();
		}



	/**
	 * Builder
	 */
	public static class Builder {
		private String topicId;
		private TopicPostInput input;
		private Date from;
		private List<Date> in;


		public Builder withTopicId(String topicId) {
			this.topicId = topicId;
			return this;
		}
		public Builder withInput(TopicPostInput input) {
			this.input = input;
			return this;
		}
		public Builder withFrom(Date from) {
			this.from = from;
			return this;
		}
		public Builder withIn(List<Date> in) {
			this.in = in;
			return this;
		}

		public PostInput build() {
			PostInput object = new PostInput();
			object.setTopicId(topicId);
			object.setInput(input);
			object.setFrom(from);
			object.setIn(in);
			return object;
		}
	}
}
