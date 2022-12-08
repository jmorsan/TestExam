package ies.jms.testexam.data


import ies.jms.testexam.R
import ies.jms.testexam.model.Pregunta

class Datasource {
    fun loadPreguntas(): List<Pregunta> {
        return listOf<Pregunta>(
            Pregunta(R.string.test1, true),
            Pregunta(R.string.test2, false),
            Pregunta(R.string.test3, true),
            Pregunta(R.string.test4, false),
            Pregunta(R.string.test5, true),
            Pregunta(R.string.test6, false),
            Pregunta(R.string.test7, true),
            Pregunta(R.string.test8, false),
            Pregunta(R.string.test9,true),
            Pregunta(R.string.test10,false),
        )
    }
}