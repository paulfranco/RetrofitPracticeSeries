package co.paulfran.retrofitpracticeseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.paulfran.retrofitpracticeseries.R
import co.paulfran.retrofitpracticeseries.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var posts = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.userId.text = posts[position].userId.toString()
        holder.itemView.idTxt.text = posts[position].id.toString()
        holder.itemView.title.text = posts[position].title
        holder.itemView.body.text = posts[position].body
    }

    fun setData(newList: List<Post>) {
        posts = newList
        notifyDataSetChanged()
    }
}