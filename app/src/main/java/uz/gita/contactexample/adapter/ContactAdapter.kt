package uz.gita.contactexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


import androidx.recyclerview.widget.RecyclerView
import uz.gita.contactexample.R
import uz.gita.contactexample.data.model.ContactData
import uz.gita.contactexample.utils.getDrawableResId


class ContactAdapter : ListAdapter<ContactData, ContactAdapter.ViewHolder>(Callback) {

    private var deleteListener: ((ContactData) -> Unit)? = null

    private var editListener: ((ContactData) -> Unit)? = null

    fun setOnDeleteListener(block: ((ContactData) -> Unit)) {
        deleteListener = block
    }

    fun setOnEditListener(block: (ContactData) -> Unit) {
        editListener = block
    }


    object Callback : DiffUtil.ItemCallback<ContactData>() {

        override fun areItemsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
                    && oldItem.number == newItem.number && oldItem.image == newItem.image
        }


    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.txtNameContact)
        val number: TextView = view.findViewById(R.id.txtNumberContact)
        val img: ImageView = view.findViewById(R.id.imgContact)
        val delete: ImageButton = view.findViewById(R.id.btnDelete)
        val edit: ImageButton = view.findViewById(R.id.btnEdit)

        fun bind() {
            val item = getItem(adapterPosition)
            name.text = item.name
            number.text = item.number
            img.setImageResource(getDrawableResId(view.context, item.image))
        }

        init {
            delete.setOnClickListener {
                deleteListener?.invoke(getItem(adapterPosition))
            }
            edit.setOnClickListener {
                editListener?.invoke(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }
}

