package com.chandrakiran.thrillio.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.chandrakiran.thrillio.constants.MovieGenre;
import com.chandrakiran.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test 1 - Horror genre
		
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		
		boolean isKidFriendly = movie.isKidFriendlyEligible();
		
		assertFalse("Horror movie classified as kid friendly, expected a false", isKidFriendly);
		
		//Test 2 - Thriller Genre
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		
		isKidFriendly = movie.isKidFriendlyEligible();
		
		assertFalse("Thriller movie classified as kid friendly, expected a false", isKidFriendly);
		
	}

}
