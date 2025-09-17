package com.example.task1.task1

import java.util.Hashtable

//Hàm trong Collection
fun demonStrateCollectionFunctions() {
    val list = mutableListOf(1, 2, 3, 9, 4, 5, 6, 7, 8, 9)
    val list2 = mutableListOf("Apple", "banana", "Orange", "Goyave", "Pear")
    val list3 = mutableListOf(1, 10, 3, 11, 5, 12, 7, 15, 9)
    val fruits = listOf("apple", "banana", "Orange", "avocado")

    // Các hàm cơ bản
    println("Kiểm tra danh sách không rỗng: ${list.isNotEmpty()}")
    println("Kiểm tra danh sách rỗng: ${list.isEmpty()}")
    println("Số phần tử: ${list.size}")
    println("Phần tử đầu tiên: ${list.first()}")
    println("Phần tử cuối cùng: ${list.last()}")
    println("Phần tử tại vị trí 2: ${list.elementAt(2)}")
    println("Chỉ số đầu tiên của phần tử 9: ${list.indexOf(9)}")
    println("Chỉ số cuối cùng của phần tử 9: ${list.lastIndexOf(9)}")
    println("Kiểm tra phần tử có trong danh sách: ${list.contains(10)}")

    // Các hàm lọc và biến đổi
    println("Lọc phần tử chẵn: ${list.filter { it % 2 == 0 }}")
    println("Lọc phần tử lẻ: ${list.filterNot { it % 2 == 0 }}")
    println("Bỏ qua 2 phần tử đầu tiên: ${list.drop(2)}")
    println("Lấy 3 phần tử đầu tiên: ${list.take(3)}")
    println("Lấy 3 phần tử cuối cùng: ${list.takeLast(3)}")
    println("Lấy theo chỉ số: ${list.slice(1..5)}")
    println("Loại bỏ giá trị trùng nhau: ${list.distinct()}")
    println("Chuyển đổi dữ liệu (nhân đôi): ${list.map { it * 2 }}")
    println("Chuyển đổi dữ liệu với chỉ mục: ${list.mapIndexed { index, value -> index * value }}")
    println("Làm phẳng danh sách: ${list.flatMap { listOf(it, it * 10) }}")
    println("Nhóm các phần tử: ${list.groupBy { it > 5 }}")

    // Các hàm sắp xếp
    println("Sắp xếp dãy tăng dần: ${list.sorted()}")
    println("Sắp xếp dãy giảm dần: ${list.sortedDescending()}")
    println("Sắp xếp theo tiêu chí: ${list2.sortedBy { it.length }}")
    println("Sắp xếp ngược tiêu chí: ${list2.sortedByDescending { it.length }}")
    println("Đảo ngược danh sách: ${list.reversed()}")
    println("Xáo trộn danh sách: ${list.shuffled()}")

    // Các hàm tính toán
    println("Tổng các phần tử: ${list.sum()}")
    println("Tổng các phần tử với transform: ${list.sumOf { it * 2 }}")
    println("Phần tử lớn nhất: ${list.maxOrNull()}")
    println("Phần tử nhỏ nhất: ${list.minOrNull()}")
    println("Giá trị trung bình: ${list.average()}")
    println("Đếm số phần tử lớn hơn 2: ${list.count { it > 2 }}")

    // Các hàm kiểm tra điều kiện
    println("Tất cả phần tử lớn hơn 0: ${list.all { it > 0 }}")
    println("Có phần tử nào lớn hơn 10: ${list.any { it > 10 }}")
    println("Không có phần tử nào lớn hơn 20: ${list.none { it > 20 }}")

    // Các hàm gộp
    println("Fold (tính tổng với giá trị khởi đầu): ${list.fold(0) { acc, i -> acc + i }}")
    println("Reduce (gộp các phần tử): ${list.reduce { acc, i -> acc + i }}")
    println("Chuyển danh sách thành chuỗi: ${list.joinToString("-", "<", ">")}")

    // Các hàm tập hợp
    println("Giao 2 dãy số: ${list.intersect(list3)}")
    println("Hợp 2 dãy số: ${list.union(list3)}")
    println("Hiệu 2 dãy số: ${list.subtract(list3)}")
    println("Chia list thành các list con: ${list.chunked(3)}")
    println("Chia list thành các cặp: ${list.windowed(2)}")

    // Xử lý chuỗi
    println("Lọc các từ bắt đầu bằng 'a': ${fruits.filter { it.startsWith("a") }}")
    println("Lọc các từ kết thúc bằng 'n': ${list2.filter { it.endsWith("n") }}")

    //gọi chuỗi
    val listIterator = list
        .filter { it > 3 }
        .map { it * 2 }
        .toList()
    println("Sử dụng sequence để xử lý lazy: $listIterator")

    // Gọi chuỗi tương tự như ví dụ cuối
    val processedList = list
        .filter { it > 3 }
        .map { it * 2 }
        .distinct()
        .sortedDescending()
        .take(5)
        .toList()

    println("Kết quả xử lý chuỗi: $processedList")

    // Một ví dụ khác với chuỗi xử lý phức tạp hơn
    val complexProcessing = fruits
        .filter { it.length > 4 }
        .map { it.uppercase() }
        .sorted()
        .joinToString(" | ")

    println("Xử lý chuỗi phức tạp: $complexProcessing")
}

//List
fun syntaxList() {

    // Immutable list (không thể thay đổi)
    val immutableList = listOf(2, 3, 4)
    println("Immutable list: $immutableList")

    // Mutable list (có thể thay đổi)
    val mutableList = mutableListOf(1, 2, 3)
    println("Mutable list ban đầu: $mutableList")

    // Thêm phần tử
    mutableList.add(4)
    mutableList.add(1, 10) // Thêm tại vị trí chỉ định
    mutableList.addAll(listOf(5, 6))
    println("Sau khi thêm: $mutableList")

    // Sửa phần tử
    mutableList[0] = 100
    println("Sau khi sửa: $mutableList")

    // Xóa phần tử
    mutableList.remove(3)
    mutableList.removeAt(1)
    mutableList.removeAll(listOf(5, 6))
    println("Sau khi xóa: $mutableList")

    // Xóa tất cả
    mutableList.clear()
    println("Sau khi clear: $mutableList")
}

//Map
fun syntaxMap() {
    // Immutable map
    val immutableMap = mapOf("Iphone" to 1, "Samsung" to 2, "Oppo" to 3)
    println("Immutable map: $immutableMap")

    // Mutable map
    val mutableMap = mutableMapOf<String, Int>()
    mutableMap["Iphone"] = 1
    mutableMap["Samsung"] = 2
    mutableMap["Oppo"] = 3
    println("Mutable map ban đầu: $mutableMap")

    // Thêm phần tử
    mutableMap["Xiaomi"] = 4
    mutableMap.put("Nokia", 5)
    mutableMap.putAll(mapOf("Huawei" to 6, "LG" to 7))
    println("Sau khi thêm: $mutableMap")

    // Sửa phần tử
    mutableMap["Iphone"] = 10
    mutableMap.replace("Samsung", 20)
    println("Sau khi sửa: $mutableMap")

    // Xóa phần tử
    mutableMap.remove("Oppo")
    mutableMap.remove("Xiaomi", 4) // Chỉ xóa nếu value khớp
    println("Sau khi xóa: $mutableMap")

    // Truy cập phần tử
    println("Lấy giá trị của Iphone: ${mutableMap["Iphone"]}")
    println("Lấy giá trị hoặc mặc định: ${mutableMap.getOrDefault("Motorola", 0)}")

    // Lấy keys, values, entries
    println("Keys: ${mutableMap.keys}")
    println("Values: ${mutableMap.values}")
    println("Entries: ${mutableMap.entries}")

    // Kiểm tra
    println("Có chứa key Iphone: ${mutableMap.containsKey("Iphone")}")
    println("Có chứa value 20: ${mutableMap.containsValue(20)}")

    // Duyệt map
    println("Duyệt map:")
    for ((key, value) in mutableMap) {
        println("$key: $value")
    }

    // Kiểm tra
    println("\n--- Kiểm tra ---")
    println("Có chứa key Iphone: ${mutableMap.containsKey("Iphone")}")
    println("Có chứa value 20: ${mutableMap.containsValue(20)}")
    println("Map trống: ${mutableMap.isEmpty()}")
    println("Map không trống: ${mutableMap.isNotEmpty()}")

    // Filter map
    println("Filter map: ${mutableMap.filter { it.key.length > 5 }}")
    println("Filter values: ${mutableMap.filterValues { it > 5 }}")
    println("Filter keys: ${mutableMap.filterKeys { it.startsWith("S") }}")

    // Map operations
    println("Map keys: ${mutableMap.mapKeys { it.key.uppercase() }}")
    println("Map values: ${mutableMap.mapValues { it.value * 2 }}")

    // Các hàm hữu ích khác
    println("Số lượng phần tử: ${mutableMap.count()}")
    println("Tổng các values: ${mutableMap.values.sum()}")
    println("Key có value lớn nhất: ${mutableMap.maxByOrNull { it.value }}")
    println("Key có value nhỏ nhất: ${mutableMap.minByOrNull { it.value }}")
}


//Set
fun syntaxSet() {
    //Các loại hàm Set
    val hashSet = hashSetOf(1, 2, 3, 4, 5) // Không đảm bảo thứ tự
    val linkedSet = linkedSetOf(1, 2, 3, 4, 5) // Giữ thứ tự chèn
    val sortedSet = sortedSetOf(5, 3, 1, 4, 2) // Sắp xếp tự động

    // Immutable set
    val immutableSet = setOf(1, 2, 3, 4, 5, 1, 2, 3)
    println("Immutable set: $immutableSet")

    // Mutable set
    val mutableSet = mutableSetOf(1, 2, 3, 4, 5, 6, 1, 5, 2)
    println("Mutable set ban đầu: $mutableSet")

    // Thêm phần tử
    mutableSet.add(6)
    mutableSet.add(7)
    mutableSet.addAll(setOf(8, 9))
    println("Sau khi thêm: $mutableSet")

    // Xóa phần tử
    mutableSet.remove(2)
    mutableSet.removeAll(setOf(5, 6))
    println("Sau khi xóa: $mutableSet")

    val otherSet = setOf(3, 4, 10, 11)
    println("Set hiện tại: $mutableSet")
    println("Giao của 2 set: ${mutableSet.intersect(otherSet)}")
    println("Hợp của 2 set: ${mutableSet.union(otherSet)}")
    println("Hiệu của 2 set: ${mutableSet.subtract(otherSet)}")

    // Kiểm tra tập hợp con
    println("Có phải tập hợp con: ${mutableSet.containsAll(setOf(3, 4))}")

    // Các hàm hữu ích khác
    println("Có phần tử chung: ${mutableSet.any { it in otherSet }}")
    println("Tìm phần tử: ${mutableSet.find { it > 3 }}")
    println("Lọc phần tử: ${mutableSet.filter { it % 2 == 0 }}")
    println("Chuyển đổi phần tử: ${mutableSet.map { it * 2 }}")
    println("Tổng các phần tử: ${mutableSet.sum()}")
    println("Phần tử lớn nhất: ${mutableSet.maxOrNull()}")
    println("Phần tử nhỏ nhất: ${mutableSet.minOrNull()}")

}

fun syntaxHash() {
    // HashMap (có thể chứa null, không đảm bảo thứ tự)
    val hashMap = HashMap<String, Int?>()
    hashMap["one"] = 1
    hashMap["two"] = 2
    hashMap["nullValue"] = null
    println("HashMap: $hashMap")

    // HashSet (không chứa phần tử trùng lặp)
    val hashSet = HashSet<String>()
    hashSet.add("Apple")
    hashSet.add("Banana")
    hashSet.add("Apple") // Phần tử trùng sẽ bị bỏ qua
    println("HashSet: $hashSet")

    // Hashtable (không thể chứa key/value null, thread-safe)
    val hashTable = Hashtable<Int, String>()
    hashTable[1] = "Tài"
    hashTable[2] = "Bình"
    hashTable[3] = "Duy"
    println("Hashtable: $hashTable")
}

fun main() {
    demonStrateCollectionFunctions()
    syntaxList()
    syntaxSet()
    syntaxMap()
    syntaxHash()

}