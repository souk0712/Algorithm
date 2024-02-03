import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = Array<ArrayList<Int>>(n + 1) { arrayListOf() }
    val d = IntArray(n + 1) { 0 }
    val sb = StringBuilder()
    for (i in 0 until m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        list[a].add(b)
        d[b]++
    }
    val pq = PriorityQueue<IntArray>(kotlin.Comparator<IntArray> { o1, o2 ->
        val c = o1[1] - o2[1]
        if (c == 0) {
            return@Comparator o1[0] - o2[0]
        } else {
            return@Comparator c
        }
    })
    val visit = BooleanArray(n + 1)
    for (i in 1 until d.size) {
        if (d[i] == 0) {
            pq.offer(intArrayOf(i, 0))
        }
    }
    while (!pq.isEmpty()) {
        val cur = pq.poll()
        if (visit[cur[0]]) continue
        visit[cur[0]] = true

        if (cur[1] == 0) {
            sb.append(cur[0]).append(" ")
        }
        for (k in 0 until list[cur[0]].size) {
            val next = list[cur[0]][k]
            d[next]--
            pq.offer(intArrayOf(next, d[next]))
        }
    }
    println(sb)
}