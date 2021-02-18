package d12

import "math"

func maxProfit_28(k int, prices []int) int {
	n := len(prices)
	buy := make([][]int, n)
	sell := make([][]int, n)

	k = min(k, len(prices)/2)
	for i := 0; i < n; i++ {
		buy[i] = make([]int, k+1)
		sell[i] = make([]int, k+1)
	}
	for i := 1; i <= k; i++ {
		buy[0][i] = math.MinInt64 / 2
		sell[0][i] = math.MinInt64 / 2
	}
	buy[0][0] = -prices[0]
	for i := 1; i < n; i++ {
		buy[i][0] = max28(buy[i-1][0], sell[i-1][0]-prices[i])
		for i1 := 1; i1 < k; i1++ {
			buy[i][i1] = max28(buy[i-1][i1], sell[i-1][i1]-prices[i])
			sell[i][i1] = max28(buy[i-1][i1-1]+prices[i], sell[i-1][i1])
		}
	}
	return max1(sell[n-1]...)

}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max28(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
func max1(a ...int) int {
	res := a[0]
	for _, v := range a[1:] {
		if v > res {
			res = v
		}
	}
	return res
}
