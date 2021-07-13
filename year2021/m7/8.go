package m7

import "fmt"

func numSubarraysWithSum(nums []int, goal int) int {
	res, sum1, sum2, l1, l2 := 0, 0, 0, 0, 0
	for i := 0; i < len(nums); i++ {
		sum1 += nums[i]
		sum2 += nums[i]
		for ; l1 < len(nums) && sum1 > goal; l1++ {
			sum1 -= nums[l1]
		}
		for ; l2 < len(nums) && sum2 >= goal; l2++ {
			sum2 -= nums[l2]
		}
		res += l2 - l1
	}

	return res

}
