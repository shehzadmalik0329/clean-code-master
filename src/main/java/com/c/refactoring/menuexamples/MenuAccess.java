package com.c.refactoring.menuexamples;

import java.util.Arrays;
import java.util.List;

public class MenuAccess {

    public void setAuthorizationsInEachMenus(
            List<MenuItem> menuItems, Role[] roles) {
    	
    	if(roles == null)
    		return;
    	
        menuItems.forEach(menuItem -> setAccessForMenuItem(roles, menuItem));

    }

	private void setAccessForMenuItem(Role[] roles, MenuItem menuItem) {
		if(doesUserHaveTheRole(roles, menuItem.getReadAccessRole())) {
			setAccess(menuItem, Constants.READ);
		}
		if(doesUserHaveTheRole(roles, menuItem.getWriteAccessRole())) {
			setAccess(menuItem, Constants.WRITE);
		}
	}

	private boolean doesUserHaveTheRole(Role[] roles, String roleToCheckFor) {
		return Arrays.stream(roles)
		.anyMatch(role -> role.getName().equals(roleToCheckFor));
	}
	
	private void setAccess(MenuItem menuItem, String access) {
		menuItem.setAccess(access);
		menuItem.setVisible(true);
	}

}
