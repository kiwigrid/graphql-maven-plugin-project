/** This template is custom **/
package ${pluginConfiguration.packageName};

import java.util.List;
#if (${pluginConfiguration.mode} == "server")
import java.util.UUID;

#if (${pluginConfiguration.generateJPAAnnotation})
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
#end
#end

#if (${pluginConfiguration.mode} == "client")
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
#end

import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;

#foreach($import in $imports)
import $import;
#end

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
${object.annotation}
public class ${object.javaName} #if($object.implementz.size()>0)implements #foreach($impl in $object.implementz)$impl#if($foreach.hasNext), #end#end#end {

#foreach ($field in $object.fields)
#if (${field.inputParameters.size()} > 0)
	@GraphQLInputParameters(names = {#foreach ($inputParameter in $field.inputParameters)"${inputParameter.name}"#if($foreach.hasNext), #end#end}, types = {#foreach ($inputParameter in $field.inputParameters)"${inputParameter.type.name}"#if($foreach.hasNext), #end#end})
#end
#if (${pluginConfiguration.mode} == "client")
	@JsonProperty("${field.name}")
#end
	${field.annotation}
	#if(${field.list})List<#end${field.type.classSimpleName}#if(${field.list})>#end ${field.javaName};


#end

#foreach ($field in $object.fields)
	public void set${field.pascalCaseName}(#if(${field.list})List<#end${field.type.classSimpleName}#if(${field.list})>#end ${field.javaName}) {
		this.${field.javaName} = ${field.javaName};
	}

	public #if(${field.list})List<#end${field.type.classSimpleName}#if(${field.list})>#end get${field.pascalCaseName}() {
		return ${field.javaName};
	}

#end
    public String toString() {
        return "${object.javaName} {"
#foreach ($field in $object.fields)
				+ "${field.javaName}: " + ${field.javaName}
#if($foreach.hasNext)
				+ ", "
#end 
#end
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field {
#foreach ($field in $object.fields)
		${field.pascalCaseName}("${field.name}")#if($foreach.hasNext),
#end
#end;

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

	}
}
