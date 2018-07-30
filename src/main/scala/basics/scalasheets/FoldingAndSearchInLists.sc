val list = List(("a",5), ("b", 3), ("c",8))

list.take(2).exists(_._1 == "c")


