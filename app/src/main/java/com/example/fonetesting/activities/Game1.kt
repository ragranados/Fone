package com.example.fonetesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fonetesting.R
import com.example.fonetesting.fragments.Complete_words
import kotlinx.android.synthetic.main.fragment_complete_words.*

class Game1 : AppCompatActivity(), Complete_words.SearchNewMovieListener {
    override fun option1() {

    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc1.text +intento.substringAfter('_')



}


override fun option2() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc2.text +intento.substringAfter('_')
}

override fun option3() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc3.text +intento.substringAfter('_')
}

override fun option4() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc4.text +intento.substringAfter('_')
}

override fun option5() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc5.text +intento.substringAfter('_')
}

override fun option6() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc6.text +intento.substringAfter('_')
}

override fun option7() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc7.text +intento.substringAfter('_')
}

override fun option8() {
    var intento= tv_word.text.toString()

    val index=intento.indexOf('_')
    Log.d("HG", index.toString())

    Log.d("HG", intento.substringBefore('_'))
    Log.d("HG", intento.substringAfter('_'))


    tv_word.text=intento.substringBefore('_')+ opc8.text +intento.substringAfter('_')
}

override fun nextWord() {
    val numero1 = tv_cont.getText().toString()
    val aux=numero1.toInt()

    if(aux<lista.size-1){


        val palabra= tv_word.getText()

        var comprobando: Boolean=false

        comprobando= verification(palabra as String,aux)

        if(comprobando){
            tv_cont.text=((aux+1)).toString()
            tv_word.text=listaaux[aux+1]
        }
        else{
            tv_word.text=listaaux[aux]
        }
    }
    else{
        tv_word.text="Fin del juego"
    }






}
fun verification(texto:String, posicion:Int):Boolean{

    if(texto==lista[posicion]){
        return true
    }
    else{
        return false
    }

}


val lista = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado")
val listaaux= arrayOf("L_n_s", "Ma_t_s", "M_e_col_s", "J_e_e_", "V_e_n_s", "S_b_d_")

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_game1)


    val fDetalles= Complete_words()
    fDetalles.arguments= intent.extras
    supportFragmentManager.beginTransaction().replace(R.id.container,fDetalles).commit()
}
}
