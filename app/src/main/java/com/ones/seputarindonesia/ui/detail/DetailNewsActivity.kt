package com.ones.seputarindonesia.ui.detail

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.ones.seputarindonesia.data.model.ArticlesItem
import com.ones.seputarindonesia.databinding.ActivityDetailNewsBinding
import com.squareup.picasso.Picasso

class DetailNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailNewsBinding

    companion object{
        const val DATA_NEWS = "data_news"
        const val DATE_NEWS = "date_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        val dataNews = intent.getParcelableExtra<ArticlesItem>(DATA_NEWS)
        val date = intent.getStringExtra(DATE_NEWS)
        setContentView(binding.root)
        setUpXml(dataNews , date)
        setUpWebView(dataNews)
    }

    private fun setUpWebView(dataNews: ArticlesItem?) {
        val webSetting = binding.wvDetail.settings
        webSetting.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        binding.wvDetail.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.loadingView.root.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.loadingView.root.visibility = View.GONE
            }
        }
        dataNews?.link?.let { binding.wvDetail.loadUrl(it) }
    }

    private fun setUpXml(dataNews: ArticlesItem? , date:String?) {
        binding.apply {
            detailTitle.text = dataNews?.title
            detailDescription.text = dataNews?.description
            detailPublishedAt.text = dataNews?.pubDate

            Picasso.get()
                .load(dataNews?.thumbnail)
                .fit()
                .centerInside()
                .into(detailImage)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }


}