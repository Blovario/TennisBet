package com.example.tennisbet.matchList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tennisbet.data.Match
import androidx.recyclerview.widget.RecyclerView
import com.example.tennisbet.R

class MatchsAdapter (private val mMatchs : List<Match>, private val onClick: (Match) -> Unit) : RecyclerView.Adapter<MatchsAdapter.MatchsViewHolder>() {
    inner class MatchsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val joueur1: TextView = itemView.findViewById(R.id.namePlayer1)
        private val joueur2: TextView = itemView.findViewById(R.id.namePlayer2)
        private val manche1: TextView = itemView.findViewById(R.id.scoreSet1)
        private val manche2: TextView = itemView.findViewById(R.id.scoreSet2)
        private val manche3: TextView = itemView.findViewById(R.id.scoreSet3)

        private var currentMatch: Match? = null

        init {
            itemView.setOnClickListener {
                currentMatch?.let {
                    onClick(it)
                }
            }
        }

        fun bind(match: Match) {
            joueur1.text = match.joueur1
            joueur2.text = match.joueur2
            manche1.text = match.pointage.jeu[0][0].toString() + " - " + match.pointage.jeu[0][1].toString()
            if(match.pointage.jeu.size > 1) {
                manche2.text = match.pointage.jeu[1][0].toString() + " - " + match.pointage.jeu[1][1].toString()
            } else {
                manche2.text = ""
            }
            if(match.pointage.jeu.size > 2) {
                manche3.text = match.pointage.jeu[2][0].toString() + " - " + match.pointage.jeu[2][1].toString()
            } else {
                manche3.text = ""
            }

            currentMatch = match
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val matchView = inflater.inflate(R.layout.match_item, parent, false)
        print("onCreateViewHolder")
        return MatchsViewHolder(matchView)
    }

    override fun onBindViewHolder(holder: MatchsViewHolder, position: Int) {
        val match : Match = mMatchs[position]
        Log.d("MatchsAdapter", "$match")
        holder.bind(match)
    }

    override fun getItemCount() = mMatchs.size
}
