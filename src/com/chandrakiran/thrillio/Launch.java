package com.chandrakiran.thrillio;

import com.chandrakiran.thrillio.entities.Bookmark;
import com.chandrakiran.thrillio.entities.User;
import com.chandrakiran.thrillio.managers.BookmarkManager;
import com.chandrakiran.thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data...");
		DataStore.loadData();
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
	}

	
	private static void start() {
		for(User user: users) {
			View.browse(user, bookmarks);
		}
		
	}

	
	public static void main(String[] args) {

		loadData();
		start();
		

	}




}
