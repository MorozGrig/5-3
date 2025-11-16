import kotlin.math.sqrt
import kotlin.math.pow
fun main(){
    println("Введите количество точек (больше 2): ")
    val n = readLine()?.toIntOrNull()
    if (n == null || n<=2){
        println("Введите конкретное количество точек(Больше 2!)")
        return
    }
    val points = mutableListOf<Point>()
    for (i in 1..n){
        println("Введите кординаты точки $i через пробел")
        val input = readLine()
        val put = input?.trim()?.split("\\s+".toRegex())

        if (put == null || put.size!=2){
            println("Введите значение коректно.")
            return
        }
        val x = put[0].toDoubleOrNull()
        val  y = put[1].toDoubleOrNull()
        if (x == null || y == null){
            println("Введите значение коректно.")
            return
        }
        points.add(Point(x,y))
    }
    var minDist = Double.MAX_VALUE
    var maxDist=0.0
    for (i in 0 until points.size-1){
        for (j in i + 1 until points.size){
            val dist = sqrt((points[i].x - points[j].x).pow(2)+(points[i].y - points[j].y).pow(2))
            if (dist < minDist)
                minDist=dist
            if (dist > maxDist)
                maxDist=dist
        }
    }
    println("Минимальная дистанция: $minDist")
    println("Максимальная дистанция: $maxDist")
}