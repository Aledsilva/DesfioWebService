package com.example.choreimaspassobem.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.choreimaspassobem.R
import com.example.choreimaspassobem.ui.activities.ActDetailsJAVA
import com.example.choreimaspassobem.model.Results
import com.squareup.picasso.Picasso


class MainAdapter(val comicsList: MutableSet<Results>) : RecyclerView.Adapter<MyHQViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHQViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val home_itens = layoutInflater.inflate(R.layout.home_itens, parent, false)
        return MyHQViewHolder(home_itens)

    }

    override fun onBindViewHolder(holder: MyHQViewHolder, position: Int) {
        val comic = comicsList.elementAt(position)

        Picasso.get().load("${comic.thumbnail.path}.${comic.thumbnail.extension}").into(holder.image_hq)
        holder.name_hq.text = comic.title

        holder.cardviewGerada.setOnClickListener {v ->
            val intent = Intent(v.context, ActDetailsJAVA::class.java)
            intent.putExtra("COMICAO", comic)
                v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }

}

class MyHQViewHolder( view: View) : RecyclerView.ViewHolder(view) {

    val image_hq: ImageView = itemView.findViewById(R.id.image_hq)
    val name_hq: TextView = itemView.findViewById(R.id.hq_edition)
    val cardviewGerada: View = itemView.findViewById(R.id.CardView)

}