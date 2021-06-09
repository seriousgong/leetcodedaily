package dailypractice

import "sort"

func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	// 固定一数
	for i := 0; i < len(nums); i++ {
		if i != 0 && nums[i] == nums[i-1] {
			continue
		}
		for l, r := i+1, len(nums)-1; l < r; {
			if sum := nums[i] + nums[l] + nums[r]; sum < 0 {
				l++
			} else if sum > 0 {
				r--
			} else {
				if l == 0 && r == len(nums)-1 || nums[l] != nums[l-1] || nums[r] != nums[r+1] {
					res = append(res, []int{nums[i], nums[l], nums[r]})
				}
				l++
				r--
			}
		}
	}
	return res
}
