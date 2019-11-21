package com.graphql_java_generator;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.language.FieldDefinition;
import graphql.language.InterfaceTypeDefinition;
import graphql.language.ObjectTypeDefinition;
import graphql.language.TypeName;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

/**
 * Based on the https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/ tutorial
 * 
 * @author EtienneSF
 */
@Component
public class GraphQLProvider {

	/** The logger for this instance */
	protected Logger logger = LogManager.getLogger();

	/** The {@link GraphQLDataFetchers} class contains all the Data Fetcher declarations */
	@Autowired
	GraphQLDataFetchers graphQLDataFetchers;

	private GraphQL graphQL;

	@Bean
	public GraphQL graphQL() {
		return graphQL;
	}

	/**
	 * The {@link DataLoaderRegistry} will be autowired by Spring in the GraphQL Java Spring Boot framework. It will
	 * then be wired for each request execution, as specified in this page:
	 * <A HREF="https://www.graphql-java.com/documentation/master/batching/">graphql-java batching</A>
	 * 
	 * @return
	 */
	@Bean
	public DataLoaderRegistry dataLoaderRegistry() {
		logger.debug("Creating DataLoader registry");
		DataLoaderRegistry registry = new DataLoaderRegistry();
		registry.register("Character", DataLoader.newDataLoader(graphQLDataFetchers.characterImplBatchLoader()));
		registry.register("Droid", DataLoader.newDataLoader(graphQLDataFetchers.droidBatchLoader()));
		registry.register("Human", DataLoader.newDataLoader(graphQLDataFetchers.humanBatchLoader()));

		return registry;
	}

	@PostConstruct
	public void init() throws IOException {
		Resource res;
		StringBuffer sdl = new StringBuffer();
		res = new ClassPathResource("/starWarsSchema.graphqls");
		Reader reader = new InputStreamReader(res.getInputStream(), Charset.forName("UTF8"));
		sdl.append(FileCopyUtils.copyToString(reader));
		this.graphQL = GraphQL.newGraphQL(buildSchema(sdl.toString())).build();
	}

	private GraphQLSchema buildSchema(String sdl) {
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);

		// Add of the CharacterImpl type definition
		typeRegistry.add(getCharacterImplType(typeRegistry));

		RuntimeWiring runtimeWiring = buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
	}

	private RuntimeWiring buildWiring() {
		// Thanks to this thread :
		// https:// stackoverflow.com/questions/54251935/graphql-no-resolver-definied-for-interface-union-java
		//
		// Also see sample :
		// https://github.com/graphql-java/graphql-java-examples/tree/master/http-example
		return RuntimeWiring.newRuntimeWiring()
				// Data fetchers for QueryTypeDataFetchersDelegate
				.type(newTypeWiring("QueryType").dataFetcher("hero",
						graphQLDataFetchers.queryTypeDataFetchersDelegateHero()))
				.type(newTypeWiring("QueryType").dataFetcher("characters",
						graphQLDataFetchers.queryTypeDataFetchersDelegateCharacters()))
				.type(newTypeWiring("QueryType").dataFetcher("human",
						graphQLDataFetchers.queryTypeDataFetchersDelegateHuman()))
				.type(newTypeWiring("QueryType").dataFetcher("droid",
						graphQLDataFetchers.queryTypeDataFetchersDelegateDroid()))
				// Data fetchers for MutationTypeDataFetchersDelegate
				.type(newTypeWiring("MutationType").dataFetcher("createHuman",
						graphQLDataFetchers.mutationTypeDataFetchersDelegateCreateHuman()))
				.type(newTypeWiring("MutationType").dataFetcher("addFriend",
						graphQLDataFetchers.mutationTypeDataFetchersDelegateAddFriend()))
				// Data fetchers for HumanDataFetchersDelegate
				.type(newTypeWiring("Human").dataFetcher("friends",
						graphQLDataFetchers.humanDataFetchersDelegateFriends()))
				.type(newTypeWiring("Human").dataFetcher("appearsIn",
						graphQLDataFetchers.humanDataFetchersDelegateAppearsIn()))
				// Data fetchers for DroidDataFetchersDelegate
				.type(newTypeWiring("Droid").dataFetcher("friends",
						graphQLDataFetchers.droidDataFetchersDelegateFriends()))
				.type(newTypeWiring("Droid").dataFetcher("appearsIn",
						graphQLDataFetchers.droidDataFetchersDelegateAppearsIn()))
				// Data fetchers for CharacterImplDataFetchersDelegate
				.type(newTypeWiring("Character").dataFetcher("friends",
						graphQLDataFetchers.characterImplDataFetchersDelegateFriends()))
				.type(newTypeWiring("CharacterImpl").dataFetcher("friends",
						graphQLDataFetchers.characterImplDataFetchersDelegateFriends()))
				.type(newTypeWiring("Character").dataFetcher("appearsIn",
						graphQLDataFetchers.characterImplDataFetchersDelegateAppearsIn()))
				.type(newTypeWiring("CharacterImpl").dataFetcher("appearsIn",
						graphQLDataFetchers.characterImplDataFetchersDelegateAppearsIn()))
				//
				// Let's link the interface types to the concrete types
				.type("Character", typeWiring -> typeWiring.typeResolver(getCharacterResolver())).build();
	}

	private ObjectTypeDefinition getCharacterImplType(TypeDefinitionRegistry typeRegistry) {
		InterfaceTypeDefinition defCharacter = (InterfaceTypeDefinition) typeRegistry.getType("Character").get();
		ObjectTypeDefinition.Builder defCharacterImpl = ObjectTypeDefinition.newObjectTypeDefinition();
		defCharacterImpl.name("CharacterImpl");
		for (FieldDefinition fieldDef : defCharacter.getFieldDefinitions()) {
			defCharacterImpl.fieldDefinition(fieldDef);
		}
		// Let's precise that the new type is an implementation for this interface
		TypeName typeName = TypeName.newTypeName("Character").build();
		defCharacterImpl.implementz(typeName);

		return defCharacterImpl.build();
	}

	private TypeResolver getCharacterResolver() {
		return new TypeResolver() {
			@Override
			public GraphQLObjectType getType(TypeResolutionEnvironment env) {
				Object javaObject = env.getObject();
				String ret = null;

				if (javaObject instanceof Human) {
					ret = "Human";
				} else if (javaObject instanceof Droid) {
					ret = "Droid";
				} else if (javaObject instanceof CharacterImpl) {
					ret = "CharacterImpl";
				} else {
					throw new RuntimeException("Can't resolve javaObject " + javaObject.getClass().getName());
				}
				logger.trace("Resolved type for javaObject {} is {}", javaObject.getClass().getName());
				return env.getSchema().getObjectType(ret);
			}
		};
	}

}
