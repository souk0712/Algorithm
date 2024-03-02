fun main(){
    val sb = StringBuilder()
    while(true){
        var (first, second) = readln().split(" ").map{it.toInt()}
        if(first == 0 && second == 0) break
        if(first < second && second % first == 0){
            sb.append("factor").append("\n")
        }else if(first > second && first % second == 0){
            sb.append("multiple").append("\n")
        }else{
            sb.append("neither").append("\n")
        }
    }
    print(sb)
}