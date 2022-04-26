package bookLibrary;

public class Patron implements Search {

	private String patronName;
	private String patronAddress;

	public Patron(String patronName, String patronAddress) {
		this.patronName = patronName;
		this.patronAddress = patronAddress;
	}

	public String getPatronName() {
		return patronName;
	}

	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}

	public String getPatronAddress() {
		return patronAddress;
	}

	public void setPatronAddress(String patronAddress) {
		this.patronAddress = patronAddress;
	}

	@Override
	public String toString() {
		return "Patron [patronAddress=" + patronAddress + ", patronName=" + patronName + "]";
	}

	@Override
	public void searchLibrary() {
		System.out.println("");
	}

}
