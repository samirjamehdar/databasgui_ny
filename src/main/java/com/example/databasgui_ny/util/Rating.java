package com.example.databasgui_ny.util;

public enum Rating {
    G("G"),
    PG("PG"),
    PG_13("PG-13") {
        @Override
        public String toString() {
            return "PG-13";
        }
    },
    R("R"),
    NC_17("NC-17");

    private final String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
