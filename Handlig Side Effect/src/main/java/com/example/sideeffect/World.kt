package com.example.sideeffect

typealias World = Unit

typealias SideEffect = (World) -> World

typealias WorldT<T> = (World) -> Pair<T, World>

infix fun <A, B> WorldT<A>.myOp(fn: (A) -> WorldT<B>): WorldT<B> = TODO()