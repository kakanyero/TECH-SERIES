package com.example.gridview

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
    var adapter : FoodAdapter?=null
    var foodlist= arrayListOf<Food>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodlist.add(Food("CHIKEN","we r all the way up to et  beautiful chiken for your birthday",R.drawable.chicken))
        foodlist.add(Food("HONEY","we r all the way up to et  beautiful chiken for your birthday",R.drawable.honey))
        foodlist.add(Food("ESPRESSO","we r all the way up to et  beautiful chiken for your birthday",R.drawable.espresso))
        foodlist.add(Food("COFFEE POT","we r all the way up to et  beautiful chiken for your birthday",R.drawable.coffee_pot))
        foodlist.add(Food("FRENCH FRIES","we r all the way up to et  beautiful chiken for your birthday",R.drawable.french_fries))
        foodlist.add(Food("SUGAR CUBES","we r all the way up to et  beautiful chiken for your birthday",R.drawable.sugar_cubes))
        foodlist.add(Food("STRAW BERRY ICE","we r all the way up to et  beautiful chiken for your birthday",R.drawable.strawberry_ice_cream))
        foodlist.add(Food("MUCHOMO","we r all the way up to et  beautiful chiken for your birthday",R.drawable.muchomo))
        foodlist.add(Food("PIZZA","we r all the way up to et  beautiful chiken for your birthday",R.drawable.pizzar))
        foodlist.add(Food("ROLLEX","we r all the way up to et  beautiful chiken for your birthday",R.drawable.rollex))

        adapter= FoodAdapter(this,foodlist)
        findViewById<GridView>(R.id.gridview).adapter=adapter

    }
    class FoodAdapter : BaseAdapter {
        var foodlist= arrayListOf<Food>()
        var context: Context?=null

        constructor(context: Context?,foodlist: ArrayList<Food>) : super() {
            this.foodlist = foodlist
            this.context = context
        }

        override fun getCount(): Int {
            return foodlist.size
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(index: Int, p1: View?, p2: ViewGroup?): View {
            val food=this.foodlist[index]
            var inflater=context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview=inflater.inflate(R.layout.mylayout,null)
            foodview.findViewById<ImageView>(R.id.imageview).setImageResource(food.image!!)
            foodview.findViewById<TextView>(R.id.textView).text=food.name!!
            foodview.findViewById<ImageView>(R.id.imageview).setOnClickListener(){
                val intent=Intent(context,FoodDetailsActivity::class.java)
                //intent moves for one activity to another.... but note that here we are not just moving to
                //to another activity but we want to carry some information to the new activity as bell
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }

            return foodview
        }

    }
}