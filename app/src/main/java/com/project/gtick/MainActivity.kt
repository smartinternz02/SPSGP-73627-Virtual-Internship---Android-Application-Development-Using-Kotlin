package com.project.gtick

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)

    lateinit var string: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val item: ArrayList<String> = ArrayList()
        val rootLayout = findViewById<ConstraintLayout>(R.id.rootLayout)
        val t1=findViewById<TextView>(R.id.textView)
        val name=findViewById<EditText>(R.id.editTextTextPersonName2)
        var tick=findViewById<ImageView>(R.id.imageView3)
        var MLIST = findViewById<ListView>(R.id.listview)
        var arrayAdapter: ArrayAdapter<*>
        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
        tick.setOnClickListener{

            string = name.text.toString()
            item.add(string)
            Toast.makeText(applicationContext,
                "Entered: "+string, Toast.LENGTH_SHORT).show()

            MLIST.adapter=arrayAdapter
        }
        MLIST.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, i, _ ->
            Toast.makeText(applicationContext, "Removed: "+item.get(i), Toast.LENGTH_SHORT).show()
            item.removeAt(i)
            arrayAdapter.notifyDataSetChanged()

            true
        }





    }

    }
