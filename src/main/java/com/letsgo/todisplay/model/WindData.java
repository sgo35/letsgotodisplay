package com.letsgo.todisplay.model;

public interface WindData {
    static final String JSON_SPEED = "speed";
    static final String JSON_DEG = "deg";
    static final String JSON_GUST = "gust";
    static final String JSON_VAR_BEG = "var_beg";
    static final String JSON_VAR_END = "var_end";

    float speed();
    int deg();
    float gust();
    int varBeg();
    int varEnd();

}
