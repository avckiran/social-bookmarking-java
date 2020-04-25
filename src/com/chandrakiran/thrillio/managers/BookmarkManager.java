package com.chandrakiran.thrillio.managers;

import com.chandrakiran.thrillio.dao.BookmarkDao;
import com.chandrakiran.thrillio.entities.Book;
import com.chandrakiran.thrillio.entities.Bookmark;
import com.chandrakiran.thrillio.entities.Movie;
import com.chandrakiran.thrillio.entities.User;
import com.chandrakiran.thrillio.entities.UserBookmark;
import com.chandrakiran.thrillio.entities.Weblink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();

	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Book createBook(long id, String title, int year, String profileUrl, String publisher, String[] authors,
			String genre, double amazonRating) {

		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(year);
		book.setProfileUrl(profileUrl);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;

	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.getImdbRating();

		return movie;
	}

	public Weblink createWeblink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();

		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();

		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);

		dao.saveUserBookmark(userBookmark);

	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid friendly status: " + kidFriendlyStatus + ", " + bookmark + " Marked by: "+
				user.getEmail() + " " + bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be Shared : ");
		
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		} else if (bookmark instanceof Weblink) {
			System.out.println(((Weblink)bookmark).getItemData());
		}
	}

}
