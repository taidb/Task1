package com.example.task1

//Hàm trong Collection
fun FunOfCollection() {
    var list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var list1 = mutableListOf(1, 10, 3, 11, 5, 12, 7, 15, 9)
    var list2 = mutableListOf("Xin", "chào", "bạn")
    println("Số phần tử : ${list.size}")
    println("Phần tử chẵn : ${list.filter { it % 2 == 0 }}")
    println("Tổng các phần tử : ${list.sumOf { it }}")
    println(
        "Tổng các phần tử lẻ : ${
            list.filter { it % 2 != 0 }.reduce { acc, i -> acc + i }
        }"
    )// reduce gộp tất cả các phần tử thành 1 giá trị duy nhất lấy phân tử đầu tiên làm giá trị ban đầu
    println(list2.reduce { acc, item -> "$acc,$item"})
    println("Phần tử lớn nhất ${list.max()}")
    println("Phần tử nhỏ nhất ${list.min()}")
    println("Phần tử đầu tiên ${list.first()}")
    println("Phần tử cuối cùng ${list.last()}")
    println("Phần tử đầu tiên chẵn ${list.first { it % 2 == 0 }}")
    println("Có phàn tử nào lớn hơn 10 không : ${list.any { it > 10 }}")
    println("Tất cả phần từ lớn hơn 0 không :${list.all { it > 0 }}")
    println("Timf các phần tử đầu tiên lớn hơn 2 : ${list.find { it > 2 }}")
    println("Hợp 2 dãy số loại bỏ giá trị trùng nhau : ${list.union(list1)}")
    println("Giao 2 dayx số(lấy các giá trị trùng): ${list.intersect(list1)}")
    println("Có trong list không có trong list1 : ${list.subtract(list1)}")
    println("${list.iterator()}")
    var iterator = list.iterator()
    while (iterator.hasNext()) {
        println("${iterator.next()}")
    }
    println("sắp xếp dãy tăng dần :${list.sorted()}")
    println("sắp xếp dãy giảm dần :${list.sortedDescending()}")
    println("Kiểm tra xem phần tử có chứa trong dãy không :${list.contains(10)}")
    println("Kiểm tra xem dãy có rỗng không :${list.isEmpty()}")
    println("Kiểm tra xem dãy có rỗng không :${list.isNotEmpty()}")
    println("Chuyển đổi dữ liệu của list: ${list.map { it * 2 }}")
    println("Đếm số phần tử lớn hơn 2 : ${list.count { it > 2 }}")
    println("Lấy 3 phần tử đầu tiên : ${list.take(3)}")
    println("Lấy 3 phần tử cuối cùng : ${list.takeLast(3)}")
    println("Loại bỏ giá trị trùng nhau : ${list.distinct()}")
    println("hàm đảo ngược : ${list.reversed()}")
    println(
        "fold hợp các phần tử thành 1 giá trị duy nhâts nó có thể đưa giá trị mình chọn la giá trị khởi đầu : ${
            list.fold(
                0
            ) { acc, i -> acc + i }
        }"
    )
    println(list2.fold("Chào bạn"){ acc, item -> "$acc,$item"})
    println("lấy 1 số bất kì : ${list.random()}")
    println("Bỏ qua 2 phần tử đầu tiên : ${list.drop(2)}")
    println("Tính giá tị trung bih : ${list.average()}")
    println("Nhóm các phần từ cùng 1 nhóm chỉ định trong {}: ${list.groupBy { it > 5 }}")
    println(
        "Chuyển 1 danh sách số thành chuỗi :${
            list.joinToString(
                separator = "-",
                prefix = "<",
                postfix = ">"
            )
        }"
    )

}

//List
fun syntaxList() {
    var list = listOf(2, 3, 4)
    var number = mutableListOf(1, 2, 3)
    number.add(4)
    number.remove(2)
    number.removeAt(1)

    println(number)

}

//Map
fun syntaxMap() {
    var map = mutableMapOf<String, Int>()
    var map1 = mapOf("Iphone" to 1, "Sumsung" to 2, "Oppo" to 3)
    for ((key, value) in map1) {
        println("$key : $value")

    }
    println("Lấy giá trị của Iphone : ${map1["Iphone"]}")
    println("map.keys : ${map1.keys}")
    println("map.values : ${map1.values}")
    println("map.entries : ${map1.entries}")
    println("${map.containsKey("Iphone")}")
    println("${map.containsValue(1)}")
}

//Set
fun syntaxSet() {
    var set= mutableSetOf(1,2,3,4,5,6,1,5,2)
    var set1= setOf(1,2,3,4,5)
    set.add(6)
    set.remove(2)
    println(set)

}

fun main() {
    FunOfCollection()
    syntaxList()
    syntaxSet()
    syntaxMap()

}