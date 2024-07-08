class Solution {
    // fees: 기본 시간, 기본 요금, 단위 시간, 단위 요금
    // records: 시각, 차량 번호, 출(IN)/차(OUT)
    
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val map = HashMap<String, ArrayDeque<Car>>()
        val sum = HashMap<String, Int>()

        records.forEach { record ->
            val info = record.split(" ")
            val (hour, min) = info[0].split(":").map { it.toInt() }
            val time = hourToMinute(hour, min)
            val carNum = info[1]
            val isIn = info[2] == "IN"

            if (map.containsKey(carNum)) {
                map[carNum]?.let {
                    it.add(Car(carNum, time, isIn))
                    map.put(carNum, it)
                }
            } else {
                val dq = ArrayDeque<Car>()
                dq.add(Car(carNum, time, isIn))
                map[carNum] = dq
            }
        }
        map.forEach { (key, value) ->
            while (!value.isEmpty()) {
                val first = value.removeFirst()
                if (value.isEmpty()) {
                    val diff = hourToMinute(23, 59) - first.time
                    sum[key] = sum.getOrDefault(key, 0) + diff
                } else {
                    val second = value.removeFirst()
                    val diff = second.time - first.time
                    sum[key] = sum.getOrDefault(key, 0) + diff
                }
            }
        }
        println(sum.toList())

        return sum.toList().sortedWith(compareBy { it.first })
            .map { if (it.second <= fees[0]) fees[1] else fees[1] + (Math.ceil(((it.second.toDouble() - fees[0].toDouble()) / fees[2]).toDouble()) * fees[3]).toInt() }
            .toIntArray()
    }
    
    // hour to minute
    fun hourToMinute(hour:Int, min:Int):Int{
        return hour * 60 + min
    }

    data class Car(val num:String, val time:Int, val isIn:Boolean)
}