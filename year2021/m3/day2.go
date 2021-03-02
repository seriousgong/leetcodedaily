package m3

type NumMatrix struct {
	matrix [][]int
}

func Constructor(matrix [][]int) NumMatrix {
	mrtx := make([][]int, len(matrix))
	for i := 0; i < len(mrtx); i++ {
		mrtx[i] = make([]int, len(matrix[0])+1)
		for j := 0; j < len(matrix[i]); j++ {
			mrtx[i][j+1] = matrix[i][j] + mrtx[i][j]
		}
	}
	return NumMatrix{
		mrtx,
	}
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	sum := 0
	for i := row1; i <= row2; i++ {
		sum += this.matrix[i][col2+1] - this.matrix[i][col1]
	}
	return sum
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */
