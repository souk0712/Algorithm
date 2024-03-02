import java.util.*

fun main() {
    val sb = StringBuilder()
    while (true) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        if (m == 0 && n == 0) break
        var total = 0
        val parent = IntArray(m) { i -> i }
        val pq = PriorityQueue<Edge>()
        for (i in 0 until n) {
            val (x, y, z) = readln().split(" ").map { it.toInt() }
            pq.offer(Edge(x, y, z))
            total += z
        }
        var sum = 0
        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (union(parent, cur.to, cur.from)) {
                sum += cur.cost
            }
        }
        sb.append(total - sum).append("\n")
    }
    println(sb)
}

fun union(parent: IntArray, a: Int, b: Int): Boolean {
    val aa = find(parent, a)
    val bb = find(parent, b)
    if (aa == bb) return false
    if (aa > bb) parent[aa] = bb
    else parent[bb] = aa
    return true
}

fun find(parent: IntArray, a: Int): Int {
    if (parent[a] == a) return a
    parent[a] = find(parent, parent[a])
    return parent[a]
}

data class Edge(val to: Int, val from: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int = cost.compareTo(other.cost)
}