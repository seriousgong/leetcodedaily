package m4

import (
	"sort"
	"strconv"
)

func largestNumber(nums []int) string {
	sort.Slice(nums, func(i, j int) bool {
		num1, num2 := nums[j], nums[i]
		for a1, b1 := nums[i], nums[j]; a1 > 0 || b1 > 0; {
			if a1 > 0 {
				num1 *= 10
				a1 /= 10
			}
			if b1 > 0 {
				num2 *= 10
				b1 /= 10
			}
		}
		if nums[i] == 0 {
			num1 *= 10
		}
		if nums[j] == 0 {
			num2 *= 10
		}

		return num1+nums[i] < num2+nums[j]
	})
	res := ""

	for len(nums) > 1 && nums[0] == 0 {
		nums = nums[1:]
	}
	for _, num := range nums {
		res += strconv.Itoa(num)
	}
	return res
}
