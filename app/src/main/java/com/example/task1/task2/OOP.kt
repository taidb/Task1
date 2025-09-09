package com.example.task1.task2

fun main() {

    //School
    val school = School("Đại học GTVT", "Cầu giấy")
    school.showInfo()
    println("Có phải là đại học: ${school.isUniversity()}")
    println()

    //Object
    ClassRoomSchool.name = "Đại học Bách Khoa"
    ClassRoomSchool.address = "Đại Cồ Việt"
    ClassRoomSchool.showInfo()

    //Constructor (Primary & Secondary)
    var students = listOf<Student>(
        Student("Tiến", 20, "Nam", 1, "Đại học Bách Khoa Hà Nội"),
        Student("Bình", 25, "Nam", 2),
        Student("Hà", 26, "Nữ", 3),
        Student("Khôi", 22, "Nam", 4, "Đại học Hà Nội"),
        Student("Nội", 20, "Nữ", 5, "Đại học Bách Khoa Hà Nội")
    )

    //Inheritance (kế thừa)
    var teacher = Teacher("Tiến", 20, "Nam", "Toán")
    println(teacher.info())
    println(teacher.showInfoName())


    //Overload
    println(sum(1, 2))
    println(sum(1.0, 2.0))
    println(sum(1, 2, 3))

    //abstract class
    Staff().work()
    Staff().info()

    //Interface
    val checkBox = CheckBox()
    checkBox.click()
    checkBox.showMess()

    val button = OnButton()
    button.click()
    button.showMess()
    button.onClose()

    //Data class
    val student1 = Student2("Tài", 23, "Nam", 1)
    val student2 = Student2("Tài", 23, "Nam", 1)
    println("Kiểm tra xem student1 có bằng student2 không : ${student1 == student2}")
    println(student1.toString())
    println(student1.hashCode())
    println(student2.hashCode())

    //Singleton
    val mySingleton = MySingleton
    mySingleton.count++
    mySingleton.printCount()

    //companion object
    MyClass.name = "Đặng Bá Tài"
    MyClass.printName()

    //Enum class
    var today = EnumDemo.Mon
    when (today) {
        EnumDemo.Mon -> println("Hôm nay là thứ 2")
        EnumDemo.Tue -> println("Hôm nay là thứ 3")
        EnumDemo.Wed -> println("Hôm nay là thứ 4")
        EnumDemo.Thu -> println("Hôm nay là thứ 5")
        EnumDemo.Fri -> println("Hôm nay là thứ 6")
        EnumDemo.Sat -> println("Hôm nay là thứ 7")
        EnumDemo.Sun -> println("Hôm nay là chủ nhật")
    }

    //sealed class
    var result: Result<String> = Result.Success("Thành công")
    val message = when (result) {
        is Result.Success<*> -> "Success:${result.data}"
        is Result.Error -> "Error :${result.error}"
        is Result.Loading -> "Loading..."
    }
    println(message)

    //NestedClass
    println(OuterClass.NestedClass().description)
    val nested = OuterClass.NestedClass()
    println(nested.printDescription())

    //InnerClass
    println(OuterClass().InnerClass().printDescription())
}

//class
class School(val name: String, val address: String) {
    fun showInfo() {
        println("Tên trường: $name, Địa chỉ: $address")
    }
    fun isUniversity(): Boolean = name.contains("đại học", ignoreCase = true)
}

//object
object ClassRoomSchool {
    var name: String = ""
    var address: String = ""
    fun showInfo() {
        println("Tên trường: $name, Địa chỉ: $address")
    }
}

//Constructor (Primary & Secondary)
class Student(var name: String, var age: Int, var gender: String, val id: Int) {
    init {
        println("Họ tên: $name, Tuổi: $age, Giới tính: $gender, Mã sinh viên: $id")
    }

    var school: String = ""

    constructor(name: String, age: Int, gender: String, id: Int, school: String) : this(
        name, age, gender, id
    ) {
        this.school = school
    }

}

//Inheritance (kế thừa)
open class Person(val name: String, val age: Int, val gender: String) {
    open fun info(): String {
        return "Name: $name, Age: $age, Gender: $gender"
    }

    open fun showInfoName() {
        println("Tên là $name")
    }
    open fun showSubject(subject: String)=
        println("Môn học là $subject")

}

class Teacher(name: String, age: Int, gender: String, val subject: String) :
    Person(name, age, gender) {
    //ghi đè 1 phần(override)
    override fun info(): String {
        return super.info() + ", Subject: $subject"
    }

    //đi đè hoàn toàn (override)
    override fun showInfoName() {
        println("Tên là $name và dạy môn $subject")
    }
    override fun showSubject(subject: String) {
        super.showSubject(subject)
    }
}

// hàm Overload
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum(a: Double, b: Double): Double {
    return a + b
}

fun sum(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

//abstract class
abstract class Worker {
    abstract fun work()
    fun info() {
        println("Thông tin nhân viên")
    }
}

class Staff : Worker() {
    override fun work() {
        println("Vị trí coong việc là nhân viên")
    }
}


//interface : định nghĩa các hành vi bắt buộc lopws con phải thực thi ( như 1 khuôn mẫu ) có thể kế thừa nhiều interface
interface InterfaceDemo {
    fun click() {}
    fun showMess() {
        println("Hiện thị thông tin trường học")
    }
}

interface InterfaceDemo2 {
    fun onClose()
}


class OnButton : InterfaceDemo, InterfaceDemo2 {
    override fun click() {
        super.click()
        println("Bạn đã click vào Button")
    }

    override fun onClose() {
        println("Bạn đã click vào nút đóng")

    }
    override fun showMess() = println("Hiển thị thông tin Button")
}

class CheckBox : InterfaceDemo {
    override fun click() {
        super.click()
        println("Bạn đã click vào checkbox")
    }

    override fun showMess() {
        super.showMess()
        println("Hiện thị thông tin cá nhân")
    }

}

//data class
data class Student2(var name: String, var age: Int, var gender: String, val id: Int) {
    override fun equals(other: Any?): Boolean {
        if(this===other) return true
        if (other ==null || other !is Student2) return false
        return name==other.name && age==other.age && gender==other.gender && id==other.id
    }

    override fun toString(): String {
        return "$name $age $gender $id"
    }

    override fun hashCode(): Int {
        var result = 31 * id+ name.hashCode() + age
        return result
    }
}


//MySingleton chỉ tạo ra 1 instance trong toàn bộ chương trình và được khai báo toàn cục
object MySingleton {
    var count = 0
    fun printCount() {
        println("Số lần gọi là $count")

    }
}

// companion object là một đối tượng được khai báo bên trong một lớp nhưng ko phải thể hiện của 1 lớp khi gọi chỉ ccaanfleen tên lớp để gọi ra ,
class MyClass {
    companion object {
        var name = "Tài"
        fun printName() {
            println("Tên là $name")

        }
    }
}

//enum : định nghĩa tập hợp các hằng số coos định
enum class EnumDemo {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun
}


//sealed class : Trả về các trạng thái
sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val error: String, var callError: Exception? = null) : Result<Nothing>()
}


class OuterClass {
    private var outerValue: String = "Code bên ngoài NestedClass"

    //Nested Class : là 1 lớp bên trong 1 lớp khác không theer truy cập đến thành phần ở lớp chứa nó
    class NestedClass {
        var description: String = "Code bên trong NestedClass"
        var nesterValue: String = "Tài"
        fun printDescription(): String {
            //   println("$outerValue") : không thể truy cập ở bên ngoài lớp NestedClass
            return nesterValue
        }

    }

    //Inner Class : tương tự như nested class nhưng khi khai báo có thêm inner và nó có thể truy cập đến thành phần của Outer class ( lớp chứa nó)
    inner class InnerClass {
        var description: String = "Code bên trong InnerClass"
        fun printDescription(): String {
            return "$outerValue $description" //Có thể truy cập ở bên ngoài
        }
    }

}



