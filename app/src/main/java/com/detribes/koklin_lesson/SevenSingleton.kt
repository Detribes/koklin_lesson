package com.detribes.koklin_lesson

class SevenSingleton private constructor(){
    companion object{
        @Volatile
        private var instance: SevenSingleton? = null
        fun getInstance(): SevenSingleton {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = SevenSingleton()
                    }
                }
            }
            return instance!!
        }
    }
}