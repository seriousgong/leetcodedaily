package m5

func minChanges(nums []int, k int) int {
	arr := make([]map[int]int, k)
	min := -1
	for i := 0; i < k; i++ {
		arr[i] = make(map[int]int)
		for j := i; j < len(nums); j += k {
			mp := arr[i]
			arr[i][nums[i]]++
			if mp[mp[-1]] < mp[nums[i]] {
				mp[mp[-1]] = nums[i]
			}
		}
		if arr[min][arr[min][-1]] < arr[i][arr[i][-1]] {
			min = i
		}
	}
	for i := 0; i < len(nums); i++ {
		nums[i] =
	}
}
