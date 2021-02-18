package d12

import (
	"fmt"
)

func matrixScore(A [][]int) int {

	rows := len(A)
	columns := len(A[0])
	col := make([]int, columns)

	for _, ints := range A {
		for i := range ints {
			if ints[0] == 0 {
				col[i] += ints[i] ^ 1
			} else {
				col[i] += ints[i]
			}
		}

	}
	res := 0
	for bit := columns - 1; bit >= 0; bit-- {
		index := columns - 1 - bit
		if rows-col[index] > col[index] {
			res += (rows - col[index]) * (1 << bit)
		} else {
			res += col[index] * (1 << bit)
		}
		fmt.Println(rows-col[index], col[index], res)

	}
	return res

}
