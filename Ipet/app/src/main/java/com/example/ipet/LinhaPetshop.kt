package com.example.ipet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class LinhaPetshop : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_linha_petshop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tvNome:TextView = view.findViewById(R.id.tv_nome)
        val ivPetShop:ImageView = view.findViewById(R.id.iv_petshop)
        val nome = arguments?.getString("nome")
        val endereco = arguments?.getString("enderecoImagem")
        tvNome.text = nome;
        Picasso.with(view.context).load(endereco).into(ivPetShop);
    }
}