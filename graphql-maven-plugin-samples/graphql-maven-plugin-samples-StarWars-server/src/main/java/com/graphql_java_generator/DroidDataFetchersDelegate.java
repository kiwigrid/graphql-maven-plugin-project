package com.graphql_java_generator;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import graphql.schema.DataFetchingEnvironment;

/**
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public interface DroidDataFetchersDelegate {

	/**
	 * This method loads the data for Droid.friends <BR/>
	 * Actual execution of the DataFetcher. This is delegated to the developper, as it is not possible to manage every
	 * possible use cases.<BR/>
	 * Note 1: In the future, more and more standard cases will be generated.
	 * 
	 * @param dataFetchingEnvironment
	 *            The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this
	 *            DataFetcher
	 * @param source
	 *            The object from which the field is fetch. It typically contains the id to use in the query.
	 * @throws NoSuchElementException
	 *             This method may return a {@link NoSuchElementException} exception. In this case, the exception is
	 *             trapped by the calling method, and the return is consider as null. This allows to use the
	 *             {@link Optional#get()} method directly, without caring of wheter or not there is a value. The
	 *             generated code will take care of the {@link NoSuchElementException} exception.
	 */
	public CompletableFuture<List<CharacterImpl>> friends(DataFetchingEnvironment dataFetchingEnvironment,
			Droid source);

	/**
	 * This method loads the data for Droid.appearsIn <BR/>
	 * Actual execution of the DataFetcher. This is delegated to the developper, as it is not possible to manage every
	 * possible use cases.<BR/>
	 * Note 1: In the future, more and more standard cases will be generated.
	 * 
	 * @param dataFetchingEnvironment
	 *            The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this
	 *            DataFetcher
	 * @param source
	 *            The object from which the field is fetch. It typically contains the id to use in the query.
	 * @throws NoSuchElementException
	 *             This method may return a {@link NoSuchElementException} exception. In this case, the exception is
	 *             trapped by the calling method, and the return is consider as null. This allows to use the
	 *             {@link Optional#get()} method directly, without caring of wheter or not there is a value. The
	 *             generated code will take care of the {@link NoSuchElementException} exception.
	 */
	public List<Episode> appearsIn(DataFetchingEnvironment dataFetchingEnvironment, Droid source);

	public List<Droid> droidBatchLoader(List<UUID> keys);

}
