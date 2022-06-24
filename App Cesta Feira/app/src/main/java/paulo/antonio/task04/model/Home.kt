package paulo.antonio.task04.model

import android.graphics.drawable.Icon

class Home {
    data class header(
        val search: String,
        val icon: Int,
        val local: String,
        val imgMap: Int,
        val ImgMenu: Int
    )

    data class Banner(
        val id: Int,
        val bannerUrl: String
    )

    data class Category(
        val id: Int,
        val title: String,
        val next: String,
        val logoUrl: Int,
    )




}