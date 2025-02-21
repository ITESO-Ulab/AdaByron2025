package mx.ulab.retohackeo.ruta

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.ulab.retohackeo.R

class RutaAdapter(
    private val items: List<String>,
    private val creditos: String,
    private val status: String,
) : RecyclerView.Adapter<RutaAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvMateria : TextView = itemView.findViewById(R.id.tvMateria)
        var tvCreditos : TextView = itemView.findViewById(R.id.tvCreditos)
        var tvStatus : TextView = itemView.findViewById(R.id.tvStatus)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.programa_layout, parent,
                false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMateria.text = items[position]
        holder.tvCreditos.text = creditos
        holder.tvStatus.text = status
        if (status != "Disponible") {
            holder.tvStatus.setTextColor(Color.rgb(250, 47, 10))
        }
    }
    override fun getItemCount() = items.size
}