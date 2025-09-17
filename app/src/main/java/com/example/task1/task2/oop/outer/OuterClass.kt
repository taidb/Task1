package com.example.task1.task2.oop.outer

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

