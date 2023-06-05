package com.example.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var foodList=ArrayList<Food>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adding the food
        foodList.add(Food(name="Chicken", des = " this is my chicke",R.drawable.chicken))
        foodList.add(Food(name="Muchomo", des = " this is my chicke",R.drawable.muchomo))
        foodList.add(Food(name="Rolex", des = " this is my chicke",R.drawable.rollex))
        foodList.add(Food(name="Pizza", des = " this is my chicke",R.drawable.pizzar))
        foodList.add(Food(name="French Fries", des = " this is my chicke",R.drawable.french_fries))
        foodList.add(Food(name="Straw Berry ", des = " this is my chicke",R.drawable.strawberry_ice_cream))

        adapter= FoodAdapter(this,foodList)
        //assigning the list to the gridview
        //findViewById<GridView>(R.id.gridview)...u should the .adapter=adapter to make it connet to the grid view else
        //the app will display nothing
        findViewById<GridView>(R.id.gridview).adapter=adapter

    }
    class FoodAdapter:BaseAdapter {
        var foodList= ArrayList<Food>()
        var context:Context?=null

        constructor( context: Context?,foodList: ArrayList<Food>) : super() {
            this.foodList = foodList
            this.context = context
        }


        override fun getCount(): Int {
            return foodList.size
        }

        override fun getItem(position: Int): Any {
            return  position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(index: Int, convertView: View?, parent: ViewGroup?): View {
            var food = this.foodList[index]
            var inflater = context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview = inflater.inflate(R.layout.mylayout, null)
            foodview.findViewById<TextView>(R.id.textView).text = food.name!!
            foodview.findViewById<ImageView>(R.id.imageview).setImageResource(food.image!!)
            foodview.findViewById<ImageView>(R.id.imageview).setOnClickListener {
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                context!!.startActivity(intent)
            }
           return foodview

        }

    }
}