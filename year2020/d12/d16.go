package d12

import "strings"

func wordPattern(pattern string, s string) bool {

	s = strings.Trim(s, " ")
	if pattern == "" && s != "" {
		return false
	}
	split := strings.Split(s, " ")
	if len(pattern) != len(split) {
		return false
	}
	mp := map[string]byte{}
	strs := make([]string, 26)
	for i, s2 := range split {
		if mp[s2] == 0 && strs[i] == "" {
			mp[s2] = pattern[i]
			strs[pattern[i]] = s2

		} else if mp[s2] != pattern[i] || strs[pattern[i]] != s2 {
			return false
		}
	}
	return true
}
