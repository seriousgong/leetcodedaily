package m1

func findCircleNum(isConnected [][]int) (res int) {
	citys := make([]int, len(isConnected))
	/*初始指向自己*/
	for i := 0; i < len(isConnected); i++ {
		citys[i] = i
	}
	var find func(i int) int
	find = func(i int) int {
		if i != citys[i] {
			citys[i] = find(citys[i])
		}
		/*顶层节点指向自己*/
		return citys[i]
	}
	var union func(a, b int)
	union = func(a, b int) {
		/*这里选择总是以a的顶层节点为准*/
		citys[find(b)] = find(a)
	}

	for i := range isConnected {
		for i2 := i + 1; i2 < len(isConnected); i2++ {
			if isConnected[i][i2] == 1 {
				union(i, i2)
			}
		}
	}
	for i, val := range citys {

		/*有几个顶层节点，即有几个城市群*/
		if i == val {
			res++
		}
	}
	return
}
