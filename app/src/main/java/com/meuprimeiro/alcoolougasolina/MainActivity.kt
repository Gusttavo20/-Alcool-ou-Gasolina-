package com.meuprimeiro.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btCalcular(view: View){
        //recuperando valores digitados
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validarCampos = validarCampos(precoAlcool, precoGasolina)
        if ( validarCampos ){
            calcularMelhorPreco( precoAlcool, precoGasolina )
        }else{
            resultado.setText("Preencha os preços primeiro!")
        }

    }
      fun validarCampos( precoAlcool: String , precoGasolina: String) : Boolean{
          var camposValidados: Boolean = true

          if (precoAlcool == null || precoAlcool.equals("")){
              camposValidados = false
          }else if (precoGasolina == null || precoGasolina.equals("")){
              camposValidados = false
          }
          return camposValidados
      }


     fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

          var valorAlcool = precoAlcool.toDouble()
          var valorGasolina = precoGasolina.toDouble()

          var resultadoPreco = valorAlcool / valorGasolina

          if ( resultadoPreco >= 0.7 ){
              resultado.setText("Melhor utilizar Gasolina!")
          }else{
              resultado.setText("Melhor utilizar álcool!")
          }
      }
}

