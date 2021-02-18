package d12

func firstUniqChar(s string) int {

	alphet := make([]int, 26)

	for _, val := range s {
		alphet[val-'a']++
	}
	for i, val := range s {
		if alphet[val-'a'] == 1 {
			return i
		}
	}
	return -1
}
