package com.chandrakiran.thrillio;

import com.chandrakiran.thrillio.constants.KidFriendlyStatus;
import com.chandrakiran.thrillio.constants.UserType;
import com.chandrakiran.thrillio.controllers.BookmarkController;
import com.chandrakiran.thrillio.entities.Bookmark;
import com.chandrakiran.thrillio.entities.User;
import com.chandrakiran.thrillio.partner.Shareable;

public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items ...");

		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// Bookmarking
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Book mark added..." + bookmark);
					}
				}

				if (user.getUserType().equals(UserType.EDITOR)
						|| user.getUserType().contentEquals(UserType.CHEIF_EDITOR)) {

					// Mark as kid-friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().contentEquals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.contentEquals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

						}
					}

					// Sharing !!
					if (bookmark.getKidFriendlyStatus().contentEquals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}

				}
			}
		}

	}
	//TODO: Below methods simulate user input. After IO, we take input via console. 
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}

}
