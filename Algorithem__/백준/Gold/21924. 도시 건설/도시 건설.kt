import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { i -> i }

    fun find(a: Int): Int {
        if (parent[a] == a) return a
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

    var total :Long= 0
    val pq = PriorityQueue<IntArray>(Comparator { o1, o2 -> o1[2].compareTo(o2[2]) })
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        total += c
        pq.offer(intArrayOf(a, b, c))
    }

    var sum :Long = 0
    while (!pq.isEmpty()) {
        val cur = pq.poll()

        if (union(cur[0], cur[1])) {
            sum += cur[2]
        }
    }

    val compare = find(1)
    for (i in 1..n) {
        if (compare != find(i)) {
            print(-1)
            return@with
        }
    }
    print(total - sum)
}