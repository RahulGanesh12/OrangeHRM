package utils;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class KeyBoardActionsUtils extends BaseClass {
	static Actions actions;

	public KeyBoardActionsUtils() throws IOException {
	}

	public static Actions actionsMethod() {
		actions = new Actions(driver);
		return actions;
	}
}
