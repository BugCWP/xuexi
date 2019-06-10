package main

import "fmt"

type cd func(int) int 

func main()  {
	testcallBack(1,callBack)
	testcallBack(2, func(x int) int {
		fmt.Printf("我是回调，x:%d",x)
		return x
	})
}

func testcallBack(x int,f cd)  {
	f(x)
}

func callBack(x int)  int{
	fmt.Printf("我是回调，x:%d\n",x)
	return  x
}