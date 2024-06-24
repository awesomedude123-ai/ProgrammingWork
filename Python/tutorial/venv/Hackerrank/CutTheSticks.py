def cutTheSticks(arr):
    arr.sort()
    array = [len(arr)]
    count = 0
    for element1 in range(0,len(arr)):
        least = arr[0]
        for element in arr[::]:
            element = element - least
            if element == 0:
                arr.pop(count)
            else:
                arr[count] = element
                count = count + 1
        if len(arr)==0:
            break
        else:
            array.append(len(arr))
            count = 0
    arr.count()
    return array
print(cutTheSticks([6,4,2,1,6]))