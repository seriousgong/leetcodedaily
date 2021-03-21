package exam3

func rotate(matrix [][]int) {
	n := len(matrix)
	for i := 0; i < len(matrix)/2+1; i++ {
		for j := i; j < len(matrix)-1; j++ {
			tmp := matrix[i][j]
			matrix[i][j] = matrix[n-j-1][i]
			matrix[n-j-1][i] = matrix[n-i-1][n-j-1]
			matrix[n-i-1][n-j-1] = matrix[j][n-i-1]
			matrix[j][n-i-1] = tmp
			//= matrix[n-j-1][i], matrix[n-i-1][n-j-1], matrix[j][n-i-1], matrix[i][j]
		}
	}
}
