package m4

func containsNearbyAlmostDuplicate(nums []int, k int, t int) bool {

	mp := map[int]int{}
	f := func(num int) int {
		if num >= 0 {
			return num / (t + 1)
		}
		return (num+1)/(t+1) - 1 // -1 beacause num+1 <0 && nums+1 <t+1  fendao 0 hui yu num>0 num<t+1 chongtu
	}
	for i, num := range nums {
		key := f(num)
		if _, ok := mp[key]; ok {
			return true
		}
		if val, ok := mp[key-1]; ok && abs(num-val) <= t {
			return true
		}
		if val, ok := mp[key+1]; ok && abs(num-val) <= t {
			return true
		}
		mp[key] = num
		if i >= k {
			delete(mp, f(nums[i-k]))
		}
	}
	return false
}
func abs(a int) int {
	if a < 0 {
		a = -a
	}
	return a
}
