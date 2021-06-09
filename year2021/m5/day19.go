package m5

func kthLargestValue(matrix [][]int, k int) int {
	m, n := len(matrix), len(matrix[0])
	arr := make([]int, m*n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 {
				if j > 0 {
					matrix[i][j] = matrix[0][j-1] ^ matrix[0][j]
				}
			} else if j == 0 {
				if i > 0 {
					matrix[i][j] = matrix[i-1][0] ^ matrix[i][0]
				}
			} else {
				matrix[i][j] = matrix[i][j] ^ matrix[i-1][j] ^ matrix[i][j-1] ^ matrix[i-1][j-1]
			}
			arr[i*n+j] = matrix[i][j]
		}
	}
	return arr[quickSort(0, len(arr)-1, k, arr)]
}
func quickSort(l, r, k int, arr []int) int {
	if l > r || r >= len(arr) || l < 0 {
		return -1
	}
	x, y := l, r
	for x < y {
		std := arr[l]
		for y < r && arr[y] > std {
			y--
		}
		for x < y && arr[x] < std {
			x++
		}
		if x < y {
			tmp := arr[x]
			arr[x], arr[y] = arr[y], tmp
		}
	}
	//基准数归位
	arr[x] = arr[l]
	if x == k {
		return x
	}
	res := quickSort(l, x-1, k, arr)
	if res == -1 {
		res = quickSort(x+1, r, k, arr)
	}
	return res
}
