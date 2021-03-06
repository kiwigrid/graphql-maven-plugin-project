package com.graphql_java_generator.client.domain.allGraphQLCases;

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
@GraphQLInputType("AllFieldCasesInput")
public class AllFieldCasesInput  {

	@JsonProperty("id")
	@GraphQLScalar(fieldName = "id", graphQLTypeName = "ID", javaClass = String.class)
	String id;


	@JsonProperty("name")
	@GraphQLScalar(fieldName = "name", graphQLTypeName = "String", javaClass = String.class)
	String name;


	@JsonProperty("forname")
	@GraphQLScalar(fieldName = "forname", graphQLTypeName = "String", javaClass = String.class)
	String forname;


	@JsonProperty("age")
	@JsonDeserialize(using = CustomScalarDeserializerLong.class)
	@GraphQLScalar(fieldName = "age", graphQLTypeName = "Long", javaClass = Long.class)
	Long age;


	@JsonProperty("nbComments")
	@GraphQLScalar(fieldName = "nbComments", graphQLTypeName = "Int", javaClass = Integer.class)
	Integer nbComments;


	@JsonProperty("comments")
	@JsonDeserialize(contentAs = String.class)
	@GraphQLScalar(fieldName = "comments", graphQLTypeName = "String", javaClass = String.class)
	List<String> comments;


	@JsonProperty("booleans")
	@JsonDeserialize(contentAs = Boolean.class)
	@GraphQLScalar(fieldName = "booleans", graphQLTypeName = "Boolean", javaClass = Boolean.class)
	List<Boolean> booleans;


	@JsonProperty("aliases")
	@JsonDeserialize(contentAs = String.class)
	@GraphQLScalar(fieldName = "aliases", graphQLTypeName = "String", javaClass = String.class)
	List<String> aliases;


	@JsonProperty("planets")
	@JsonDeserialize(contentAs = String.class)
	@GraphQLScalar(fieldName = "planets", graphQLTypeName = "String", javaClass = String.class)
	List<String> planets;


	@JsonProperty("withIdSubtype")
	@JsonDeserialize(contentAs = AllFieldCasesWithIdSubtypeInput.class)
	@GraphQLNonScalar(fieldName = "withIdSubtype", graphQLTypeName = "AllFieldCasesWithIdSubtypeInput", javaClass = AllFieldCasesWithIdSubtypeInput.class)
	List<AllFieldCasesWithIdSubtypeInput> withIdSubtype;


	@JsonProperty("withoutIdSubtype")
	@JsonDeserialize(contentAs = AllFieldCasesWithoutIdSubtypeInput.class)
	@GraphQLNonScalar(fieldName = "withoutIdSubtype", graphQLTypeName = "AllFieldCasesWithoutIdSubtypeInput", javaClass = AllFieldCasesWithoutIdSubtypeInput.class)
	List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype;



	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public String getForname() {
		return forname;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getAge() {
		return age;
	}

	public void setNbComments(Integer nbComments) {
		this.nbComments = nbComments;
	}

	public Integer getNbComments() {
		return nbComments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setBooleans(List<Boolean> booleans) {
		this.booleans = booleans;
	}

	public List<Boolean> getBooleans() {
		return booleans;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setPlanets(List<String> planets) {
		this.planets = planets;
	}

	public List<String> getPlanets() {
		return planets;
	}

	public void setWithIdSubtype(List<AllFieldCasesWithIdSubtypeInput> withIdSubtype) {
		this.withIdSubtype = withIdSubtype;
	}

	public List<AllFieldCasesWithIdSubtypeInput> getWithIdSubtype() {
		return withIdSubtype;
	}

	public void setWithoutIdSubtype(List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype) {
		this.withoutIdSubtype = withoutIdSubtype;
	}

	public List<AllFieldCasesWithoutIdSubtypeInput> getWithoutIdSubtype() {
		return withoutIdSubtype;
	}

    public String toString() {
        return "AllFieldCasesInput {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
				+ ", "
				+ "forname: " + forname
				+ ", "
				+ "age: " + age
				+ ", "
				+ "nbComments: " + nbComments
				+ ", "
				+ "comments: " + comments
				+ ", "
				+ "booleans: " + booleans
				+ ", "
				+ "aliases: " + aliases
				+ ", "
				+ "planets: " + planets
				+ ", "
				+ "withIdSubtype: " + withIdSubtype
				+ ", "
				+ "withoutIdSubtype: " + withoutIdSubtype
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Id("id"),
		Name("name"),
		Forname("forname"),
		Age("age"),
		NbComments("nbComments"),
		Comments("comments"),
		Booleans("booleans"),
		Aliases("aliases"),
		Planets("planets"),
		WithIdSubtype("withIdSubtype"),
		WithoutIdSubtype("withoutIdSubtype");

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
		private String id;
		private String name;
		private String forname;
		private Long age;
		private Integer nbComments;
		private List<String> comments;
		private List<Boolean> booleans;
		private List<String> aliases;
		private List<String> planets;
		private List<AllFieldCasesWithIdSubtypeInput> withIdSubtype;
		private List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype;


		public Builder withId(String id) {
			this.id = id;
			return this;
		}
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withForname(String forname) {
			this.forname = forname;
			return this;
		}
		public Builder withAge(Long age) {
			this.age = age;
			return this;
		}
		public Builder withNbComments(Integer nbComments) {
			this.nbComments = nbComments;
			return this;
		}
		public Builder withComments(List<String> comments) {
			this.comments = comments;
			return this;
		}
		public Builder withBooleans(List<Boolean> booleans) {
			this.booleans = booleans;
			return this;
		}
		public Builder withAliases(List<String> aliases) {
			this.aliases = aliases;
			return this;
		}
		public Builder withPlanets(List<String> planets) {
			this.planets = planets;
			return this;
		}
		public Builder withWithIdSubtype(List<AllFieldCasesWithIdSubtypeInput> withIdSubtype) {
			this.withIdSubtype = withIdSubtype;
			return this;
		}
		public Builder withWithoutIdSubtype(List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype) {
			this.withoutIdSubtype = withoutIdSubtype;
			return this;
		}

		public AllFieldCasesInput build() {
			AllFieldCasesInput object = new AllFieldCasesInput();
			object.setId(id);
			object.setName(name);
			object.setForname(forname);
			object.setAge(age);
			object.setNbComments(nbComments);
			object.setComments(comments);
			object.setBooleans(booleans);
			object.setAliases(aliases);
			object.setPlanets(planets);
			object.setWithIdSubtype(withIdSubtype);
			object.setWithoutIdSubtype(withoutIdSubtype);
			return object;
		}
	}
}
