fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val cranes = readLine().split(" ").map(String::toInt).sortedDescending()
    val m = readLine().toInt()
    val boxes = readLine().split(" ").map(String::toInt).sortedDescending().toMutableList()

    if (boxes[0] > cranes[0]) {
        println(-1)
    } else {
        var sec = 0

        while (boxes.isNotEmpty()) {
            var w = 0
            var c = 0

            while (c < n && w < boxes.size) {
                if (cranes[c] >= boxes[w]) {
                    boxes.removeAt(w)
                    c++
                } else w++
            }
            sec++
        }

        println(sec)
    }
}