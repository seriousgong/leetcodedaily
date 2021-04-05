package year2021

import "sort"

func purchasePlans(nums []int, target int) int {
	sort.Ints(nums)
	res := 0
	for i := 0; i < len(nums); i++ {
		l, r, val := i+1, len(nums)-1, target-nums[i]
		for l <= r {
			mid := (l + r) / 2
			if nums[mid] > val {
				r = mid - 1
			} else {
				l = mid + 1
			}
		}
		res += l - i - 1
	}
	return res % 1000000007
}
