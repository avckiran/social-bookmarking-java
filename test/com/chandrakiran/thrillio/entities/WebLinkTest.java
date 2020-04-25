package com.chandrakiran.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.chandrakiran.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1: porn in url --false
		Weblink webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/porn--part-2.html",
				"http://www.javaworld.com");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("Found porn in the URL - must return false", isKidFriendlyEligible);
		
		
		//Test 2: porn in title --false
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("Found porn in the Title - must return false", isKidFriendlyEligible);
		
		
		//Test 3: adult in host -- false
		
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/Taming-tiger-part-2.html",
				"http://www.adultjavaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("Found adult in the Host - must return false", isKidFriendlyEligible);
		
		//Test 4: adult in url, but not in host - true
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/adult/Taming-tiger-part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("Found adult in the URL but not in Host - must return true", isKidFriendlyEligible);
		
		
		
		//Test 5: adult in title only -- true
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming adult Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/java/Taming-tiger-part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("Found adult in title - must return true", isKidFriendlyEligible);
	}

}
