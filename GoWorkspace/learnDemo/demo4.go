package main

import "fmt"

type crilic struct {
	radious float64
}

func main()  {
	var  c1  crilic
	c1.radious=11
	fmt.Println(c1.getArea())
}

func (c crilic)getArea() float64  {
	return 3.14*c.radious*c.radious
}