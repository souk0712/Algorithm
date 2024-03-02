import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val result = BigInteger(token.nextToken()).add(BigInteger(token.nextToken()))
    print("$result")
    br.close()
}
/**
 * 자료형     크기           값의 범위
 * Long     8bytes      -2^63..2^63-1
 * Int      4bytes      -2,147,483,648..2,147,483,648
 * Short    2bytes      -32,768..32,767
 * Byte     1bytes      -128..127
 * ULong    8bytes      0..2^64-1
 * UInt     4bytes      0..2^32-1
 * UShort   2bytes      0..2^16-1
 * Byte     1bytes      0..2^8-1
 *
 * 자료형     크기           값의 범위
 * Double   8bytes      1.79E-308..1.79E+308
 * Float    4bytes      3.4E-38..3.4E+38
 *
 * BigInteger은 문자열 형태로 이루어져 있어 숫자의 범위가 무한하기에 어떠한 숫자이든지 담을 수 있습니다.(자바)
 * 덧셈       : .add
 * 뺄셈       : .subtract
 * 곱하기     : .multiply
 * 나누기     : .divide
 * 나머지     : .remainder
 */