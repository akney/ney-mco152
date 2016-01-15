package ney.nypl;

public class Search {
	private NyplApi nyplAPI;

	public NyplApi getNyplAPI() {
		return nyplAPI;
	}

}

class NyplApi {
	private Response response;

	public Response getResponse() {
		return response;
	}
}

class Response {
	private int numResults;
	private Result[] result;

	public int getNumResults() {
		return numResults;
	}

	public Result[] getResult() {
		return result;
	}

}

class Result {
	private String apiItemURL;
	private String title;

	public String getApiItemURL() {
		return apiItemURL;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return title;
	}

}