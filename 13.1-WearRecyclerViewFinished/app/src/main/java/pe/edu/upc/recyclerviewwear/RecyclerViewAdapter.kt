package pe.edu.upc.recyclerviewwear

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.TextView
import kotlinx.android.synthetic.main.recycler_view_layout.view.*


class RecyclerViewAdapter (private val source: Array<String>, context: Context):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = inflater.inflate(R.layout.recycler_view_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = source.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = source[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val textView: TextView = itemView.title

        init {
            with(itemView){
                setOnClickListener(this@ViewHolder)
            }
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "click")
        }
    }
}