package mx.ulab.retohackeo.ruta

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.ulab.retohackeo.Constants
import mx.ulab.retohackeo.databinding.ActivityRutaBinding

class RutaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRutaBinding
    rutaCurricularType = object : TypeToken<List<RutaData>>() {}.type
    val programaDataList: List<RutaData> =
        Gson().fromJson(Constants.rutaCurricularJson, rutaCurricularType)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRutaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        var items = arrayListOf<String>()
        programaDataList.forEach {
            items.add(it.carrera)
        }
        var materiasPrograma = emptyList<String>()
        val spinner: Spinner = binding.searchView
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
// Obtén el elemento seleccionado usando position
                val item = items[position]
// Haz algo con el elemento seleccionado
                Log.d("selectedItem", "$position.- $item")
                materiasPrograma = programaDataList[position].materias
                val duracion = programaDataList[position].duracion
                val cargaRecomendada = programaDataList[position].cargaRecomendada
                val disponible = programaDataList[position].disponible
                recyclerView.adapter = RutaAdapter(materiasPrograma, duracion,
                    cargaRecomendada, disponible)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
// Otra lógica para cuando no se selecciona nada
            }
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
