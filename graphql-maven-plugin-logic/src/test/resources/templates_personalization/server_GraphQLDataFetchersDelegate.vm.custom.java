/** This template is custom **/
package ${pluginConfiguration.packageName};

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;

import graphql.schema.DataFetchingEnvironment;

#foreach($import in $imports)
import $import;
#end

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public interface ${dataFetcherDelegate.pascalCaseName} {
	
#foreach ($dataFetcher in $dataFetcherDelegate.dataFetchers)
	/**
	 * This method loads the data for ${dataFetcher.field.owningType.name}.${dataFetcher.field.name}. 
	 * <BR/>
	 * For optimization, this method returns a CompletableFuture. This allows to use 
	 * <A HREF="https://github.com/graphql-java/java-dataloader">graphql-java java-dataloader</A> to highly optimize the
	 * number of requests to the server.<BR/>
	 * The principle is this one: The data loader collects all the data to load, avoid to load several times the same data, 
	 * and allows parallel execution of the queries, if multiple queries are to be run.<BR/>
	 * You can implements this method like this:
	 * <PRE>
	 * @Override
	 * public CompletableFuture<List<Character>> friends(DataFetchingEnvironment environment, Human source) {
	 *     List<UUID> friendIds = source.getFriendIds();
	 *     DataLoader<UUID, CharacterImpl> dataLoader = environment.getDataLoader("Character");
	 *     return dataLoader.loadMany(friendIds);
	 * }
	 * </PRE>
	 * <BR/>
	 * 
	 * @param dataFetchingEnvironment The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this DataFetcher 
#if($dataFetcher.sourceName)
	 * @param source The object from which the field is fetch. It typically contains the id to use in the query.
#end
#foreach($argument in $dataFetcher.field.inputParameters)
	 * @param ${argument.camelCaseName} The input parameter sent in the query by the GraphQL consumer
#end
	 * @throws NoSuchElementException This method may return a {@link NoSuchElementException} exception. In this case, the exception is trapped 
	 * by the calling method, and the return is consider as null. This allows to use the {@link Optional#get()} method directly, without caring of 
	 * wheter or not there is a value. The generated code will take care of the {@link NoSuchElementException} exception. 
	 */
	public #if(${dataFetcher.completableFuture})CompletableFuture<#end#if(${dataFetcher.field.list})List<#end${dataFetcher.field.type.classSimpleName}#if(${dataFetcher.field.list})>#end#if(${dataFetcher.completableFuture})>#end ${dataFetcher.camelCaseName}(DataFetchingEnvironment dataFetchingEnvironment#if(${dataFetcher.completableFuture}), DataLoader<${dataFetcher.field.type.identifier.type.classSimpleName}, #if(${argument.list})List<#end${dataFetcher.field.type.classSimpleName}#if(${argument.list})>#end> dataLoader#end#if($dataFetcher.sourceName), ${dataFetcher.sourceName} source#end#foreach($argument in $dataFetcher.field.inputParameters), #if(${argument.list})List<#end${argument.type.classSimpleName}#if(${argument.list})>#end  ${argument.camelCaseName}#end);
	
#end
#foreach ($batchLoader in $dataFetcherDelegate.batchLoaders)
	/**
	 * This method loads a list of ${dataFetcher.field.name}, based on the list of id to be fetched. This method is used by
	 * <A HREF="https://github.com/graphql-java/java-dataloader">graphql-java java-dataloader</A> to highly optimize the
	 * number of requests to the server, when recursing down through the object associations.<BR/>
	 * You can find more information on this page:
	 * <A HREF="https://www.graphql-java.com/documentation/master/batching/">graphql-java batching</A>
	 * 
	 * @param keys
	 *            A list of ${batchLoader.type.identifier.type.name}'s id
	 * @return A list of ${batchLoader.type.identifier.type.name}s
	 */
	public List<${batchLoader.type.classSimpleName}> batchLoader(List<${batchLoader.type.identifier.type.classSimpleName}> keys);

#end
}
