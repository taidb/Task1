package com.example.task1.task2.oop.model

//data class : lưu trữ dữ liệu và có tự động tạo thêm các thuộc tính như equals, hashCode, toString,cope,...
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