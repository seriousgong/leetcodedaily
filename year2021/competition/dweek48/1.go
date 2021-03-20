package dweek48

func secondHighest(s string) int {
	max, smax := -1, -1
	for i, val := range s {
		if s[i] >= '0' && s[i] <= '9' {
			if int(val) > max {
				smax = max
				max = int(val)
			} else if int(val) < max {
				if smax < int(val) {
					smax = int(val)
				}
			}
		}
	}
	if smax > -1 {
		return smax - '0'
	}
	return smax
}
