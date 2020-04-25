package com.chandrakiran.thrillio.dao;

import com.chandrakiran.thrillio.DataStore;
import com.chandrakiran.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
