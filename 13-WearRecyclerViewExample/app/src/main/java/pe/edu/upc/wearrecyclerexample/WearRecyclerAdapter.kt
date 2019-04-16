package pe.edu.upc.wearrecyclerexample

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.content.Context
import android.view.View
import android.widget.TextView


class WearRecyclerAdapter(context: Context, miArreglo: List<String>) :
    RecyclerView.Adapter<WearRecyclerAdapter.ViewHolder>(){

    private var miArreglo: List<String> = ArrayList()
    private val mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(context)
        this.miArreglo = miArreglo
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = mInflater.inflate(recyclerview_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val name = miArreglo[i]
        viewHolder.myTextView.text = name
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var myTextView: TextView

        init {
            myTextView = country_name
        }

    }

    override fun getItemCount(): Int {
        return miArreglo.size
    }

    fun getMiArreglo(): List<String> {
        return miArreglo
    }

    fun setMiArreglo(miArreglo: List<String>): WearRecyclerAdapter {
        this.miArreglo = miArreglo
        return this
    }


}