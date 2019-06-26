package com.example.fonetesting.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.fonetesting.R
import com.example.fonetesting.architecture_components.GameViewModel
import com.example.fonetesting.fragments.Complete_words
import kotlinx.android.synthetic.main.fragment_complete_words.*

class Game1 : AppCompatActivity(), Complete_words.SearchNewMovieListener {

    fun choose_option(option: String){

        var intento= tv_word.text.toString()

        tv_word.text=intento.substringBefore('_')+ option +intento.substringAfter('_')
    }

    override fun option1() {
        val numero2 = tv_aux.getText().toString().toInt()
        if(numero2==0){
            choose_option(opc1.text as String)
            tv_aux.text=(1).toString()
        }

    }


    override fun option2() {
        val numero2 = tv_aux.getText().toString().toInt()
        if(numero2==0) {
            choose_option(opc2.text as String)
            tv_aux.text=(1).toString()
        }
    }



    override fun nextWord() {
        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val numero1 = tv_cont.getText().toString()
        val aux=numero1.toInt()


        val te= btn_verification.getText().toString()
        opc1.text=listaopc[aux].toString()
        opc2.text=listaopc1[aux].toString()

        if(te.equals("Iniciar")){
            btn_verification.text="Verificar"
        }

        if(te.equals("Salir") ){
            tv_cont.text=(0).toString()
            viewModel.updateLevel(0)


            tv_word.text="Fin del juego"

            startActivity(Intent(this, MainActivity::class.java))

        }
        else{

            if(aux<lista.size-1){


                val palabra= tv_word.getText()

                var comprobando: Boolean=false

                comprobando= verification(palabra as String,aux)

                if(comprobando){
                    tv_cont.text=((aux+1)).toString()

                    viewModel.updateLevel(aux+1)
                    tv_word.text=listaaux[aux+1]
                    opc1.text=listaopc[aux+1].toString()
                    opc2.text=listaopc1[aux+1].toString()
                    tv_aux.text=(0).toString()
                    Toast.makeText(this, "¡Excelente! Vamos con la siguiente palabra", Toast.LENGTH_SHORT).show()

                }
                else{
                    tv_word.text=listaaux[aux]
                    tv_aux.text=(0).toString()
                    Toast.makeText(this, "¡Tu puedes!", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                tv_word.text="Fin del juego"
                viewModel.updateLevel(0)
                opc1.text=""
                opc2.text=""
                Toast.makeText(this, "¡Lo hiciste muy bien!", Toast.LENGTH_SHORT).show()
                btn_verification.text="Salir"

            }

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


    val lista = arrayOf("papa", "queso", "pequeño", "tarde", "grama", "tapadera", "broma", "nube", "abuela", "libro", "balon",
        "mesa", "telefono", "lampara", "television", "naranja", "maleta", "elefante", "viento", "galleta", "cable", "barco", "pepino")
    val listaaux= arrayOf("pa_a", "_ueso", "pe_ueño", "ta_de", "_rama", "ta_adera", "_roma", "_ube", "a_uela", "li_ro", "_alon",
        "me_a", "tele_ono", "lam_ara", "te_evision", "_aranja", "ma_eta", "ele_ante", "vien_o", "galle_a", "ca_le", "ba_co", "pe_ino")
    val listaopc=  arrayOf("p", "p", "p", "r", "g", "b", "t", "n", "b", "p","p", "s", "f", "p", "t", "m", "l", "t", "l", "t", "p", "r", "b")
    val listaopc1= arrayOf("q", "q", "q", "l", "q", "p", "b", "m", "p", "b","b", "z", "t", "b", "l", "n", "t", "f", "t", "p", "b", "l", "p")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1)





        val fDetalles= Complete_words()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().replace(R.id.container,fDetalles).commit()
    }
}
