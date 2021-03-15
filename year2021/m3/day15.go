package m3

func spiralOrder(matrix [][]int) []int {
	res := make([]int, 0)
	var cycle func(a, b, width, length int)
	cycle = func(a, b, width, length int) {
		if width <= 0 || length <= 0 {
			return
		}
		for i := b; i < width+b; i++ {
			res = append(res, matrix[a][i])
		}
		for i := a + 1; i < length+a; i++ {
			res = append(res, matrix[i][b+width-1])
		}
		if length > 1 {
			for i := width - 2 + b; i >= b; i-- {
				res = append(res, matrix[a+length-1][i])
			}
		}
		if width > 1 {
			for i := length - 2 + a; i > a; i-- {
				res = append(res, matrix[i][b])
			}
		}
		cycle(a+1, b+1, width-2, length-2)
	}
	cycle(0, 0, len(matrix[0]), len(matrix))
	return res
}
