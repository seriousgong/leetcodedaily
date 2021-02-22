package m2

func isToeplitzMatrix(matrix [][]int) bool {
	for i, val := range matrix[0] {
		for x, y := 0, i; x < len(matrix) && y < len(matrix[0]); x, y = x+1, y+1 {
			if matrix[x][y] != val {
				return false
			}
		}
	}
	for i := 1; i < len(matrix); i++ {
		for x, y, val := i, 0, matrix[i][0]; x < len(matrix) && y < len(matrix[0]); x, y = x+1, y+1 {
			if matrix[x][y] != val {
				return false
			}
		}
	}
	return true
}
