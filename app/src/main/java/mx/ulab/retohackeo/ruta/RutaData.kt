package mx.ulab.retohackeo.ruta

import com.google.gson.annotations.SerializedName

data class RutaData(
    @SerializedName("carrera") val carrera: String,
    @SerializedName("area") val area: String,
    @SerializedName("duracion") val duracion: String,
    @SerializedName("cargaRecomendada") val cargaRecomendada: String,
    @SerializedName("disponible") val disponible: String,
    @SerializedName("materias") val materias: List<String>
)