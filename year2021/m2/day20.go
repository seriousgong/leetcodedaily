package m2

func findShortestSubArray(nums []int) int {
	res, mp, maxc := len(nums), map[int][]int{}, 0
	for i, val := range nums {
		if mp[val] != nil {
			mp[val][1]++
		} else {
			mp[val] = []int{i, 1}
		}
		if length := i - mp[val][0] + 1; mp[val][1] > maxc {
			res = length
			maxc = mp[val][1]
		} else if mp[val][1] == maxc && length < res {
			res = length
		}
	}
	return res
}
