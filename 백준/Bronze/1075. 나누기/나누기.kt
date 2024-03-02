fun main(){
    val n = readln().toInt()
    val f = readln().toInt()
    val hun = n / 100 * 100
    var ans = 0
    for(i in hun .. hun + 100){
        if(i % f == 0){
            ans = i % 100
            break
        }
    }
    if(ans < 10){
        println("0$ans")
    }else{
        println(ans)
    }
}