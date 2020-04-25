package com.chandrakiran.thrillio.entities;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.chandrakiran.thrillio.constants.BookGenre;
import com.chandrakiran.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1: If book genre is philosophy return false
		
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "", "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		
		boolean isKidFriendly = book.isKidFriendlyEligible();
		
		assertFalse("Philosophy book is categorized as kid friendly, expected a false", isKidFriendly);
		
		//Test 2: If book genre is self-help return false
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "", "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		
		isKidFriendly = book.isKidFriendlyEligible();
		
		assertFalse("Self Help book is categorized as kid friendly, expected a false", isKidFriendly);
	}

}
