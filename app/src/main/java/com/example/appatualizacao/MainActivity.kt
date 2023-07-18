package com.example.appatualizacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.appatualizacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Calcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.Calcular) {
            calculate()
        }
    }
    private fun Valid(): Boolean{
        return (binding.Distancia.text.toString() != ""
                && binding.Preco.text.toString() != ""
                && binding.Autonomia.text.toString() != ""
                &&binding.Autonomia.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if (Valid()){
        val distancia = binding.Distancia.text.toString().toFloat()
        val preco = binding.Preco.text.toString().toFloat()
        val auto = binding.Autonomia.text.toString().toFloat()
        val total = (distancia * preco) / auto

        binding.Valor.text = "R$ ${"%.2f".format(total)}"
        }
    }
}