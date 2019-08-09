package main

import (
	"fmt"
	"os"
)

func main()  {
	var goos string  =os.Getenv("GOOS")
	fmt.Println("the operating system is:%s\n",goos)
	path:=os.Getenv("PATH")
	fmt.Println("Path is:%s",path)
}