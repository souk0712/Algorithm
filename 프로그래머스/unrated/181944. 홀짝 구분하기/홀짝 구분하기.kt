fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    val b = a % 2 == 0
    val ans = if(b) {
        "even"
    } else {
        "odd"
    }
    
    println("$a is $ans")
}