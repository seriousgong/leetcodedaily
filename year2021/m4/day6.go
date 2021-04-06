package m4

func removeDuplicates(nums []int) int {
	res := 0
	for i := 0; i < len(nums); i++ {
		// 保持距离为2的两个元素不相等，即满足题目条件
		if res < 2 || nums[i] != nums[res-2] {
			nums[res] = nums[i]
			res++
		}
	}
	return res
}
