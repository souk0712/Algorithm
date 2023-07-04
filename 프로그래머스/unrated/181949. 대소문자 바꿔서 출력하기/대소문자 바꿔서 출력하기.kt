fun main(args: Array<String>) {
    val s1 = readLine()!!
    var ans = ""

    s1.forEach { c ->
        if (c in 'a'..'z') {
            ans += c.uppercaseChar()
        } else if (c in 'A'..'Z') {
            ans += c.lowercaseChar()
        }
    }

    println(ans);
}