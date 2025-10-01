package com.example.uts_nmp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


 class StudentAdapter(private val studentList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoImageView : ImageView = itemView.findViewById(R.id.imgFoto)
        val nameTextView: TextView = itemView.findViewById(R.id.txtNama)
        val nrpTextView: TextView = itemView.findViewById(R.id.txtNRP)
    }
      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.item_student_card, parent, false)
         return StudentViewHolder(view)
     }

      override fun getItemCount(): Int {
            return studentList.size
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            val student = studentList[position]

            holder.nameTextView.text = student.nama
            holder.nrpTextView.text = student.nrp

            val context = holder.itemView.context
            if (student.foto.isNotEmpty()) {
                val resourceId = context.resources.getIdentifier(
                    student.foto.substringBefore("."),
                    "drawable",
                    context.packageName
                )

                if (resourceId != 0) {
                    holder.fotoImageView.setImageResource(resourceId)
                } else {
                    holder.fotoImageView.setImageResource(R.drawable.ic_person_placeholder)
                }
            } else {
                holder.fotoImageView.setImageResource(R.drawable.ic_person_placeholder)
            }

            holder.itemView.setOnClickListener {
                val intent = android.content.Intent(context, DetailActivity::class.java)
                intent.putExtra("NAMA", student.nama)
                intent.putExtra("NRP", student.nrp)
                intent.putExtra("JURUSAN", student.jurusan)
                intent.putExtra("DESKRIPSI", student.deskripsi)
                intent.putExtra("FOTO", student.foto)
                context.startActivity(intent)
            }
        }
}