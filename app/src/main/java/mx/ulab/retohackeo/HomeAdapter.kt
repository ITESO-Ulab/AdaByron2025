package mx.ulab.retohackeo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.ulab.retohackeo.ruta.RutaActivity

class HomeAdapter(private val items: List<Any>, private val context: Context)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_RUTA = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RutaCurricular -> VIEW_RUTA
            else -> throw IllegalArgumentException("Tipo de elemento desconocido en la posición $position")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_RUTA -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.ruta_layout, parent, false)
                RutaViewHolder(view)
            }
            else -> throw IllegalArgumentException("Tipo de vista desconocido")
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position:
    Int) {
        when (holder) {
            is RutaViewHolder -> {
                val item = items[position] as RutaCurricular
                holder.bind(item, context)
            }
        }
    }

    override fun getItemCount() = items.size
    class RutaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: RutaCurricular, context: Context) {
            val textView : TextView = itemView.findViewById(R.id.titleTV)
            textView.text = item.texto
            itemView.setOnClickListener {
                Log.d("HomeAdapter", "tap tap tap")
                val intent = Intent(context, RutaActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}

data class RutaCurricular(val texto: String)