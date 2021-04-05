package m4

func merge(nums1 []int, m int, nums2 []int, n int) {
	for i, x, y := m+n-1, m-1, n-1; i >= 0 && (x >= 0 || y >= 0); i-- {
		if x < 0 || (y >= 0 && nums1[x] < nums2[y]) {
			nums1[i] = nums2[y]
			y--
		} else {
			nums1[i] = nums1[x]
			x--
		}
	}
}
