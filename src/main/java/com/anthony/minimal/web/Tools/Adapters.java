package com.anthony.minimal.web.Tools;

public class Adapters {

    public static String adaptForFullTextSearch(String search) {
        return search.replace(" ", "&");
    }

}
