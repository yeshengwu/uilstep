package com.evan.uilstep.proj

open class TestAClass {
}

class SubClas : TestAClass() {

}

abstract class SubAbsClass1 : TestAClass() {

}

abstract class SubAbsClass2 : java.io.Serializable {

}

/**
 *  继承 父类，则调用 构造器，实现接口，则直接写接口名即可
 */
abstract class SubAbsClass3 : TestAClass(), java.io.Serializable {

}

class SubAbsClass4 : SubAbsClass3() {

}




