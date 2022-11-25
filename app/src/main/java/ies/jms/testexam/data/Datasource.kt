package ies.jms.testexam.data


import ies.jms.testexam.R
import ies.jms.testexam.model.Test

class Datasource {
    fun loadPreguntas(): List<Test> {
        return listOf<Test>(
            Test(R.string.test1, R.drawable.image1),
            Test(R.string.test2, R.drawable.image2),
            Test(R.string.test3, R.drawable.image3),
            Test(R.string.test4, R.drawable.image4),
            Test(R.string.test5, R.drawable.image5),
            Test(R.string.test6, R.drawable.image6),
            Test(R.string.test7, R.drawable.image7),
            Test(R.string.test8, R.drawable.image8),
            Test(R.string.test9, R.drawable.image9),
            Test(R.string.test10, R.drawable.image10)

        )
    }
}