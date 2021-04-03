package week234

import "fmt"

func evaluate(s string, knowledge [][]string) string {

	mp := map[string]string{}
	for _, strings := range knowledge {
		mp[strings[0]] = strings[1]
	}
	bs := []byte(s)
	j := 0
	for i := 0; i < len(bs); i++ {
		switch bs[i] {
		case '(':
			j = i
		case ')':
			arr1, arr2 := bs[:j], bs[i+1:]
			fmt.Println(j, i, string(bs[j+1:i]))
			if val := mp[string(bs[j+1:i])]; val != "" {
				arr1 = append(arr1, []byte(val)...)
			} else {
				arr1 = append(arr1, '?')
			}
			i = len(arr1) - 1
			bs = append(arr1, arr2...)
		}
	}
	return string(bs)
}
