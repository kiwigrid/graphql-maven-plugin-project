package com.graphql_java_generator.plugin;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.graphql_java_generator.plugin.language.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.graphql_java_generator.plugin.test.helper.GraphqlTestHelper;
import com.graphql_java_generator.plugin.test.helper.PluginConfigurationTestHelper;

import graphql.language.Document;
import graphql.mavenplugin_notscannedbyspring.Extend_Server_SpringConfiguration;
import graphql.parser.Parser;

/**
 * 
 * @author EtienneSF
 */
@SpringJUnitConfig(classes = { Extend_Server_SpringConfiguration.class })
class DocumentParserTest_extend {

	public static final String SCHEMA_FILE = "extend.graphqls";
	@javax.annotation.Resource
	PluginConfigurationTestHelper pluginConfiguration;
	@Autowired
	DocumentParser documentParser;
	@javax.annotation.Resource
	private ApplicationContext ctx;
	@javax.annotation.Resource
	private GraphqlTestHelper graphqlTestHelper;
	private Parser parser = new Parser();

	private Document doc;

	@BeforeEach
	void setUp() throws Exception {
		graphqlTestHelper.checkSchemaStringProvider(SCHEMA_FILE);
	}

	@Test
	@DirtiesContext
	void test_parseOneDocument_basic() {
		// Preparation
		Resource resource = ctx.getResource("/" + SCHEMA_FILE);
		doc = parser.parseDocument(graphqlTestHelper.readSchema(resource));

		// Go, go, go
		int i = documentParser.parseOneDocument(doc);

		// Verification
		assertEquals(1, i);

		List<Field> fields = documentParser.getQueryTypes().get(0).getFields();
		assertEquals(2,fields.size());
	}
}
