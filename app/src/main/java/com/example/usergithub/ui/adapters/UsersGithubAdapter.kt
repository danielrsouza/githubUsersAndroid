package com.example.usergithub.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.usergithub.R
import com.example.usergithub.data.model.Users

class UsersGithubAdapter :
    RecyclerView.Adapter<UsersGithubAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var users: MutableList<Users> = mutableListOf()

    fun setUsers(listOfUsers: List<Users>) {
        this.users.addAll(listOfUsers)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar: ImageView
        val login: TextView
        val githubLink: TextView

        init {
            avatar = view.findViewById(R.id.avatar)
            login = view.findViewById(R.id.login)
            githubLink = view.findViewById(R.id.htmlUrl)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        context = viewGroup.context

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.users_github_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(context).load(users[position].avatar).into(viewHolder.avatar)
        viewHolder.githubLink.text = users[position].htmlUrl
        viewHolder.login.text = users[position].login
    }

    override fun getItemCount() = users.size
}