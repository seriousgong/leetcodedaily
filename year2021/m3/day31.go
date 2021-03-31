package m3

import "sort"

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	var dfs func(index int, tmp []int)
	dfs = func(index int, tmp []int) {
		arr := make([]int, len(tmp))
		copy(arr, tmp)
		res = append(res, arr)
		for i := index; i < len(nums); i++ {
			if i > index && nums[i] == nums[i-1] {
				continue
			}
			tmp = append(tmp, nums[i])
			dfs(i+1, tmp)
			tmp = tmp[:len(tmp)-1]
		}
	}
	dfs(0, []int{})
	return res
}
