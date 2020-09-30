package io.henrikhorbovyi.instafake.entity

object Mocks {

    val stories = mutableListOf(
        Story("henrique", "https://ca.slack-edge.com/T0JV0MYCE-U011QJZGF09-8606006c9e99-512"),
        Story("dudurg", "https://ca.slack-edge.com/T0JV0MYCE-U011BDUJF1V-e80b5dbf4cc9-512"),
        Story("victor", "https://ca.slack-edge.com/T0JV0MYCE-US9LJ5H6V-0cd211901285-512"),
        Story("rodox", "https://ca.slack-edge.com/T0JV0MYCE-UNJ70GWUS-5a8facc24196-512"),
        Story("mr. white", "https://ca.slack-edge.com/T0JV0MYCE-U019JQ2MUET-21e99264709f-512"),
        Story("fulige", "https://ca.slack-edge.com/T0JV0MYCE-UHPC012CT-af0c1faeee08-512")
    )

    val posts = listOf(
        Post(
            userName = "lukspedrosa",
            profilePicture = "https://scontent-gru2-2.cdninstagram.com/v/t51.2885-19/s150x150/108313686_941178686294343_7279831360754606688_n.jpg?_nc_ht=scontent-gru2-2.cdninstagram.com&_nc_ohc=eRLZ_-nlwi0AX9fSxFM&oh=d368987121b6e6daec6c5d81e261de20&oe=5F9F584A",
            picture = "https://images.unsplash.com/photo-1472718888560-1a1292f1cccb?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
            description = "Desenvolvimento de sistemas em Clojure, juntamente com Datomic, Kafka e integrações com sistemas legados internos."
        ),
        Post(
            userName = "Manu",
            profilePicture = "https://images.unsplash.com/photo-1592333613338-09c31dee7fa5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            picture = "https://images.unsplash.com/photo-1569129427431-8dc5eb70e699?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            location = "Miami"
        ),
        Post(
            userName = "dudurg",
            profilePicture = "https://ca.slack-edge.com/T0JV0MYCE-U011BDUJF1V-e80b5dbf4cc9-512",
            picture = "https://avatars2.githubusercontent.com/u/42151534?s=400&u=069a65116ec9da6427b21e03626009b8416df4e4&v=4",
            description = "dudurg  Aqui em Rolândia o dia está quente hoje (10ºC), o que facilita o desenvolvimento de sistemas em Android, deixando tudo bem gostoso.",
            location = "Rolândia"
        ),
        Post(
            userName = "maicon",
            profilePicture = "https://avatars2.githubusercontent.com/u/42151534?s=400&u=069a65116ec9da6427b21e03626009b8416df4e4&v=4",
            picture = "https://images.unsplash.com/photo-1452193550078-d7e45d3b834d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1052&q=80",
            location = "Boston"
        ),
    )

}