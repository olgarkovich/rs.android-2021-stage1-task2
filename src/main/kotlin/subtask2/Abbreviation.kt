package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val upperA = a.toUpperCase()
        var k = 0
        for (i in 0..upperA.lastIndex) {
            if (upperA[i] == b[k]) {
                k++
            }
            if (k == b.length) {
                return "YES"
            }
        }

        return "NO"
    }
}
