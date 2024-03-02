fun main(){
    val input = readLine()
    val c = input!!.first()
    print(c.code)
}

/**
 * kotlin에서 아스키코드는 char을 변환한다. toInt()는 deprecated. ->code로 변경.
 */