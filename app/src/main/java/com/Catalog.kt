package com

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.learning.mymoviecatalog.R

class Catalog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val detailImage = intent.getIntExtra("imgPhoto", R.id.gambar_catalog)
        val itemTitle = intent.getStringExtra("itemTittle")
        val itemDescription = intent.getStringExtra("itemDescription")

        val img_catalog: ImageView =findViewById(R.id.gambar_catalog)
        val judul_catalog: TextView =findViewById(R.id.tv_item_catalog)
        val description_catalog: TextView=findViewById(R.id.tv_item_description_catalog)

        img_catalog.setImageResource(detailImage)
        judul_catalog.text= itemTitle
        description_catalog.text= itemDescription

    }
}