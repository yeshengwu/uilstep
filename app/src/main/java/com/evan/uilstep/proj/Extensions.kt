package com.evan.uilstep.proj

import com.evan.uilstep.codelabs.kotlin.Aquarium

/**
 * https://developer.android.com/codelabs/kotlin-bootcamp-extensions#4
 */
/**
 * 他妈的 对象的扩展 就是 他妈的 oc 的 Category。不要那么纠结 网上那些二手文章的 Receiver 乱七八糟概念绕晕，反编译看就行了。
 */
fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}

fun String.hasSpacesWithArg(index: Int): Boolean {
    println("hasSpacesWithArg. index = $index")
    val found = this.find { it == ' ' }
    return found != null
}

fun Aquarium.widthNotZero(): Boolean {
    return this.width != 0
}

fun main() {
    println("Does it have spaces?".hasSpaces())
    println("Does it hasSpacesWithArg?".hasSpacesWithArg(110))
    val aquarium7 = Aquarium(length = 25, width = 25, height = 40)
    println("widthNotZero = " + aquarium7.widthNotZero())
}

// 反编译
// public final class ExtensionsKt {
//   public static final boolean hasSpaces(@NotNull String $this$hasSpaces) {
//      Intrinsics.checkParameterIsNotNull($this$hasSpaces, "$this$hasSpaces");
//      // ....
//      return xxx
//}
//
// public static final boolean hasSpacesWithArg(@NotNull String $this$hasSpacesWithArg, int index) {
//
// }
//
// public static final boolean widthNotZero(@NotNull Aquarium $this$widthNotZero) {
//      Intrinsics.checkParameterIsNotNull($this$widthNotZero, "$this$widthNotZero");
//      return $this$widthNotZero.getWidth() != 0;
//   }
//
//   public static final void main() {
//      boolean var0 = hasSpaces("Does it have spaces?");
//      boolean var1 = false;
//      System.out.println(var0);
//      Aquarium aquarium7 = new Aquarium(25, 25, 40);
//      String var4 = "widthNotZero= " + widthNotZero(aquarium7);
//      boolean var2 = false;
//      System.out.println(var4);
//   }