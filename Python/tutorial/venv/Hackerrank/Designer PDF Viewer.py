def designerPdfViewer(h, word):
    li = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','br','s','t','u','v','w','x','y','z']
    num = 0
    for element in h:
        index = li.index(element)
        num1 = word[index]
        if num<num1:
            num=num1
    return num * 1 * len(h)

#li1 = a_list = collections.deque([1, 2, 3, 4, 5])



li1 = [1,2,3,4,5]
array = li1-1
print(array)