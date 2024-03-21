fun main(){
    val list = readln().split(" ").map{it.toInt()}
    var ans = 0;
    for(i in 0 until list.size){
        ans += list[i]*list[i]
    }
    System.out.println(ans%10)
}