package m3

func reverseBits(num uint32) (res uint32) {

	cnt := 31
	for ; num > 0; num /= 2 {
		res = res * 2
		if num%2 != 0 {
			res += 1
		}
		cnt--
	}
	return res << cnt
}
