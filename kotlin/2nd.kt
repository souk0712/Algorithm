fun main(args: Array<String>){
    print(when(Integer.parseInt(readLine())){
        in 90..100 ->"A"
        in 80..90 ->"B"
        in 70..80 ->"C"
        in 60..70->"D"
        else ->"F"
    })
}