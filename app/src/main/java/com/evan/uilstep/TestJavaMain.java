package com.evan.uilstep;

public class TestJavaMain {

    public static void main(String[] args) {
        TestJavaMain main = new TestJavaMain();
        int str2IntResult = main.strJavaMapper("123", new Mapper() {
            @Override
            public int mapper(String str) {
                return Integer.valueOf(str);
            }
        });
        System.out.println("str2IntResult = " + str2IntResult);
    }

    private int strJavaMapper(String str, Mapper mapper) {
        return mapper.mapper(str);
    }

    interface Mapper {
        int mapper(String str);
    }
}
