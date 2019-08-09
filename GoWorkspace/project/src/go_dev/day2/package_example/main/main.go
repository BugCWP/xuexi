package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main()  {
	fmt.Printf("请输入数字：")
	str:=bufio.NewReader(os.Stdin);
    input,err:=str.ReadString('\n');
	num,err:=strconv.Atoi(input);
	if err !=nil{
		fmt.Println("输入错误,请输入正确数字")
	}
	for i:=0;i<num;i++ {
         println("%d+%d=%d",i,num-i,num);
	}
}
