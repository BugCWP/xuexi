package main

import (
	"fmt"
	"time"
)

//var papie chan int

func test_print(c int) {

	fmt.Println(c)
}
func test_pipe() {
	pipe := make(chan int, 3)
	pipe <- 1
	pipe <- 2
	pipe <- 3
	//pipe<-4
	fmt.Println(len(pipe))
}
func add(a int, b int, c chan int) {
	time.Sleep(2 * time.Second)
	c <- a + b
	return
}

func main() {
	//for i :=0;i<100 ;i++  {
	//	go test_print(i)
	//}
	//fmt.Println("start")
	//go test_pipe()
	//fmt.Println("end")
	var papie chan int
	papie = make(chan int, 1)
	go add(10, 12, papie)
	sum := <-papie
	fmt.Println(sum)
}
