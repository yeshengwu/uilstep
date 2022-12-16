package com.evan.uilstep.proj

/**
 * kotlin Standard.kt
 * jax反编译看看
 */

//public inline fun <R> run(block: () -> R): R {
//
//    return block()
//}
//
//public inline fun <T, R> T.run(block: T.() -> R): R {
//
//    return block()
//}
//
//public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
//
//    return receiver.block()
//}
//
//public inline fun <T> T.apply(block: T.() -> Unit): T {
//
//    block()
//    return this
//}
//
//public inline fun <T> T.also(block: (T) -> Unit): T {
//
//    block(this)
//    return this
//}
//
//public inline fun <T, R> T.let(block: (T) -> R): R {
//
//    return block(this)
//}

// jadx
// public static final <R> R run(Functions<? extends R> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        return (R) block.invoke();
//    }
//
//    public static final <T, R> R run(T t, Function1<? super T, ? extends R> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        return (R) block.invoke(t);
//    }
//
//    public static final <T, R> R with(T t, Function1<? super T, ? extends R> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        return (R) block.invoke(t);
//    }
//
//    public static final <T> T apply(T t, Function1<? super T, Unit> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        block.invoke(t);
//        return t;
//    }
//
//    public static final <T> T also(T t, Function1<? super T, Unit> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        block.invoke(t);
//        return t;
//    }
//
//    public static final <T, R> R let(T t, Function1<? super T, ? extends R> block) {
//        Intrinsics.checkParameterIsNotNull(block, "block");
//        return (R) block.invoke(t);
//    }