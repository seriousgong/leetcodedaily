package exam1

func findRepeatedDnaSequences(s string) []string {
	res := make([]string, 0)
	mp := map[string]int{}
	for l, r := 0, 10; r <= len(s); l++ {
		if mp[s[l:r]] == 0 {
			mp[s[l:r]]++
		} else if mp[s[l:r]] == 1 {
			res = append(res, s[l:r])
			mp[s[l:r]]++
		}
		r++
	}
	return res
}
