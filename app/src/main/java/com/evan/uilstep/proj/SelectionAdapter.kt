package com.evan.uilstep.proj

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener

class SelectionAdapter(var recyclerView: RecyclerView?) :
    RecyclerView.Adapter<BaseListViewHolder<String>>() {

    init {
        recyclerView?.let {
            println("rv is nullable,? let ok。 it =  $it")
        }

        recyclerView?.apply {
            println("rv is nullable,? apply ok")
        }

        recyclerView?.addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        val onScrollListener: OnScrollListener = object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        }
        recyclerView?.addOnScrollListener(onScrollListener)

        recyclerView?.setOnClickListener {
            println("IN OnClick")
        }
    }

//    init {
//        recyclerView.let {
//            println("rv is nullable,danger")
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<String> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<String>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}

fun main() {
    println("evan test 2")

    val testStringExt = "i am string want to test string ext method"
    println(testStringExt + " hasSpaces() = " + testStringExt.hasSpaces())

}
// decompile
// String testStringExt = "evan test 2";
//      boolean var1 = false;
//      System.out.println(testStringExt);
//      testStringExt = "i am string want to test string ext method";
//      String var3 = testStringExt + " hasSpaces() = " + ExtensionsKt.hasSpaces(testStringExt);
//      boolean var2 = false;
//      System.out.println(var3);