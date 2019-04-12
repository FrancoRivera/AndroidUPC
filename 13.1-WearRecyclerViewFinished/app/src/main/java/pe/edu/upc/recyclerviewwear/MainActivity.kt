package pe.edu.upc.recyclerviewwear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : WearableActivity() {
    private var names = arrayOf("1","2","3","4","5")
    private lateinit var myAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        myAdapter = RecyclerViewAdapter(names,this)
        recyclerView.apply {
            isEdgeItemsCenteringEnabled = true
            adapter = myAdapter
            layoutManager = WearableLinearLayoutManager(this@MainActivity)
        }
    }
}
