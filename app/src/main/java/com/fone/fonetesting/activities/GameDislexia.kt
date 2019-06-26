package com.fone.fonetesting.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fone.fonetesting.R
import com.fone.fonetesting.fragments.Complete_words
import com.fone.fonetesting.fragments.Dislexia_game
import kotlinx.android.synthetic.main.fragment_complete_words.*
import kotlinx.android.synthetic.main.fragment_dislexia_game.*

class GameDislexia : AppCompatActivity(), Dislexia_game.SearchGameDislexiaListener {
    override fun nextWord() {
        val numero1 = tv_cont.getText().toString()
        val aux=numero1.toInt()

        val te= btn_verificar.getText().toString()
        /*opc1.text=listaopc[aux].toString()
        opc2.text=listaopc1[aux].toString()*/

        if(te.equals("Iniciar")){
            btn_verification.text="Verificar"
        }

        if(te.equals("Salir") ){
            tv_cont.text=(0).toString()



            tv_word.text="Fin del juego"
            /*opc1.text=""
            opc2.text=""*/

            startActivity(Intent(this, MainActivity::class.java))

        }
        else{

            if(aux<lista.size-1){


                val palabra= tv_word.getText()

                var comprobando: Boolean=false

                comprobando= verification(palabra as String,aux)

                if(comprobando){
                    tv_cont.text=((aux+1)).toString()

                    /*viewModel.updateLevel(aux+1)

                    lista[aux+1]

                    tv_word.text=listaaux[aux+1]
                    opc1.text=listaopc[aux+1].toString()
                    opc2.text=listaopc1[aux+1].toString()*/
                    tv_aux.text=(0).toString()
                    Toast.makeText(this, "¡Excelente! Vamos con la siguiente palabra", Toast.LENGTH_SHORT).show()

                }
                else{
                    //tv_word.text=listaaux[aux]
                    tv_aux.text=(0).toString()
                    Toast.makeText(this, "¡Tu puedes!", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                tv_word.text="Fin del juego"
                //viewModel.updateLevel(0)
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

    override fun option1() {
        val nopcion = tv_palabra1.getText().toString()
        tv_palabra_verificacion.text=nopcion
    }

    override fun option2() {
        val nopcion = tv_palabra1.getText().toString()
        tv_palabra_verificacion.text=nopcion
    }

    override fun option3() {
        val nopcion = tv_palabra1.getText().toString()
        tv_palabra_verificacion.text=nopcion
    }

    val lista = arrayOf("p", "q", "E", "b", "d", "3")
    val listaopc3= arrayOf("g", "q", "3", "b", "d", "3")
    val listaopc=  arrayOf("q", "p", "E", "p", "p", "F")
    val listaopc1= arrayOf("p", "g", "F", "d", "b", "E")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dislexia)

        val fDetalles= Dislexia_game()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().replace(R.id.container,fDetalles).commit()
    }
}
