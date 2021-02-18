package m1

import "fmt"

func maximumProduct(nums []int) int {
	max1, max2, max3, min1, min2, min3 := -1001, -1002, -1003, 1001, 1002, 1003
	for _, val := range nums {
		if val > max1 {
			max1, max2, max3 = val, max1, max2
		} else if val > max2 {
			max2, max3 = val, max2
		} else if val > max3 {
			max3 = val
		}
		if val < min1 {
			min1, min2, min3 = val, min1, min2
		} else if val < min2 {
			min2, min3 = val, min2
		} else if val < min3 {
			min3 = val
		}
	}
	fmt.Println(max1, max2, max3, min1, min2, min3)
	return max20(max1*max2*max3, min1*min2*max1)
}
func max20(a, b int) int {
	if a > b {
		return a
	}
	return b
}
