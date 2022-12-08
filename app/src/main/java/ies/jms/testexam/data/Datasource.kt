package ies.jms.testexam.data


import ies.jms.testexam.R
import ies.jms.testexam.model.Pregunta

class Datasource {
    fun loadPreguntas(): List<Pregunta> {
        return listOf<Pregunta>(
            Pregunta(R.string.test1, true),
            Pregunta(R.string.test2, true),
            Pregunta(R.string.test3, true),
            Pregunta(R.string.test4, true),
            Pregunta(R.string.test5, true),
            Pregunta(R.string.test6, true),
            Pregunta(R.string.test7, true),
            Pregunta(R.string.test8, true),
            Pregunta(R.string.test9,false),
            Pregunta(R.string.test10,true),
            Pregunta(R.string.test11,true),
        )
    }
}