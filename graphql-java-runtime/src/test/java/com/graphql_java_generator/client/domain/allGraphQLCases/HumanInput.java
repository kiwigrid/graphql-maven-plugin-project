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
@GraphQLInputType("HumanInput")
public class HumanInput  {

	@JsonProperty("name")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String name;


	@JsonProperty("bestFriend")
	@GraphQLNonScalar(graphQLTypeName = "CharacterInput", javaClass = CharacterInput.class)
	CharacterInput bestFriend;


	@JsonProperty("friends")
	@JsonDeserialize(contentAs = CharacterInput.class)
	@GraphQLNonScalar(graphQLTypeName = "CharacterInput", javaClass = CharacterInput.class)
	List<CharacterInput> friends;


	@JsonProperty("nbComments")
	@GraphQLScalar(graphQLTypeName = "Int", javaClass = Integer.class)
	Integer nbComments;


	@JsonProperty("comments")
	@JsonDeserialize(contentAs = String.class)
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	List<String> comments;


	@JsonProperty("appearsIn")
	@JsonDeserialize(contentAs = Episode.class)
	@GraphQLScalar(graphQLTypeName = "Episode", javaClass = Episode.class)
	List<Episode> appearsIn;


	@JsonProperty("homePlanet")
	@GraphQLScalar(graphQLTypeName = "String", javaClass = String.class)
	String homePlanet;



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBestFriend(CharacterInput bestFriend) {
		this.bestFriend = bestFriend;
	}

	public CharacterInput getBestFriend() {
		return bestFriend;
	}

	public void setFriends(List<CharacterInput> friends) {
		this.friends = friends;
	}

	public List<CharacterInput> getFriends() {
		return friends;
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

	public void setAppearsIn(List<Episode> appearsIn) {
		this.appearsIn = appearsIn;
	}

	public List<Episode> getAppearsIn() {
		return appearsIn;
	}

	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}

	public String getHomePlanet() {
		return homePlanet;
	}

    public String toString() {
        return "HumanInput {"
				+ "name: " + name
				+ ", "
				+ "bestFriend: " + bestFriend
				+ ", "
				+ "friends: " + friends
				+ ", "
				+ "nbComments: " + nbComments
				+ ", "
				+ "comments: " + comments
				+ ", "
				+ "appearsIn: " + appearsIn
				+ ", "
				+ "homePlanet: " + homePlanet
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Name("name"),
		BestFriend("bestFriend"),
		Friends("friends"),
		NbComments("nbComments"),
		Comments("comments"),
		AppearsIn("appearsIn"),
		HomePlanet("homePlanet");

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
		private String name;
		private CharacterInput bestFriend;
		private List<CharacterInput> friends;
		private Integer nbComments;
		private List<String> comments;
		private List<Episode> appearsIn;
		private String homePlanet;


		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withBestFriend(CharacterInput bestFriend) {
			this.bestFriend = bestFriend;
			return this;
		}
		public Builder withFriends(List<CharacterInput> friends) {
			this.friends = friends;
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
		public Builder withAppearsIn(List<Episode> appearsIn) {
			this.appearsIn = appearsIn;
			return this;
		}
		public Builder withHomePlanet(String homePlanet) {
			this.homePlanet = homePlanet;
			return this;
		}

		public HumanInput build() {
			HumanInput object = new HumanInput();
			object.setName(name);
			object.setBestFriend(bestFriend);
			object.setFriends(friends);
			object.setNbComments(nbComments);
			object.setComments(comments);
			object.setAppearsIn(appearsIn);
			object.setHomePlanet(homePlanet);
			return object;
		}
	}
}
