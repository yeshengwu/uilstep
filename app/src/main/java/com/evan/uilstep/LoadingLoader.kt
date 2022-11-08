package com.evan.uilstep

import android.os.Handler
import android.os.Looper
import android.util.Log

// 作者：GitLqr
//链接：https://juejin.cn/post/7115781013170552840
//来源：稀土掘金
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/**
 * Loading 加载器
 *
 * @author GitLqr
 * @since 2022/7/2
 */
object LoadingLoader {

//    private var isInited = false // 防止多次初始化
//    private lateinit var onLoadFail: () -> Unit // 远程loading加载失败时的回调
//    private lateinit var onLoadComplete: () -> Unit // 加载完成后回调（无论成功失败）

    // 反编译为 函数对象
    // private static Functions<Unit> onLoadComplete;
    // private static Functions<Unit> onLoadFail;

//    // 匿名函数
//    private val stringLengthFunc: (String) -> Int = { input ->
//        input.length
//    }
//
//    // 匿名函数
//    private val onLoadFailEvan: (name: String, age: Int) -> String =
//        { nameInput: String, ageInput: Int ->
//            nameInput + ageInput
//        }

    //反编译为
    //   private static final Function1<String, Integer> stringLengthFunc = LoadingLoader$stringLengthFunc$1.INSTANCE;
    //    private static final Function2<String, Integer, String> onLoadFailEvan = LoadingLoader$onLoadFailEvan$1.INSTANCE;

    // LoadingLoader$onLoadFailEvan$1 为单独一个类：Function2： 2个参数的函数对象。
    // final class LoadingLoader$onLoadFailEvan$1 extends Lambda implements Function2<String, Integer, String> {
    //
    //     public /* bridge */ /* synthetic */ String invoke(String str, Integer num) {
    //          //
    //     }
    // }

//    fun init2(
//        onLoadFail: (name: String, age: Int) -> String = { s: String, i: Int -> s + i },
//        onLoadComplete: () -> Unit = {}
//    ): LoadingLoader {
//        log("init2 test")
//        return this
//    }
    // init2 反编译为：
    //   public final LoadingLoader init2(Function2<? super String, ? super Integer, String> onLoadFail2, Functions<Unit> onLoadComplete2) {
    //        Intrinsics.checkParameterIsNotNull(onLoadFail2, "onLoadFail");
    //        Intrinsics.checkParameterIsNotNull(onLoadComplete2, "onLoadComplete");
    //        log("init2 test");
    //        return this;
    //    }

//    fun init(onLoadFail: () -> Unit = {}, onLoadComplete: () -> Unit = {}): LoadingLoader {
//        if (!isInited) {
//            this.onLoadFail = onLoadFail
//            this.onLoadComplete = onLoadComplete
//            isInited = true
//        } else {
//            log("you have inited, this time is not valid")
//        }
//        return this
//    }
//
//    fun go() {
//        if (isInited) {
//            loadRemoteLoading(callback = { isSuccess ->
//                if (!isSuccess) onLoadFail()
//                onLoadComplete()
//
//                destroy() // 使命完成，释放资源
//            })
//        } else {
//            log("you must invoke init() firstly")
//        }
//    }

    private fun loadRemoteLoading(callback: (boolean: Boolean) -> Unit) {
        // 模拟远程 Loading 模块加载失败
        Handler(Looper.getMainLooper()).postDelayed({
            callback(false)
        }, 1000)
    }

    // 反编译： 但这里不知为啥是这样？？？ Function1.this.invoke(false);
    // private final void loadRemoteLoading(final Function1<? super Boolean, Unit> function1) {
    //        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.example.pureandroid.splash.LoadingLoader$loadRemoteLoading$1
    //            @Override // java.lang.Runnable
    //            public final void run() {
    //                Function1.this.invoke(false);
    //            }
    //        }, 1000L);
    //    }
//
//    private fun log(msg: String) {
//        Log.e("LoadingUpdater", msg)
//    }
//
//    fun destroy() {
//        this.onLoadFail = {}
//        this.onLoadComplete = {}
//        this.isInited = false
//    }
}

