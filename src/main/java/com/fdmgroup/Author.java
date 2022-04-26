package com.fdmgroup;

public class Author {
    private String authorName;

    public Author(final String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author [authorName=" + authorName + "]";
    }

    
    
}
