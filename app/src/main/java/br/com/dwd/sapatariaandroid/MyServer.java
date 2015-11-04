package br.com.dwd.sapatariaandroid;

public class MyServer {
    private static String uri = "http://localhost:8080/sapataria/rest/%s";

    public static String uriFor(String value) {
        return String.format(uri, value);
    }
}
