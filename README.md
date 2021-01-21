# SortingTool
This program can sort data lexicographically in the case of words or whole lines and it can naturally sort numbers.
Arguments are passed via command line (order doesnt matter):
- dataType long/word/line
- sortingType natural/byCount
- inputFile anyName.txt
- outputFile anyName.txt

You can input a file or write the to be sorted elements in the console yourself.
If you give the path to an outputFile it will output the ordered sequence there.
It sorts numbers via merge sort algorithm and is thus highly efficient.

It is also possible to sort the elements by number of occurences (byCount).
Default sorting type is natural.
