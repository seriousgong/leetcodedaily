package m4

import (
	"math"
)

func maxSumSubmatrix(matrix [][]int, k int) int {
	// 二维前缀和
	m, n := len(matrix), len(matrix[0])
	sum := make([][]int, m+1)
	for i := range sum {
		sum[i] = make([]int, n+1)
	}
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1]
			if matrix[i-1][j-1] == k || sum[i][j] == k {
				return k
			}
		}
	}
	res := math.MinInt64
	for a := 1; a < m+1; a++ {
		for b := 1; b < n+1; b++ {
			//gudingmeigeqishidian
			for i := a; i < m+1; i++ {
				for j := b; j < n+1; j++ {
					tmp := sum[i][j] - sum[i][b-1] - sum[a-1][j] + sum[a-1][b-1]
					if tmp < k {
						if res < tmp {
							res = tmp
						}
					} else if tmp == k {
						return k
					}
				}
			}
		}
	}
	return res
}
