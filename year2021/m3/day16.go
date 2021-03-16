package m3

func generateMatrix(n int) [][]int {
	res := make([][]int, n)
	for i := range res {
		res[i] = make([]int, n)
	}
	var cycle func(l, r, num, length, width int)
	cycle = func(l, r, num, length, width int) {
		if length <= 0 || width <= 0 {
			return
		}
		for i := r; i < l+width; i++ {
			res[l][i], num = num, num+1
		}
		for i := l + 1; i < l+length; i++ {
			res[i][r+width-1], num = num, num+1
		}
		if length > 1 {
			for i := r + width - 2; i >= r; i-- {
				res[l+length-1][i], num = num, num+1
			}
		}
		if width > 1 {
			for i := l + length - 2; i > l; i-- {
				res[i][r], num = num, num+1
			}
		}
		length, width = length-2, width-2
		cycle(l+1, r+1, num, length, width)
	}
	cycle(0, 0, 1, n, n)
	return res
}
