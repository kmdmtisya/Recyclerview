package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Follow AndroidDevs", false),
            Todo("Learn about RecycleView", true),
            Todo("Feed my cat", false),
            Todo("Prank my Boss", false),
            Todo("Eat some curry", true),
            Todo("Ask my crush out", false),
            Todo("Take a shower", false)
        )

        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size -1)
        }
    }
}