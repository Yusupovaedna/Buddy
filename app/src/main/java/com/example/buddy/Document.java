package com.example.buddy;

import java.sql.SQLException;

public class Document {
    private Document doc = null;
    private Database database;
    private String name;
    private String path;

    public Document(String name, String path) throws SQLException {
        this.path = path;
        this.name = name;
        String query = "insert into Documents values (default , $name, lo_import($path))";
        database.getExtraConnection().createStatement().executeQuery(query);
    }

    public void add(Document doc) throws SQLException {
        this.doc = doc;
    }

    public boolean isAdded() {
        if (doc != null) {
            return true;
        }
        return false;
    }

    public Document getDoc() {
        return doc;
    }
}
