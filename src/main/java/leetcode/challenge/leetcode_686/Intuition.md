Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

need check up o length b / length a + 1 not + 2 or + 3
in case length s > length b and not contain b

match more 2
there must be a match in the original string
abc abc ac abc
if math second one, it must match the first one