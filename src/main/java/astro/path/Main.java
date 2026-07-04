package astro.path;

import astro.path.UI.MainApplication;
import astro.path.controller.DataController;

public class Main {

	public static void main(String[] args) {
		DataController myDC = new DataController();
		myDC.getSampleData();
		// MainApplication.main(args);
	}

}
