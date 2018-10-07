package edu.wofford;


public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			ConsoleMain.main(null);
		} else {
			GuiMain.main(null);
		}
	}
}