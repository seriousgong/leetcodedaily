package m2

func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}
	if s1 == "" && s2 == "" {
		return true
	}
	alph1 := make([]int, 26)
	alph2 := make([]int, 26)
	for _, val := range s1 {
		alph1[val-'a']++
	}
	for i := 0; i < len(s1); i++ {
		alph2[int(s2[i])-'a']++
	}
	if check(alph1, alph2) {
		return true
	}
	start := 0
	for i := len(s1); i < len(s2); i++ {
		alph2[int(s2[start])-'a']--
		alph2[int(s2[i])-'a']++
		if check(alph1, alph2) {
			return true
		}
		start++
	}
	return false
}
func check(a, b []int) bool {
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
