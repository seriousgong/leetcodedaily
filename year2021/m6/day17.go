package m6

func isNumber(s string) bool {

	prefix1, prefix2, ePrefix, plusSub := false, false, false, false
	for i := 0; i < len(s); i++ {
		if s[i] != 'e' && s[i] != '+' && s[i] != '-' && s[i] != '.' && s[i] < '0' && s[i] > '9' {
			return false
		}
		if s[i] == 'e' {
			// e之后必须为整数
			if ePrefix || !(prefix1 || prefix2) {
				return false
			}
			ePrefix = true
		}
		if s[i] == '+' || s[i] == '-' {
			if plusSub {
				return false
			}
			plusSub = true
		}
	}
	return true
}
