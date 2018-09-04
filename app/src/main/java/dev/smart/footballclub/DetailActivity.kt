package dev.smart.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    private var desc: String = ""
    private var pic: String = ""
    private lateinit var description: TextView
    private lateinit var poster: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            poster = imageView()
                    .lparams(width = dip(125), height = dip(125)) {
                        gravity = Gravity.CENTER_HORIZONTAL
                        padding = dip(15)
                        margin = dip(10)
                    }
            verticalLayout {
                description = textView()
            }
        }


        val intent = intent
        desc = intent.getStringExtra("name")
        pic = intent.getStringExtra("pic")
        description.text = desc
        poster.image = resources.getDrawable(pic.toInt())
    }
}

