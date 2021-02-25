package m2

import "fmt"

func transpose(matrix [][]int) [][]int {
	l1, l2 := len(matrix), len(matrix[0])
	res := make([][]int, l2)
	if l1 == l2 {
		fmt.Println(1)
	}
	for i := range res {
		res[i] = make([]int, l1)
	}
	for i := 0; i < l2; i++ {
		for j := 0; j < l1; j++ {
			res[i][j] = matrix[j][i]
		}
	}
	return res
}
