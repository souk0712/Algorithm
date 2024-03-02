import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    data class Node(val next: Int, val cost: Int) : Comparable<Node> {
        override fun compareTo(other: Node) = cost.compareTo(other.cost)
    }

    var st = StringTokenizer(readLine())
    val sb = StringBuilder()
    val V = st.nextToken().toInt()
    val E = st.nextToken().toInt()
    val list = Array<ArrayList<Node>>(V + 1) { arrayListOf() }
    val start = readLine().toInt()
    val dist = IntArray(V + 1) { Int.MAX_VALUE }
    for (i in 0 until E) {
        st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        list[u].add(Node(v, w))
    }

    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Node>()
        val visit = BooleanArray(V + 1)
        dist[start] = 0
        pq.offer(Node(start, dist[start]))

        while (!pq.isEmpty()) {
            val cur = pq.poll()
            if (visit[cur.next]) continue
            visit[cur.next] = true

            for (k in list[cur.next].indices) {
                val n = list[cur.next][k]
                if (!visit[n.next] && dist[n.next] > dist[cur.next] + n.cost) {
                    dist[n.next] = dist[cur.next] + n.cost
                    pq.offer(Node(n.next, dist[n.next]))
                }
            }
        }
    }

    dijkstra(start)

    for (i in 1 until dist.size) {
        sb.append(dist[i].takeIf { it != Int.MAX_VALUE } ?: "INF").append("\n")
    }
    println(sb)
}