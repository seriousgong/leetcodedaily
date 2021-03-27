package exam4

import "fmt"

func removeKdigits(num string, k int) string {
	if len(num) <= k {
		return "0"
	}
	bs := []byte(num)
	for k > 0 {
		for i := 0; i < len(bs)-1 && k > 0; {
			if bs[i] > bs[i+1] {
				bs = append(bs[:i], bs[i+1:]...)
				fmt.Println(bs[:i], bs[i+1:])
				if i > 0 {
					i--
				}
				k--
				fmt.Println(k)
			} else {
				i++
			}
		}
		for len(bs) > 0 && k > 0 {
			bs = bs[:len(bs)-1]
		}

	}
	for len(bs) > 0 && bs[0] == '0' {
		bs = bs[1:]
	}
	if len(bs) == 0 {
		bs = append(bs, '0')
	}
	return string(bs)
}
