package pe.edu.upc.wearrecyclerexample

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.recyclerview_layout.*
import java.util.ArrayList

class MainActivity : WearableActivity() {

    var countries : ArrayList = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()


        val adapter: WearRecyclerAdapter = WearRecyclerAdapter(this, countries)
        recyclerview_layout
    }
}
