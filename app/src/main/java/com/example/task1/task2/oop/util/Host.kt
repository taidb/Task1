package com.example.task1.task2.oop.util


//khai báo phần mở rộng của 1 lớp bên trong lớp khác
class Host(var hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}
class Connection(var host: Host, var port: Int) {
    fun printPort() {
        print(port)
    }

    fun Host.printConnectionString() {
        printHostname()
        print(":")
        printPort()
    }

    fun connect() {
        host.printConnectionString()
    }
}