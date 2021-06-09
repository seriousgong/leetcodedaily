package m5

func reverseParentheses(s string) string {
	bs := []byte(s)
	var dfs func(index, revseCnt int) (int, []byte)
	dfs = func(index, revseCnt int) (int, []byte) {
		str := make([]byte, 0)
		for i, l := index, 0; i < len(bs); i++ {
			var subStr []byte
			switch bs[i] {
			case '(':
				str = copy(str, bs[l:i], revseCnt%2 != 0)
				i, subStr = dfs(i+1, revseCnt+1)
				if revseCnt%2 == 0 {
					str = copy(str, subStr, false)
				} else {
					str = copy(subStr, str, false)
				}
				l = i + 1
			case ')':
				return i, str
				//	进行翻转后返回
			}
		}
		return len(bs), str
	}
	var cnt = 0
	if bs[0] == '(' {
		cnt = 1
	}
	_, res := dfs(0, cnt)
	return string(res)
}
func copy(src, dest []byte, reverse bool) []byte {
	if reverse {
		for i := 0; i < len(dest)-i; i++ {
			dest[i], dest[len(dest)-1-i] = dest[len(dest)-1-i], dest[i]
		}
		src = append(dest, src...)
	} else {
		src = append(src, dest...)
	}
	return src
}
