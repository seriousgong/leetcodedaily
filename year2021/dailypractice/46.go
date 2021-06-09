package dailypractice

func permute(nums []int) [][]int {

	bools := make([]bool, len(nums))
	var res [][]int
	var dfs func(index int, arr []int)
	dfs = func(index int, arr []int) {
		if len(arr) == len(nums) {
			ar := make([]int, len(nums))
			copy(ar, arr)
			res = append(res, ar)
			return
		}
		for i := index; i < len(bools); i++ {
			if bools[i] {
				continue
			}
			arr = append(arr, nums[i])
			bools[i] = true
			dfs(i+1, arr)
			arr = arr[:len(arr)-1]
			bools[i] = false
		}
	}
	dfs(0, []int{})
	return res
}
