fun main() {
    while (true) {
        val input = Integer.parseInt(readLine())
        if (input == 0) break
        var sum = 0
        val part = ArrayList<Int>()
        var nNum = input
        var i = 0
        while (nNum > 0) {
            part.add(nNum % 10)
            nNum /= 10

            sum += when (part[i]) {
                1 -> 2
                0 -> 4
                else -> 3
            }
            i++
        }
        sum = sum + 2 + part.size - 1
        println(sum)
    }
}