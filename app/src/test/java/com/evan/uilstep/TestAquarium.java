//package com.evan.uilstep;
//
//import org.junit.Test;
//
//import kotlin.Unit;
//import kotlin.jvm.functions.Function1;
//import kotlin.jvm.internal.Intrinsics;
//
//public class TestAquarium {
//
//    @Test
//    public void addition_isCorrect() {
//        Aquarium<WaterSupply> aquarium = new Aquarium<>(new TapWater());
//
//        addItemTo(aquarium);
//
//        Object applyResult = TestAquarium.apply(110, new Function1<Integer, Unit>() {
//            @Override
//            public Unit invoke(Integer integer) {
//                return Unit.INSTANCE;
//            }
//        });
//        System.out.println("applyResult = "+applyResult); // applyResult = 110
//    }
//
//    /**
//     * java 常规范型例子，但到了 kotlin 需要 Aquarium 范型参数T 加 out 才能编译通过。
//     * https://developer.android.com/codelabs/kotlin-bootcamp-generics#2
//     *
//     * @param aquarium
//     */
//    public void addItemTo(Aquarium<? extends WaterSupply> aquarium) {
//        System.out.println(("item added " + aquarium));
//    }
//
//    public static final <T> T apply(T t, Function1<? super T, Unit> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        block.invoke(t);
//        return t;
//    }
//
//}
