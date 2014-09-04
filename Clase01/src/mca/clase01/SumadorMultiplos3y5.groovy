package mca.clase01

println ((0..1000).findAll { k ->
    (k % 3 == 0) || (k % 5 == 0)
}.sum())
