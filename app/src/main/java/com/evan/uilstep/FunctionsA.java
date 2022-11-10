package com.evan.uilstep;

public class FunctionsA {

    public int calculate(int x, int y, Operation operation) {
        return operation.op(x, y);
    }

    public interface Operation {
        int op(int x, int y);
    }
}
