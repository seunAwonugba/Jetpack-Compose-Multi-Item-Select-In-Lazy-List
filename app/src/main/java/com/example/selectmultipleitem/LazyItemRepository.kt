package com.example.selectmultipleitem

class LazyItemRepository {
    fun getAllData() : List<LazyItemData>{
        return listOf(
            LazyItemData(
                "1",
                "Seun",
                "Awonugba",
                27
            ),
            LazyItemData(
                "2",
                "Temidayo",
                "Akinyele",
                29
            ),
            LazyItemData(
                "3",
                "Gbowunmi",
                "Makinde",
                24
            ),
            LazyItemData(
                "4",
                "Deborah",
                "Akinsuoye",
                27
            ),
            LazyItemData(
                "5",
                "Yewande",
                "Awonugba",
                25
            ),
            LazyItemData(
                "6",
                "Yetunde",
                "Alimi",
                26
            )
        )
    }
}