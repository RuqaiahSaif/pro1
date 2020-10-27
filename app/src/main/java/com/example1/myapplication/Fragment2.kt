package com.example1.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Fragment2 : Fragment() {

    private lateinit var studentRecyclerView: RecyclerView
    private var adapter: StudentAdapter?=null

    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    companion object {
        fun newInstance(): Fragment2 {
            return Fragment2()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment2, container, false)
        studentRecyclerView = view.findViewById(R.id.student_recycler_view) as RecyclerView
        studentRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun updateUI() {
        val students = studentViewModel.students
        adapter = StudentAdapter(students)
        studentRecyclerView.adapter = adapter
    }

    private inner class StudentHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idTextView: TextView = itemView.findViewById(R.id.id)
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val resultTextView: TextView = itemView.findViewById(R.id.pass)
        private lateinit var student: Student

        fun bind(student: Student) {
            this.student = student
           idTextView.text = this.student.id.toString()
            nameTextView.text = this.student.name
        }

    }

    private inner class StudentAdapter(var students: List<Student>) :
        RecyclerView.Adapter<StudentHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : StudentHolder {
            val view = layoutInflater.inflate(R.layout.fragment2, parent, false)

            return StudentHolder(view)
        }



        override fun getItemCount() = students.size
        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            val student = students[position]
            holder.bind(student)



        }
        }
    }

