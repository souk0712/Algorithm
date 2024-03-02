fun main(){
    val input = readLine()!!
    print(input.toInt(16))
}

/**
 * kotlin 진법 변환 함수
 * toInt() : 문자->진수로 변환
 * "".toInt()   :2진수로 변환
 * "".toInt()   :10진수로 변환
 * "".toInt()   :16진수로 변환
 *
 * toString : 숫자->진수로 표현
 * 숫자.toString(2)   :2진수로 표현
 * 숫자.toString()    :10진수로 표현
 * 숫자.toString(16)  :16진수로 표현

 */