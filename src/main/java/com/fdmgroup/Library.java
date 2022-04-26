package com.fdmgroup;

public class Library {

    private String libraryName;
    private String libraryAddress;

    public Library(String libraryName, String libraryAddress) {
        super();
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    @Override
    public String toString() {
        return "Library [libraryName=" + libraryName + ", libraryAddress=" + libraryAddress + "]";
    }

}
