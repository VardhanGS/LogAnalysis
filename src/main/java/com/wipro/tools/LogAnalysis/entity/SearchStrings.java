package com.wipro.tools.LogAnalysis.entity;

public class SearchStrings {

    private String fileLoc;
    private String lastToSearch;

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    private boolean hidden = false;

    public String getFileLoc() {
        return fileLoc;
    }

    public void setFileLoc(String fileLoc) {
        this.fileLoc = fileLoc;
    }

    public String getLastToSearch() {
        return lastToSearch;
    }

    public void setLastToSearch(String lastToSearch) {
        this.lastToSearch = lastToSearch;
    }

    public String getFirstToSearch() {
        return firstToSearch;
    }

    public void setFirstToSearch(String firstToSearch) {
        this.firstToSearch = firstToSearch;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String firstToSearch;
    private String keyword;
    private String result;

    @Override
    public String toString() {
        return "SearchStrings{" +
                "fileLoc='" + fileLoc + '\'' +
                ", lastToSearch='" + lastToSearch + '\'' +
                ", firstToSearch='" + firstToSearch + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

}
