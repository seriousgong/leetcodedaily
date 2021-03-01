package m3

type NumArray struct {
	prefixSum []int
}

func Constructor(nums []int) NumArray {
	prefixSum := make([]int, len(nums))
	if len(nums) != 0 {
		prefixSum[0] = nums[0]
		for i := 1; i < len(nums); i++ {
			prefixSum[i] = nums[i] + prefixSum[i-1]
		}
	}
	return NumArray{prefixSum: prefixSum}
}

func (this *NumArray) SumRange(i int, j int) int {
	// 根据取值范围无须做越界判断
	if i > 0 {
		return this.prefixSum[j] - this.prefixSum[i-1]
	}
	return this.prefixSum[j] - 0
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(i,j);
 */
