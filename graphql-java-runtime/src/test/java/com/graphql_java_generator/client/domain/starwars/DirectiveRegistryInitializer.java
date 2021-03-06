package com.graphql_java_generator.client.domain.starwars;

import com.graphql_java_generator.client.directive.Directive;
import com.graphql_java_generator.client.directive.DirectiveLocation;
import com.graphql_java_generator.client.directive.DirectiveRegistry;
import com.graphql_java_generator.client.directive.DirectiveRegistryImpl;
import com.graphql_java_generator.client.request.InputParameter;
import com.graphql_java_generator.customscalars.CustomScalarRegistry;
import com.graphql_java_generator.customscalars.CustomScalarRegistryImpl;

public class DirectiveRegistryInitializer {
	
	
	CustomScalarRegistry customScalarRegistry = new CustomScalarRegistryImpl();
	
	/**
	 * Initialization of the {@link DirectiveRegistry} with all known custom scalars, that is with all custom scalars
	 * defined in the project pom
	 */
	public void initDirectiveRegistry() {
		DirectiveRegistry directiveRegistry = new DirectiveRegistryImpl();
		Directive directive;
		InputParameter param;

		directive = new Directive();
		directive.setName("skip");
		param = InputParameter.newHardCodedParameter("if", null, true,
					graphql.Scalars.GraphQLBoolean
				);
		directive.getArguments().add(param);
		directive.getDirectiveLocations().add(DirectiveLocation.FIELD);
		directive.getDirectiveLocations().add(DirectiveLocation.FRAGMENT_SPREAD);
		directive.getDirectiveLocations().add(DirectiveLocation.INLINE_FRAGMENT);
		directiveRegistry.registerDirective(directive);

		directive = new Directive();
		directive.setName("include");
		param = InputParameter.newHardCodedParameter("if", null, true,
					graphql.Scalars.GraphQLBoolean
				);
		directive.getArguments().add(param);
		directive.getDirectiveLocations().add(DirectiveLocation.FIELD);
		directive.getDirectiveLocations().add(DirectiveLocation.FRAGMENT_SPREAD);
		directive.getDirectiveLocations().add(DirectiveLocation.INLINE_FRAGMENT);
		directiveRegistry.registerDirective(directive);

		directive = new Directive();
		directive.setName("defer");
		param = InputParameter.newHardCodedParameter("if", null, true,
					graphql.Scalars.GraphQLBoolean
				);
		directive.getArguments().add(param);
		directive.getDirectiveLocations().add(DirectiveLocation.FIELD);
		directiveRegistry.registerDirective(directive);

		directive = new Directive();
		directive.setName("deprecated");
		param = InputParameter.newHardCodedParameter("reason", null, false,
					graphql.Scalars.GraphQLString
				);
		directive.getArguments().add(param);
		directive.getDirectiveLocations().add(DirectiveLocation.FIELD_DEFINITION);
		directive.getDirectiveLocations().add(DirectiveLocation.ENUM_VALUE);
		directiveRegistry.registerDirective(directive);


		DirectiveRegistryImpl.directiveRegistry = directiveRegistry;
	}

}
