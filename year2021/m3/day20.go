package m3

import (
	"strconv"
)

func evalRPN(tokens []string) int {
	stack := make([]int, 0)
	for _, token := range tokens {
		var val int
		if token == "+" {
			val = stack[len(stack)-2] + stack[len(stack)-1]
		} else if token == "-" {
			val = stack[len(stack)-2] - stack[len(stack)-1]
		} else if token == "*" {
			val = stack[len(stack)-2] * stack[len(stack)-1]
		} else if token == "/" {
			val = stack[len(stack)-2] / stack[len(stack)-1]
		} else {
			num, _ := strconv.Atoi(token)
			stack = append(stack, num)
			continue
		}
		stack = stack[:len(stack)-1]
		stack[len(stack)-1] = val
	}
	return stack[0]
}
