package week232

func areAlmostEqual(s1 string, s2 string) bool {
	var c1, c2 byte
	count := 1
	for i := 0; i < len(s1); i++ {
		if s1[i] != s2[i] {
			if count == 0 {
				return false
			}
			if c1 == 0 {
				c1 = s1[i]
				c2 = s2[i]
			} else {
				if c1 == s2[i] && c2 == s1[i] {
					c1 = 0
					c2 = 0
					count--
				} else {
					return false
				}
			}
		}
	}
	return c1 == 0 && c2 == 0
}
