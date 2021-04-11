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

        TestKotlinClass testKotlinClass = new TestKotlinClass();
        testKotlinClass.printSize();
        testKotlinClass = new TestKotlinClass(10,10,10);
        testKotlinClass.printSize();
        testKotlinClass = new TestKotlinClass(29);
        testKotlinClass.printSize();

//        Aquarium

//        TowerTank towerTank = new TowerTank(1,1);
//        towerTank.printSize();
    }

    private int strJavaMapper(String str, Mapper mapper) {
        return mapper.mapper(str);
    }

    interface Mapper {
        int mapper(String str);
    }
}
