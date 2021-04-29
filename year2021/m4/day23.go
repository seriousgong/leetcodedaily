package m4

func largestDivisibleSubset(nums []int) []int {
	mp := map[int]int{}
	for i := 0; i < len(nums); i++ {
		mp[nums[i]]++
	}
	res := make([]int, 0)
	for i := range mp {
		delete(mp, i)
		arr := []int{i}
		for num := range mp {
			if num%i == 0 {
				delete(mp, num)
				arr = append(arr, num)
			}
		}
		length2 := len(mp)
		if len(res) < len(arr) {
			res = arr
		}
		if len(res) > length2 {
			break
		}
	}
	return res
}
