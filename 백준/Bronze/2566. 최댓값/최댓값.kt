fun main(){
    var max = 0
    var x = 1;
    var y = 1;
    for(i in 0 until 9){
        val arr = readln().split(" ").map{it.toInt()}
        for(j in 0 until arr.size){
            if(max < arr[j]){
                max = arr[j]
                x = i+1
                y = j+1
            }
        }
    }
    println(max)
    print("$x $y")
}