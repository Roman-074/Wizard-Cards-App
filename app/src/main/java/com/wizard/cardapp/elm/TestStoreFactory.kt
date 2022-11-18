package com.wizard.cardapp.elm

import vivid.money.elmslie.coroutines.ElmStoreCompat

fun storeFactory() = ElmStoreCompat(
    State(),
    TestReducer,
    TestActor
)