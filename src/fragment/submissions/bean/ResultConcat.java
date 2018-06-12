package fragment.submissions.bean;

/***
 * 
 * @author maxp
 *
 */
public class ResultConcat {
	private String cancatenatedString;
	private int numberOfOverlappingCharacters;

	/**
	 * 
	 * @param cancatenatedString
	 * @param numberOfOverlappingCharacters
	 */
	public ResultConcat(String cancatenatedString, int numberOfOverlappingCharacters) {
		super();
		this.cancatenatedString = cancatenatedString;
		this.numberOfOverlappingCharacters = numberOfOverlappingCharacters;
	}

	public String getConcatenatedString() {
		return cancatenatedString;
	}

	public void setCancatenatedString(String cancatenatedString) {
		this.cancatenatedString = cancatenatedString;
	}

	public int getNumberOfOverlappingChars() {
		return numberOfOverlappingCharacters;
	}

	public void setNumberOfOverlappingChars(int numberOfOverlappingChars) {
		this.numberOfOverlappingCharacters = numberOfOverlappingChars;
	}
}
