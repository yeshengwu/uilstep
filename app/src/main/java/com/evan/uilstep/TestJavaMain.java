package com.evan.uilstep;

import com.evan.uilstep.jtest.FunctionsA;

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

        // 通过 这里 来学习 kotlin 关键特性
        // object 单例
        TestKotlinObject.INSTANCE.getName();

        BigBen bigBen = new BigBen();
        BigBen.Bonger.getBongs(1);
//        bigBen.
//        BigBen.Bonger bonger = new BigBen.Bonger();
//        bonger.getBongs(1);

        System.out.println("--------------");
        FunctionsA functionsA = new FunctionsA();
        int sumResult = functionsA.calculate(4, 5, new FunctionsA.Operation() {
            @Override
            public int op(int x, int y) {
                return x+y;
            }
        });

        int mulResult = functionsA.calculate(4, 5, new FunctionsA.Operation() {
            @Override
            public int op(int x, int y) {
                return x*y;
            }
        });
        System.out.println("sumResult = " + sumResult + " mulResult = "+mulResult);

        // data class
        Customer customer = new Customer("name","email");
        customer.component1();
        customer.component2();
        customer.getTestEvanField();



    }

    private int strJavaMapper(String str, Mapper mapper) {
        return mapper.mapper(str);
    }

    interface Mapper {
        int mapper(String str);
    }
}
