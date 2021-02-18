package d12

import "fmt"

func D17(prices []int, fee int) int {
	return maxProfit(prices, fee)
}
func maxProfit(prices []int, fee int) int {
	if prices == nil || len(prices) == 0 {
		return 0
	}
	dp := make([][2]int, len(prices))
	dp[0][0] = -prices[0]
	/*4个状态 0 买，1不买 ，2卖 ，3 不卖*/
	for i := 1; i < len(prices); i++ {
		/*有股票*/
		dp[i][0] = compareD17(dp[i-1][0], dp[i-1][1]-prices[i])
		/*没股票 1、昨天卖了，2今天卖了*/
		dp[i][1] = compareD17(dp[i-1][1], dp[i-1][0]+prices[i]-fee)
	}
	fmt.Println(dp)
	return dp[len(prices)-1][1]

}
func compareD17(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
