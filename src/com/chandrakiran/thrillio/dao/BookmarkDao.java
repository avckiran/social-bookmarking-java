package com.chandrakiran.thrillio.dao;

import com.chandrakiran.thrillio.DataStore;
import com.chandrakiran.thrillio.entities.Bookmark;
import com.chandrakiran.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
