package week234

func numDifferentIntegers(word string) int {
	mp := map[int]int{}
	bs := []byte(word)
	l := 0
	for i := 0; i < len(bs); i++ {
		if bs[i] >= 'a' && bs[i] <= 'z' {
			bs[i] = ' '
			if i > l {
				val := 0
				for j := l; j < i; j++ {
					val = val*10 + int(bs[j]-'a')
				}
				mp[val]++
				l = i + 1
			}
		}
	}
	return len(mp)
}
