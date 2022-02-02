package id.gits.library.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import id.gits.library.domain.repository.AppRepository
import id.gits.library.presenter.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class, AppModule::class, ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun provideRepository(): AppRepository

    fun inject(activity: MainActivity)
}