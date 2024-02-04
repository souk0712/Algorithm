import java.util.*

fun main() {
    data class Edge(val to: Int, val from: Int, val cost: Int) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int = cost.compareTo(other.cost)
    }
    val (n, m) = readln().split(" ").map { it.toInt() }
    val gender = readln().split(" ")
    val parent = IntArray(n + 1) { i -> i }
    val pq = PriorityQueue<Edge>()
    repeat(m) {
        val (u, v, d) = readln().split(" ").map { it.toInt() }
        if ((gender[u - 1] == "M" && gender[v - 1] == "W") || gender[u - 1] == "W" && gender[v - 1] == "M")
            pq.offer(Edge(u, v, d))
    }

    fun find(a: Int): Int {
        if (parent[a] == a) return a;
        parent[a] = find(parent[a])
        return parent[a]
    }

    fun union(a: Int, b: Int): Boolean {
        val aa = find(a)
        val bb = find(b)
        if (aa == bb) return false
        if (aa > bb) parent[aa] = bb
        else parent[bb] = aa
        return true
    }

    var sum = 0
    while (!pq.isEmpty()) {
        val cur = pq.poll()
        if (union(cur.to, cur.from)) {
            sum += cur.cost
        }
    }

    val compare = find(1)
    for (i in 1..n) {
        if (compare != find(parent[i])) {
            print(-1)
            return
        }
    }
    print(sum)
}