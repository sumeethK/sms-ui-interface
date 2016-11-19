/**
 * 
 */
package com.sumeeth.service;

import java.util.List;

import com.sumeeth.model.Movies;

/**
 * @author sumeeth kumar kanojia
 *
 */
public interface IMoviesService {

	List<Movies> getAllMovies();

	int synchMoviesFromLocalSytem() throws Exception;

	List<Movies> getMoviesByName(String name);

	void save(Movies dto) throws Exception;

	List<Movies> getAllMoviesByLimit(int offSet, int limit);

	int getTotalMovies();

	void updateMoviesCategory(String newCategory, int id);

	Movies getMoviesById(int id);

}
