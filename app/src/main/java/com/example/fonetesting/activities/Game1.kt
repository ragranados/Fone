package com.example.fonetesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.fonetesting.R
import com.example.fonetesting.architecture_components.GameViewModel
import com.example.fonetesting.fragments.Complete_words
import kotlinx.android.synthetic.main.fragment_complete_words.*

class Game1 : AppCompatActivity(), Complete_words.SearchNewMovieListener {

    fun chose_option(option: String){

        var intento= tv_word.text.toString()

        tv_word.text=intento.substringBefore('_')+ option +intento.substringAfter('_')
    }

    override fun option1() {
        chose_option(opc1.text as String)
    }


    override fun option2() {
        chose_option(opc2.text as String)
    }

    override fun option3() {
        chose_option(opc3.text as String)
    }

    override fun option4() {
        chose_option(opc4.text as String)
    }

    override fun option5() {
        chose_option(opc5.text as String)
    }

    override fun option6() {
     chose_option(opc6.text as String)
    }

    override fun option7() {
        chose_option(opc7.text as String)
    }

    override fun option8() {
        chose_option(opc8.text as String)
    }

    override fun nextWord() {
        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val numero1 = tv_cont.getText().toString()
        val aux=numero1.toInt()

        val te= btn_verification.getText().toString()

        if(te.equals("Iniciar")){
            btn_verification.text="Verificar"
        }

        if(aux<lista.size-1){


            val palabra= tv_word.getText()

            var comprobando: Boolean=false

            comprobando= verification(palabra as String,aux)

            if(comprobando){
                tv_cont.text=((aux+1)).toString()

                viewModel.updateLevel(aux+1)
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
