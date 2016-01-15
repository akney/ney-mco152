package ney.nypl;

public class SearchResult {
	private NYPLApi2 nyplAPI;

	public NYPLApi2 getNyplAPI() {
		return nyplAPI;
	}

}

class NYPLApi2 {
	private Responses response;

	public Responses getResponse() {
		return response;
	}
}

class Responses {
	private int numResults;
	private Capture[] capture;

	public int getNumResults() {
		return numResults;
	}

	public Capture[] getCapture() {
		return capture;
	}

}

class Capture {
	private ImageLinks imageLinks;

	public ImageLinks getImageLinks() {
		return imageLinks;
	}

}

class ImageLinks {

	private String[] imageLink;

	public String[] getImageLink() {
		return imageLink;
	}
}
