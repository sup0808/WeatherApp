package `in`.religareweather.com

import `in`.religareweather.com.data.repository.AppRepository
import `in`.religareweather.com.ui.loadScreen.LoadViewModel
import io.reactivex.Maybe
import io.reactivex.Observer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MainViewModelTest {



    @Mock
    lateinit var appRepository: AppRepository

    lateinit var mainViewModel: LoadViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mainViewModel = LoadViewModel(appRepository)
    }
/*
    @Test
    fun fetchCurrentWeather_positiveResponse() {
        // Mock API response
        Mockito.`when`(this.appRepository.GetCurrentWeather(ArgumentMatchers.anyString()).thenAnswer {
            return@thenAnswer Maybe.just(ArgumentMatchers.anyList<Repository>())
        }
        // Attacch fake observer
        val observer = mock(Observer::class.java) as Observer<LiveDataResult<List<Repository>>>
        this.mainViewModel.repositoriesLiveData.observeForever(observer)
        // Invoke
        this.mainViewModel.fetchUserRepositories(ArgumentMatchers.anyString())
        // Verify
        assertNotNull(this.mainViewModel.repositoriesLiveData.value)
        assertEquals(LiveDataResult.Status.SUCCESS, this.mainViewModel.repositoriesLiveData.value?.status)
    }*/
    //...
}