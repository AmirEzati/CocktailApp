package info.yazdan.cocktail

import android.app.Application
import info.yazdan.cocktail.data.database.AppDatabase
import info.yazdan.cocktail.data.network.Api
import info.yazdan.cocktail.data.network.NetworkConnectionInterceptor
import info.yazdan.cocktail.data.preference.PreferenceManager
import info.yazdan.cocktail.data.repository.DrinkRepository
import info.yazdan.cocktail.data.repository.IngredientRepository
import info.yazdan.cocktail.ui.feature.details.DetailsViewModelFactory
import info.yazdan.cocktail.ui.feature.search.SearchViewModelFactory
import info.yazdan.cocktail.ui.host.HostViewModelFactory
import io.fabric.sdk.android.Fabric
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this)
    }

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@App))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { Api(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceManager(instance()) }
        bind() from singleton { DrinkRepository(instance()) }
        bind() from singleton { IngredientRepository(instance(), instance(), instance()) }
        bind() from provider { SearchViewModelFactory(instance(), instance()) }
        bind() from provider { DetailsViewModelFactory(instance()) }
        bind() from provider { HostViewModelFactory() }
    }
}