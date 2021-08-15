package com.example.hrms.core.utilities.results;

public class ErorResult extends Result {
    public ErorResult() {
        super(false);
    }

    public ErorResult(String message) {
        super(false,message);
    }
}
