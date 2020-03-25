package com.graphql_java_generator.client.domain.forum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class MutationTypeCreatePost {

	public static final String NAME = "createPost";

	@JsonProperty("createPost")
	Post createPost;

	public void setCreatePost(Post createPost) {
		this.createPost = createPost;
	}

	public Post getCreatePost() {
		return createPost;
	}
	
    public String toString() {
        return "MutationTypeCreatePost {createPost: " + createPost + "}";
    }
}
