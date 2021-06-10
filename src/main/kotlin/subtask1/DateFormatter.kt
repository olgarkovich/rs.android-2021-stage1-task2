package subtask1

import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        return if (validate(day, month, year)) {
            val date = Date(year.toInt(), month.toInt() - 1, day.toInt())
            val dateFormat = SimpleDateFormat("dd MMMM, ", myDateFormatSymbols)
            dateFormat.format(date) + getWeekDay(
                day.toInt(),
                getMonthCode(month.toInt()), getYearCode(year.toInt())
            )

        } else {
            "Такого дня не существует"
        }
    }

    private fun validate(day: String, month: String, year: String): Boolean {
        if (month.toInt() - 1 > 11) {
            return false
        }
        when (month.toInt() - 1) {
            0, 2, 4, 6, 7, 9, 11 -> {
                if (day.toInt() > 31) {
                    return false
                }
            }
            1 -> {
                if (year.toInt() == 0 && day.toInt() > 29) {
                    return false
                } else if (day.toInt() > 28) {
                    return false
                }
            }
            3, 5, 8, 10 -> {
                if (day.toInt() > 30) {
                    return false
                }
            }
        }

        return true
    }

    private val myDateFormatSymbols: DateFormatSymbols = object : DateFormatSymbols() {
        override fun getMonths(): Array<String> {
            return arrayOf(
                "января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"
            )
        }
    }

    private fun getMonthCode(month: Int): Int {
        when (month) {
            1, 10 -> return 1
            2, 3, 11 -> return 4
            4, 7 -> return 0
            5 -> return 2
            6 -> return 5
            8 -> return 3
            9, 12 -> return 6
        }

        return -1
    }

    private fun getYearCode(year: Int): Int {
        var coeff = 6
        if (year < 2000) {
            coeff = 0
        }

        return (coeff + year % 100 + year % 100 / 4) % 7
    }

    private fun getWeekDay(day: Int, monthCode: Int, yearCode: Int): String {
        val weekArray = arrayListOf<String>(
            "суббота",
            "воскресенье",
            "понедельник",
            "вторник",
            "среда",
            "четверг",
            "пятница"
        )
        val weekDayCode = (day + monthCode + yearCode) % 7
        return weekArray[weekDayCode]
    }

}
