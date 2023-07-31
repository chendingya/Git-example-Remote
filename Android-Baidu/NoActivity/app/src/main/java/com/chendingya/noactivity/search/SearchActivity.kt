package com.chendingya.noactivity.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.chendingya.noactivity.R

class SearchActivity : AppCompatActivity() {
    private var searchview: SearchView? = null
    private var search_txt: String? = null
    private var webview: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchview = findViewById<SearchView>(R.id.searchView)
        webview = findViewById<WebView>(R.id.webview)
        //跳转百度
        findViewById<View>(R.id.search).setOnClickListener { TurntoWeb() }

        /**
         * 将之前搜索的文字回显在搜索框中。
         * 注意，search_txt是你保存搜索文本的变量。
         * 确保在调用setQuery方法之前，search_txt已经获取到用户输入的文字。
         */
        searchview?.setQuery(search_txt, false)

        searchview?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // 当点击搜索按钮时触发该方法
            override fun onQueryTextSubmit(query: String): Boolean {
                TurntoWeb()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

    }

    private fun TurntoWeb() {
        search_txt = searchview!!.query.toString()
        //声明WebSettings子类
        val webSettings = webview!!.settings

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.javaScriptEnabled = true
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可


        //设置自适应屏幕，两者合用
        webSettings.useWideViewPort = true //将图片调整到适合webview的大小
        webSettings.loadWithOverviewMode = true // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。
        webSettings.builtInZoomControls = true //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false //隐藏原生的缩放控件

        //其他细节操作
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK //关闭webview中缓存
        webSettings.allowFileAccess = true //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8" //设置编码格式
        webview!!.loadUrl("https://www.baidu.com/s?wd=$search_txt")
        webview!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
    }
}