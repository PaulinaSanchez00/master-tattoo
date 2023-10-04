package com.example.paulina.preinicio

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SelectEstilos : Fragment(R.layout.fragment_select_estilos) {
    private val TAG = "SelectEstilos"
    private lateinit var appDb: RegisterDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = requireView().findViewById<Button>(R.id.btnSaveSE)
        appDb = RegisterDatabase.getInstance(requireContext())
        kotlin.run {
            setGet()
        }
        btn.setOnClickListener {
            kotlin.run {
                chekedS()
            }
        }
    }

    fun swListSe(): List<SwitchCompat> {
        val swReal = requireView().findViewById<SwitchCompat>(R.id.SWRealismSE)
        val swTrash = requireView().findViewById<SwitchCompat>(R.id.SWTrashSE)
        val swTrad = requireView().findViewById<SwitchCompat>(R.id.SWTradSE)
        val swTrib = requireView().findViewById<SwitchCompat>(R.id.SWTribalSE)
        val swBio = requireView().findViewById<SwitchCompat>(R.id.SWBiomeSE)
        val swAcua = requireView().findViewById<SwitchCompat>(R.id.SWAcuaelaSE)
        val swBYW = requireView().findViewById<SwitchCompat>(R.id.SWBlackGraySE)
        val swBrush = requireView().findViewById<SwitchCompat>(R.id.SWBrushSE)
        val sw3D = requireView().findViewById<SwitchCompat>(R.id.SW3DSE)
        val swGeo = requireView().findViewById<SwitchCompat>(R.id.SWGeomeSE)
        val swGot = requireView().findViewById<SwitchCompat>(R.id.SWGoticSE)
        val swJap = requireView().findViewById<SwitchCompat>(R.id.SWJaponesSE)
        val swKaw = requireView().findViewById<SwitchCompat>(R.id.SWKawaiSE)
        val swDot = requireView().findViewById<SwitchCompat>(R.id.SWDotWorkSE)
        val swNeo = requireView().findViewById<SwitchCompat>(R.id.SWNeotradSE)
        val swMin = requireView().findViewById<SwitchCompat>(R.id.SWMinimSE)
        val swLett = requireView().findViewById<SwitchCompat>(R.id.SWLetterSE)
        val swOrnam = requireView().findViewById<SwitchCompat>(R.id.SWOrnamSE)
        val swThL = requireView().findViewById<SwitchCompat>(R.id.SWThinLSE)
        val swBlack = requireView().findViewById<SwitchCompat>(R.id.SWBlackSE)
        return listOf(
            sw3D, swAcua, swBio, swBYW, swBlack, swBrush, swDot, swGeo, swGot, swJap,
            swKaw, swLett, swMin, swNeo, swOrnam, swReal, swThL, swTrad, swTrash, swTrib
        )
    }


    @OptIn(DelicateCoroutinesApi::class)
    private fun setGet() {
        val sw = swListSe()
        GlobalScope.launch(Dispatchers.IO) {
            val tatootipe = appDb.TATOOTIPEDao.vista(1)
            var i = 0
            tatootipe.forEach { style ->
                sw[i].isChecked = style.STYLE == sw[i].text.toString()
                i += 1
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun chekedS() {
        val sw = swListSe()
        GlobalScope.launch(Dispatchers.IO) {
            sw.forEach { swp ->
                if (!swp.isChecked) {
                    appDb.TATOOTIPEDao.ocultar(swp.text.toString())
                } else {
                    appDb.TATOOTIPEDao.mostrar(swp.text.toString())
                }
            }

        }
        Toast.makeText(requireContext(), "Estilos Registrados", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_selectEstilos2_to_pre_Tarifa)
    }
}
