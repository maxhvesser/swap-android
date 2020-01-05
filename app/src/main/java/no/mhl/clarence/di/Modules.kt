package no.mhl.clarence.di

import no.mhl.clarence.ui.activity.MainViewModel
import no.mhl.clarence.ui.home.HomeFragment
import no.mhl.clarence.ui.home.HomeViewModel
import org.koin.dsl.module

// region Main Module
val mainModule = module {
    factory { MainViewModel() }
}
// endregion

// region Home Module
val homeModule = module {
    single { HomeFragment() }
    factory { HomeViewModel() }
}
// endregion