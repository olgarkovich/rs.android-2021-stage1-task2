package subtask3

import java.time.LocalDate
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            String::class -> {
                return stringBlock(blockA)
            }
            Int::class -> {
                return intBlock(blockA)
            }
            LocalDate::class -> {
                return dateBlock(blockA)
            }
        }

        return false
    }

    private fun stringBlock(blockA: Array<*>): String {
        var resultString = ""
        for (item in blockA) {
            if (item is String) {
                resultString += item
            }
        }
        return resultString
    }

    private fun intBlock(blockA: Array<*>): Int {
        var result = 0
        for (item in blockA) {
            if (item is Int) {
                result += item
            }
        }
        return result
    }

    private fun dateBlock(blockA: Array<*>): String {
        var result = ""
        var currentYear = 0
        for (item in blockA) {
            if (item is LocalDate) {
                if (currentYear < item.year) {
                    result = "${item.dayOfMonth}.${item.monthValue}.${item.year}"
                    currentYear = item.year
                }
            }
        }
        return result
    }
}
