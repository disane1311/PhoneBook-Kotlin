package com.example.phonebook

import User
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail_recycle.MyAdapter
import com.example.phonebook.ui.theme.PhoneBookTheme
import java.util.*
import android.view.*

val userList = listOf(
    User(1, "Vivian", "123-456-789786", "ivy@gmail.com"),
    User(2, "Josep", "123-456-789253", "jack@gmail.com"),
    User(3, "Katie", "123-456-789047", "katie@gmail.com"),
    User(4, "Leo", "123-456-789423", "leo@gmail.com"),
    User(5, "Mia", "123-456-789493", "mia@gmail.com"),
    User(6, "Noah", "123-456-789141", "noah@gmail.com"),
    User(7, "Olivia", "123-456-789567", "olivia@gmail.com"),
    User(8, "Peter", "123-456-789753", "peter@gmail.com"),
    User(9, "Quinn", "123-456-789056", "quinn@gmail.com"),
    User(10, "Ryan", "123-456-789036", "ryan@gmail.com"),
    User(11, "Sara", "123-456-789463", "sara@gmail.com"),
    User(12, "Alien", "123-456-789745", "alice@gmail.com"),
    User(13, "Taylor", "123-456-789224", "bob@gmail.com"),
    User(14, "Charlie", "123-456-789003", "charlie@gmail.com"),
    User(15, "Domas", "123-456-789004", "david@gmail.com"),
    User(16, "Eva", "123-456-789674", "eva@gmail.com"),
    User(17, "Frank", "123-456-789521", "frank@gmail.com"),
    User(18, "Grace", "123-456-789898", "grace@gmail.com"),
    User(19, "Pippy", "123-456-789442", "harry@gmail.com"),
    User(20, "Thomas", "123-456-789238", "tom@gmail.com")
)

class MainActivity : ComponentActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(userList)
        rv.adapter = myAdapter
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val clickedUser = myAdapter.getClickedUser()
        Log.d("TAG", clickedUser.toString())
        return when (item.itemId) {
            R.id.action_call -> {
                Log.d("TAG", "Call " + clickedUser?.getUserPhone())
                Toast.makeText(this@MainActivity, "Call " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_message -> {
                Log.v("TAG", "Send message to " + clickedUser?.getUserPhone())
                Toast.makeText(this, "Send message to " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_email -> {
                Log.v("TAG", "Send email to " + clickedUser?.getUserEmail())
                Toast.makeText(this, "Send email to " + clickedUser?.getUserEmail(), Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}

