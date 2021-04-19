package m4

func isScramble(s1 string, s2 string) bool {
	mp := map[string]bool{}
	var dfs func(str1, str2 string) bool
	dfs = func(str1, str2 string) bool {
		if len(str1) != len(str2) {
			return false
		}
		if value, ok := mp[str1+str2]; ok {
			return value
		}
		if len(str1) == 1 {
			mp[str1+str2] = str1 == str2
			return str1 == str2
		}
		if str1 == str2 {
			return true
		}
		a, b := make([]int, 26), make([]int, 26)
		for i := range str2 {
			b[str1[i]-'a']++
			a[str2[i]-'a']++
		}
		if equals(b, a) {
			for i := 1; i < len(str2); i++ {
				if (dfs(str1[i:], str2[i:]) && dfs(str1[:i], str2[:i])) || (dfs(str2[:i], str1[len(str1)-i:]) && dfs(str2[i:], str1[0:len(str1)-i])) {
					return true
				}
			}
		}
		mp[str1+str2] = false
		return false
	}
	return dfs(s1, s2)
}
func equals(a, b []int) bool {
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
