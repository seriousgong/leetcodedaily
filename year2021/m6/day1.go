package m6

func canEat(candiesCount []int, queries [][]int) []bool {
	prefix := make([]int, len(candiesCount)+1)
	for i := 1; i <= len(candiesCount); i++ {
		prefix[i] = prefix[i-1] + candiesCount[i-1]
	}
	res := make([]bool, len(queries))
	for i, arr := range queries {
		min := prefix[arr[0]]/arr[2] + 1
		max := prefix[arr[1]+1]
		res[i] = arr[1]+1 >= min && arr[1]+1 <= max
	}
	return res
}
