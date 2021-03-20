package dweek48

import "sort"

func getMaximumConsecutive(coins []int) int {
	sort.Ints(coins)
	res := 0
	for i := 0; i < len(coins); i++ {
		if coins[i]-1 > res {
			break
		}
		res = res + coins[i]
	}
	return res + 1
}
