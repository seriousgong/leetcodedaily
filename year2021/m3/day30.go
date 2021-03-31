package m3

func searchMatrix(matrix [][]int, target int) bool {
	m, n := len(matrix), len(matrix[0])
	for x, y := 0, m*n-1; x <= y; {
		mid := (x + y) / 2
		if matrix[mid/n][mid%n] < target {
			x = mid + 1
		} else if matrix[mid/n][mid%n] > target {
			y = mid - 1
		} else {
			return true
		}
	}
	return false
}
