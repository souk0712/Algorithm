fun main(args: Array<String>) {
    val score = ArrayList<Int>()
    var sum  = 0
    for (i in 0..4) {
        score.add(Integer.parseInt(readLine()))
        if(score[i]<40){
            score[i] = 40
        }
        sum += score[i]
    }
    print(sum/5)
}
