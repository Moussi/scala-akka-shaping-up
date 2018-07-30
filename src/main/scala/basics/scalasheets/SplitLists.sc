val list= List(5,1,2,3,4,5)

/**
  * split list into lists while condition is validated
  * whenever condition is false span split immediately the list
  */
val spannedList = list.span(_>3)
val groupedList = list.groupBy(_>3).values
val partitionList = list.partition(_>3)
val splitAtList = list.splitAt(3)
