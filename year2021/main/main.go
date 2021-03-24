package main

import (
	"fmt"
	"go/types"
)

func main() {
	var i interface{} = nil
	switch i.(type) {
	case int:
	case float64:
	case types.Nil:
		fmt.Println("nil")
	default:
		fmt.Printf("%T", i)
	}
}
