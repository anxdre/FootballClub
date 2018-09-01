package dev.smart.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {

    //    private lateinit var linearLayoutManager: LinearLayoutManager
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)


        initdata()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerAdapter(this, items) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initdata() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0)))
        }
        image.recycle()
    }

}
