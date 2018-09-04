package dev.smart.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main_menu.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainMenu : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        initdata()

        //inisiallisasi recyclerview
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerAdapter(this, items) {

            toast("${it.name}")
            startActivity<DetailActivity>("name" to "${it.desc}", "pic" to "${it.imageview}")
        }
    }

    private fun initdata() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.detail)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0), desc[i]))
            Log.d("_picAdress", image.toString())
        }
        image.recycle()
    }
}

