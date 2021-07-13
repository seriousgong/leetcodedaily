package m7

func hIndex(citations []int) int {
	l, r := 0, len(citations)-1
	for l < r {
		mid := l + (r-l)/2
		if citations[mid] < len(citations)-mid {
			l = mid + 1
		} else {
			r = mid
		}
	}
	if citations[l] == 0 {
		return 0
	}
	return l
}
