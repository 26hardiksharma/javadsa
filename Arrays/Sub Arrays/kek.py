
def countMajoritySubarrays(nums, target: int) -> int:
    exists =False
    for i in nums:
        if(i==target):
            exists =True
    if exists == False:
        return 0
    subarrays = []
    result = []
    n = len(arr)
    ret = 0
    for i in range(n):
        for j in range(n, i, -1):
            result.append(arr[i:j])
    for arr in subarrays:
        half = len(arr)//2
        count = 0
        for k in arr:
            if k == target:
                count = count+1
        if(count>=half):
            ret+=1
    return ret

arr = [1,1,1,1]
print(countMajoritySubarrays(arr,2))