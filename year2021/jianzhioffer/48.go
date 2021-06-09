package jianzhioffer

func lengthOfLongestSubstring(s string) int {
	alphet := map[byte]int{}
	res := 0
	for i, j := 0, 0; i < len(s); i++ {
		if index, exist := alphet[s[i]]; exist {
			for ; j <= index; j++ {
				alphet[s[i]]--
			}
		}
		alphet[s[i]] = i
		if res < i-j {
			res = i - j
		}
	}
	return res
}
