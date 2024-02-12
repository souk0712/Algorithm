import java.util.*

const val INF = 200000 * 1000

fun main() {

    data class Node(val next: Int, val cost: Int) : Comparable<Node> {
        override fun compareTo(other: Node) = cost.compareTo(other.cost)
    }
    val (n, e) = readln().split(" ").map { it.toInt() }
    val list = Array(n + 1) { ArrayList<Node>() }
    for (i in 0 until e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        list[a].add(Node(b, c))
        list[b].add(Node(a, c))
    }
    val (need1, need2) = readln().split(" ").map { it.toInt() }

    fun dijkstra(start: Int, end: Int): Int {
        val dist = IntArray(n + 1) { INF }
        val pq = PriorityQueue<Node>()
        val visit = BooleanArray(n + 1)
        dist[start] = 0
        pq.offer(Node(start, dist[start]))

        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (visit[cur.next]) continue
            visit[cur.next] = true

            for (k in list[cur.next].indices) {
                val mn = list[cur.next][k]
                if (visit[mn.next]) continue
                if (dist[mn.next] > dist[cur.next] + mn.cost) {
                    dist[mn.next] = dist[cur.next] + mn.cost
                    pq.offer(Node(mn.next, dist[mn.next]))
                }
            }
        }
        return dist[end]
    }

    var ans1 = 0
    ans1 += dijkstra(1, need1)
    ans1 += dijkstra(need1, need2)
    ans1 += dijkstra(need2, n)

    var ans2 = 0
    ans2 += dijkstra(1, need2)
    ans2 += dijkstra(need2, need1)
    ans2 += dijkstra(need1, n)

    println(ans1.coerceAtMost(ans2).takeIf { it < INF } ?: -1)
}