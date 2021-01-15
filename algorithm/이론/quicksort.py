# print('hello')
# def quick_sort(arr) :
#     if len(arr) <= 1:
#         return arr
#     pivot = arr[len(arr)//2]
#     lesser_arr, equal_arr, greater_arr = [],[],[]
#     for num in arr:
#         if num<pivot:
#             lesser_arr.append(num)
#         elif num>pivot:
#             greater_arr.append(num)
#         else :
#             equal_arr.append(num)
#     return quick_sort(lesser_arr) + equal_arr + quick_sort(greater_arr)
#
# arr = [3,1,99,2,34, 21]
# print(quick_sort(arr))

#매번 재귀 호출될 때마다 새로운 리스트 생성하고 리턴하기 때문에 메모리 사용 측면에서 비효율적 입니다. 메모리 사용이 적은 in-place 정렬이 선호
arr = [3,1,99,2,34, 21]
def quick_sort_in_place(arr) :
    def sort(low, high) :
        if high <= low :
            return
        mid = partition(low, high)
        sort(low, mid-1)
        sort(mid, high)

    def partition(low, high) :
        pivot = arr[(low+high)//2]
        while low <= high :
            while arr[low] < pivot :
                low += 1
            while arr[high] > pivot :
                high -= 1
            if low <= high :
                arr[low], arr[high] = arr[high], arr[low]
                low, high = low +1, high -1
        return low
    return sort(0, len(arr)-1)

print(quick_sort_in_place(arr))